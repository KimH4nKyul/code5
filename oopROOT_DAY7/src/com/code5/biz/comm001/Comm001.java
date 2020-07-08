package com.code5.biz.comm001;

import com.code5.fw.data.Table;
import com.code5.fw.web.Box;
import com.code5.fw.web.SubController;

/**
 * @author seuk
 * 
 *         �Խ���
 *
 */
public class Comm001 extends SubController {

	/**
	 * @return
	 */
	protected void start() {
		Box box = Box.getThread();
		box.put("NAME", "�Խ���");
	}

	/**
	 * @return
	 * 
	 *         �Խ��� ����Ʈ
	 */
	public String comm00101() throws Exception {

		Box box = Box.getThread();

		Comm001D dao = new Comm001D();

		Table comm00101 = dao.comm00101();
		box.put("comm00101", comm00101);

		return "comm00101";
	}

	/**
	 * @return
	 * 
	 *         �Խù� ����
	 * 
	 */
	public String comm00102() throws Exception {

		Box box = Box.getThread();

		Comm001D dao = new Comm001D();

		Box comm00102 = dao.comm00102();
		box.put("comm00102", comm00102);

		return "comm00102";
	}

	/**
	 * @return
	 * 
	 *         �Խù� ����
	 */
	public String comm00103() throws Exception {

		Comm001D dao = new Comm001D();

		if (dao.comm00103() != 1) {
			throw new Exception();
		}

		return "comm00102";
	}
}
