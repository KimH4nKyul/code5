// [1]
package com.code5.biz.comm003;

import com.code5.fw.data.Table;
import com.code5.fw.web.Box;
import com.code5.fw.web.MasterController;
import com.code5.fw.web.SessionB;

/**
 * 
 * ����� ����
 * 
 * @author seuk
 * 
 */
class Comm003 {

	/**
	 * 
	 * �α��� ȭ�� ȣ��
	 * 
	 * @param box
	 * @return
	 */
	public String comm00301() throws Exception {
		return "comm00301";
	}

	/**
	 * 
	 * ����� ����, �α��� �� ȭ�� �̵�
	 * 
	 * @return
	 */
	public String comm00302() throws Exception {

		Box box = Box.getThread();

		// String ID = box.s("ID");
		String PIN = box.s("PIN");

		Comm003D dao = new Comm003D();

		Table comm00302 = dao.comm00302();

		if (comm00302.size() != 1) {
			box.put("MSG", "���̵� �н����尡 �������� �ʽ��ϴ�.");
			return MasterController.execute("comm00301");
		}

		Box thisUser = comm00302.getBox();

		if (!PIN.equals(thisUser.s("PIN"))) {
			box.put("MSG", "���̵� �н����尡 �������� �ʽ��ϴ�.");

			if (dao.comm00302_2() != 1) {
				throw new Exception();
			}

			return MasterController.execute("comm00301");
		}

		String ID = thisUser.s("ID");
		String AUTH = thisUser.s("AUTH");
		// String ID = comm00302.s("ID");

		SessionB user = new SessionB(ID, AUTH);
		box.setSessionB(user);

		return MasterController.execute("comm00202");

	}

}
