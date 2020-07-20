// [1]
package com.code5.biz.com002;

import com.code5.fw.data.Table;
import com.code5.fw.web.Box;

/**
 * 
 * ๋ก๊ทธ?ธ ?  ?๋ฉ?, ๋ก๊ทธ?ธ ? ?๋ฉ?
 * 
 * @author seuk
 * 
 */
public class Comm002 {

	/**
	 * 
	 * ๋ก๊ทธ?ธ ?  ?๋ฉ?
	 * 
	 * @param box
	 * @return
	 */
	public String comm00201() throws Exception {

		setBoard();

		return "comm00201";
	}

	/**
	 * 
	 * ๋ก๊ทธ?ธ ? ?๋ฉ?
	 * 
	 * @return
	 */
	public String comm00202() throws Exception {

		setBoard();

		return "comm00202";

	}

	/**
	 * @throws Exception
	 */
	private void setBoard() throws Exception {

		Comm002D dao = new Comm002D();

		Table list = dao.getBoard();

		Box box = Box.getThread();

		box.put("list", list);

	}
}
