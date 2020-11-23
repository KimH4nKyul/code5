package com.biz.login;

import com.code5.fw.data.Box;
import com.code5.fw.data.SessionB;
import com.code5.fw.data.Table;
import com.code5.fw.web.BizController;
import com.code5.fw.web.BoxContext;
import com.code5.fw.web.MasterController;
import com.code5.fw.web.TransactionContext;

/**
 * @author seuk
 *
 */
public class Login implements BizController {

	/**
	 * @return
	 * @throws Exception
	 */
	public String loginView() throws Exception {
		return "loginView";
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {

		Box box = BoxContext.getThread();

		String PIN = box.s("PIN");

		LoginD dao = new LoginD();

		Table user = dao.login_01();

		if (user.size() != 1) {
			box.put("ret", "���̵� ���ų� �н����尡 ��ġ���� �ʽ��ϴ�.");
			return MasterController.execute("loginView");
		}

		Box thisUser = user.getBox();

		if (!PIN.equals(thisUser.s("PIN"))) {

			box.put("ret", "���̵� ���ų� �н����尡 ��ġ���� �ʽ��ϴ�.");

			dao.login_02();
			return MasterController.execute("loginView");
		}

		int FAIL_CNT = thisUser.getInt("FAIL_CNT");
		if (FAIL_CNT > 5) {
			box.put("ret", "�н����带 5ȸ �̻� �����Ͽ����ϴ�.");

			dao.login_02();
			return MasterController.execute("loginView");
		}

		String ID = thisUser.s("ID");
		String AUTH = thisUser.s("AUTH");
		String IP = box.s(MasterController.REMOTE_ADDR_KEY);

		SessionB sessionB = new SessionB(ID, AUTH, IP);
		box.setSessionB(sessionB);

		dao.login_02();
		TransactionContext.getThread().commit();

		return MasterController.execute("mng00110");

	}

	/**
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {
		
		Box box = BoxContext.getThread();
		box.setSessionB(null);
		
		return MasterController.execute("loginView");
	}
}
