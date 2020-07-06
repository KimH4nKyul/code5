package com.code5.biz.comm001;

import java.util.List;
import java.util.Map;

import com.code5.fw.web.Box;
import com.code5.fw.web.SubController;

/**
 * @author seuk
 * 
 *         ��������
 *
 */
public class Comm001 extends SubController {

	/**
	 * @return
	 */
	protected void start() {
		Box box = Box.getThread();
		box.put("NAME", "BoardC");
	}

	/**
	 * @return
	 * 
	 *         �������� ����Ʈ
	 */
	public String comm00101() {

		Box box = Box.getThread();

		Comm001D dao = new Comm001D();
		List<Map<String, String>> comm00101 = dao.comm00101();

		box.put("comm00101", comm00101);

		return "comm00101";
	}

	/**
	 * @return
	 * 
	 *         �������� �Խù� ����
	 * 
	 */
	public String comm00102() {

		return "comm00102";
	}

	/**
	 * @return
	 * 
	 *         �������� ����
	 */
	public String comm00103() {

		// �������� ���� �� �������� ����Ʈ�� �̵�
		return comm00101();
	}
}
