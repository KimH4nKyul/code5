package com.code5.biz.board.web;

import javax.servlet.http.HttpServletRequest;

/**
 * @author seuk
 *
 */
/**
 * @author seuk
 *
 */
public class BoardC_step01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BoardC boardC = new BoardC();

		// HttpServletRequest �� �߻�ȭ Ŭ������ ��ü�� ������ �Ұ���
		HttpServletRequest request = null;

		// HttpServletRequest �� ��ü�� �����ߴ� �ϴ��� setParameter �޼ҵ尡 ����
		request.setParameter("pageNo", "1");

		// setParameter ��� setAttribute �� ������
		// ����Ͻ��� ������ �ڵ忡�� getParameter �� ����Ѵ�.
		request.setAttribute("pateNo", "1");

		boardC.listContents(request);

	}

}
