package com.code5.fw.web;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code5.fw.data.Box;
import com.code5.fw.data.BoxHttp;
import com.code5.fw.data.InitYaml;
import com.code5.fw.data.MakeRnd;
import com.code5.fw.data.SessionB;
import com.code5.fw.db.Transaction;
import com.code5.fw.trace.Trace;
import com.code5.fw.trace.TraceRunner;

/**
 * @author zero
 *
 */
public class MasterController extends HttpServlet implements Reload {

	/**
	 * 
	 */
	private static boolean isCache = InitYaml.get().isCache();

	/**
	 * 
	 */
	public String getRND() {
		return RND;
	}

	/**
	 * 
	 */
	private String RND = MakeRnd.createRnd(8);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private static Trace trace = new Trace(MasterController.class);

	/**
	 * @param request
	 * @param response
	 * @param box
	 * @param JSP_KEY
	 */
	private void forward(HttpServletRequest request, HttpServletResponse response, Box box, String JSP_KEY) {

		try {

			MasterControllerD dao = new MasterControllerD();
			Box view = dao.getView(JSP_KEY);
			box.put(Box.KEY_FW_VIEW, view);

			String TMPL_JSP = view.s("TMPL_JSP");
			String JSP = view.s("JSP");

			trace.write("TMPL_JSP [" + TMPL_JSP + "]");
			trace.write("VIEW [" + JSP + "]");

			String THIS_JSP = TMPL_JSP;
			if ("".equals(THIS_JSP)) {
				THIS_JSP = JSP;
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(THIS_JSP);
			box.setXssConvert(true);
			dispatcher.forward(request, response);

		} catch (Exception ex) {
			trace.write(ex);
		}
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Box box = new BoxHttp(request);
		BoxContext.setThread(box);
		Transaction transaction = Transaction.createTransaction(transationWas);
		TransactionContext.setThread(transaction);

		try {

			setBox(request, box);

			String KEY = box.s(Box.KEY_SERVICE);

			trace.write("KEY [" + KEY + "]");

			String JSP_KEY = execute(KEY);

			trace.write("JSP_KEY [" + JSP_KEY + "]");

			forward(request, response, box, JSP_KEY);

			transaction.commit();

		} catch (Exception ex) {

			forwardException(ex, request, response, box);

		} finally {

			closeAOP();

		}

	}

	/**
	 * @param ex
	 * @param request
	 * @param response
	 * @param box
	 */
	private void forwardException(Exception ex, HttpServletRequest request, HttpServletResponse response, Box box) {

		Box controller = box.getBox(Box.KEY_FW_CONTROLLER);
		String ERR_JSP_KEY = controller.s("ERR_JSP_KEY");
		if ("".equals(ERR_JSP_KEY)) {
			ERR_JSP_KEY = "errView";
		}

		try {
			TransactionContext.rollback();
		} catch (SQLException exx) {
			box.put(Box.KEY_EXCEPTION, exx);
			forward(request, response, box, ERR_JSP_KEY);
			return;
		}

		if (ex instanceof InvocationTargetException) {
			ex = (Exception) ex.getCause();
		}

		if (ex instanceof LoginException) {
			box.setAlertMsg("로그인이 필요합니다.");
			forward(request, response, box, "loginView");
			return;
		}

		box.put(Box.KEY_EXCEPTION, ex);
		forward(request, response, box, ERR_JSP_KEY);
		return;
	}

	/**
	 * @param hm
	 * @param KEY
	 * @return
	 */
	private static Object getCache(ConcurrentHashMap<String, ?> hm, String KEY) {

		if (!isCache) {
			return null;
		}
		return hm.get(KEY);
	}

	/**
	 * @param KEY
	 * @return
	 * @throws Exception
	 */
	private static Object[] createService(String KEY) throws Exception {

		MasterControllerD dao = new MasterControllerD();

		Box controller = dao.getController(KEY);
		BoxContext.getThread().put(Box.KEY_FW_CONTROLLER, controller);

		String CLASS_NAME = controller.s("CLASS_NAME");
		String METHOD_NAME = controller.s("METHOD_NAME");

		trace.write("execute [" + CLASS_NAME + "][" + METHOD_NAME + "]");

		Object biz = getCache(BIZ_CONTROLLER_MAP, KEY);

		if (biz == null) {

			@SuppressWarnings("rawtypes")
			Class newClass = Class.forName(CLASS_NAME);

			@SuppressWarnings({ "rawtypes", "unchecked" })
			Constructor constructor = newClass.getConstructor();

			biz = constructor.newInstance();

			if (!(biz instanceof BizController)) {
				throw new AuthException();
			}

			BIZ_CONTROLLER_MAP.put(KEY, biz);

		}

		Method method = (Method) getCache(METHOD_MAP, KEY + "." + METHOD_NAME);

		if (method == null) {

			method = biz.getClass().getDeclaredMethod(METHOD_NAME);

			METHOD_MAP.put(KEY + "." + METHOD_NAME, method);
		}

		ServiceAnnotation sa = (ServiceAnnotation) getCache(SERVICE_ANNOTATION_MAP, KEY + "." + METHOD_NAME);

		if (sa == null) {

			sa = (ServiceAnnotation) method.getAnnotation(ServiceAnnotation.class);

			if (sa == null) {

				sa = new ServiceAnnotation() {

					@Override
					public Class<? extends Annotation> annotationType() {
						return null;
					}

					@Override
					public boolean isLogin() {
						return false;
					}

					@Override
					public String errJspKey() {
						return null;
					}

					@Override
					public String auth() {
						return null;
					}
				};

			}

			SERVICE_ANNOTATION_MAP.put(KEY + "." + METHOD_NAME, sa);
		}

		Object[] service = new Object[3];
		service[0] = biz;
		service[1] = method;
		service[2] = sa;
		return service;

	}

	/**
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String execute(String KEY) throws Exception {

		Object[] service = createService(KEY);

		Object biz = service[0];
		Method method = (Method) service[1];
		ServiceAnnotation sa = (ServiceAnnotation) service[2];

		boolean checkUrlAuth = checkUrlAuth(sa);
		if (!checkUrlAuth) {
			throw new AuthException();
		}

		if (biz instanceof BizControllerStartExecute) {
			String JSP_KEY = ((BizControllerStartExecute) biz).start();
			if (JSP_KEY != null) {
				return JSP_KEY;
			}
		}

		String JSP_KEY = (String) method.invoke(biz);
		return JSP_KEY;

	}

	/**
	 * @param sa
	 * @return
	 * @throws Exception
	 */
	private static boolean checkUrlAuth(ServiceAnnotation sa) throws Exception {

		boolean isLogin = true;
		String auth = "";

		if (sa != null) {
			isLogin = sa.isLogin();
			auth = sa.auth();
		}

		if (!isLogin) {
			return true;
		}

		Box box = BoxContext.getThread();
		SessionB user = box.getSessionB();
		if (user == null) {
			throw new LoginException();
		}

		if ("".equals(auth)) {
			return true;
		}

		if (auth.indexOf(user.getAuth()) >= 0) {
			return true;
		}

		trace.write("checkUrlAuth false [" + auth + "][" + user.getAuth() + "]");

		return false;

	}

	/**
	 * 
	 * @param KEY
	 * @return
	 * @throws Exception
	 * 
	 */
	public static boolean checkUrlAuth(String KEY) throws Exception {

		Object[] service = createService(KEY);
		ServiceAnnotation sa = (ServiceAnnotation) service[2];

		return checkUrlAuth(sa);

	}

	/**
	 * @param request
	 * @return
	 */
	protected void setBox(HttpServletRequest request, Box box) throws Exception {

		request.setCharacterEncoding("UTF-8");

		String KEY = request.getPathInfo().substring(1);
		box.put(Box.KEY_SERVICE, KEY);

		box.put(Box.KEY_REMOTE_ADDR, request.getRemoteAddr());

		Object sessionB = request.getSession().getAttribute(Box.KEY_SESSIONB);
		if (sessionB instanceof SessionB) {
			box.put(Box.KEY_SESSIONB, sessionB);
		}

	}

	/**
	 * 
	 */
	private String transationWas = InitYaml.get().s("TRANSACTION.WAS");

	@Override
	public void destroy() {
		TraceRunner.getTraceRunner().flush();
		super.destroy();
	}

	/**
	 * 
	 */
	protected void closeAOP() {
		TransactionContext.removeThread();
		BoxContext.removeThread();
	}

	/**
	 *
	 */
	public void init() throws ServletException {
		reload();
		Admin.addReload(this);
	}

	/**
	 * 
	 */
	public void reload() {

		this.transationWas = InitYaml.get().s("TRANSACTION.WAS");

		SERVICE_ANNOTATION_MAP.clear();
		METHOD_MAP.clear();
		BIZ_CONTROLLER_MAP.clear();

		this.RND = MakeRnd.createRnd(8);
	}

	/**
	 * 
	 */
	private static ConcurrentHashMap<String, Object> BIZ_CONTROLLER_MAP = new ConcurrentHashMap<String, Object>();

	/**
	 * 
	 */
	private static ConcurrentHashMap<String, Method> METHOD_MAP = new ConcurrentHashMap<String, Method>();

	/**
	 * 
	 */
	private static ConcurrentHashMap<String, ServiceAnnotation> SERVICE_ANNOTATION_MAP = new ConcurrentHashMap<String, ServiceAnnotation>();
}
