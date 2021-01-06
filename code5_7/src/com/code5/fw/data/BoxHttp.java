package com.code5.fw.data;

import javax.servlet.http.HttpServletRequest;

/**
 * @author seuk
 * 
 */
public class BoxHttp extends Box {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private HttpServletRequest request = null;

	/**
	 * @param request
	 */
	public BoxHttp(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 
	 */
	public Object get(String key) {

		Object obj = request.getAttribute(key);
		if (obj != null) {
			return obj;
		}

		obj = request.getParameter(key);

		if (obj != null) {
			return obj;
		}

		return null;
	}

	/**
	 * 
	 */
	public void put(String key, Object obj) {
		request.setAttribute(key, obj);
	}

	/**
	 * 
	 */
	public void setSessionB(SessionB sessionB) {
		request.setAttribute(KEY_SESSIONB, sessionB);
		request.getSession().setAttribute(KEY_SESSIONB, sessionB);
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public String[] ss(String key) throws Exception {
		Object obj = get(key);

		if (obj instanceof String[]) {
			return (String[]) obj;
		}

		obj = request.getParameterValues(key);

		if (obj instanceof String[]) {
			return (String[]) obj;
		}

		return new String[0];

	}
}
