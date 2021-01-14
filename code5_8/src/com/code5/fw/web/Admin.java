package com.code5.fw.web;

import com.code5.fw.data.Box;
import com.code5.fw.data.SessionB;
import com.code5.fw.db.SqlRunner;

/**
 * @author seuk
 *
 */
public class Admin implements BizController, BizControllerStartExecute {

	/**
	 *
	 */
	public String start() throws Exception {

		Box box = BoxContext.getThread();
		String IP = box.s(Box.KEY_REMOTE_ADDR);

		SessionB user = box.getSessionB();
		if (IP.equals(user.getIp())) {
			throw new Exception();
		}

		boolean isAdmin = false;
		if (isAdmin) {
			box.setAlertMsg("������ ����� ���ּ���.");
			return "nullView";
		}

		return null;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public String admin001() throws Exception {
		Box box = BoxContext.getThread();

		SqlRunner.getSqlRunner().reload();
		MasterController.reload();

		box.setAlertMsg("���ε尡 ����Ǿ����ϴ�.");
		return "nullView";
	}

}
