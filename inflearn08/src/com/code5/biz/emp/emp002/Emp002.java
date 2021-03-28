package com.code5.biz.emp.emp002;

import java.sql.SQLException;

import com.code5.fw.data.Box;
import com.code5.fw.web.AuthException;
import com.code5.fw.web.BizController;
import com.code5.fw.web.BoxContext;
import com.code5.fw.web.LoginException;

/**
 * @author zero
 *
 */
public class Emp002 implements BizController {

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String emp00210() throws Exception {

		Box box = BoxContext.getThread();
		if ("1".equals(box.s("err"))) {
			box.setAlertMsg("������ �߻��߽��ϴ�.");
			throw new Exception();
		}

		return "nullView";
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public String emp00220() throws Exception {

		Box box = BoxContext.getThread();
		if ("1".equals(box.s("err"))) {
			box.setAlertMsg("������ �߻��߽��ϴ�.");
			throw new Exception();
		}

		if ("2".equals(box.s("err"))) {
			throw new Exception("�Ϲ����ο���");
		}

		if ("3".equals(box.s("err"))) {
			throw new SQLException("SQL ����");
		}

		if ("4".equals(box.s("err"))) {
			throw new AuthException();
		}

		if ("5".equals(box.s("err"))) {
			throw new LoginException();
		}

		return "nullView";
	}

}
