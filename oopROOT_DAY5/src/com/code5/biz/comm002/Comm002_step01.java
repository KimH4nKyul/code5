package com.code5.biz.comm002;

import com.code5.biz.comm001.Comm001D;
import com.code5.fw.web.Box;
import com.code5.fw.web.SubController;

/**
 * @author seuk
 * 
 *         �߿��������
 *
 */
public class Comm002_step01 extends SubController {

	/**
	 * @return
	 */
	public void start() {
		Box box = Box.getThread();
		box.put("NAME", "InformationC");
	}

	/**
	 * @return
	 * 
	 *         �߿� �������� ����Ʈ ����
	 */
	public String comm00201() {
		
		Comm001D dao = new Comm001D();
		
		dao.comm00101();

		return "comm00201";
	}

	/**
	 * @return
	 * 
	 *         �߿� �������� �Խù� ����
	 * 
	 */
	public String comm00202() {

		return "comm00202";
	}

	/**
	 * @return
	 * 
	 *         �������� ����
	 */
	public String comm00203() {

		// ���� �� ����Ʈ�� �̵�
		return comm00201();
	}
}
