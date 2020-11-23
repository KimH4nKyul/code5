package com.biz.mng001;

import com.code5.fw.data.Box;
import com.code5.fw.web.BizController;
import com.code5.fw.web.BoxContext;
import com.code5.fw.web.MasterController;

/**
 * 
 * FW ���̺� ����
 * 
 * @author seuk
 * 
 */
public class Mng001 implements BizController {

	/**
	 * 
	 * FW_SQL ��ȸ
	 * 
	 * @param box
	 * @return
	 */
	public String mng00110() throws Exception {

		Box box = BoxContext.getThread();

		if ("".equals(box.s("KEY"))) {
			return "mng00110";
		}

		Mng001D dao = new Mng001D();
		Box thisBox = dao.mng00110();

		box.put("thisBox", thisBox);

		return "mng00110";
	}

	/**
	 * 
	 * FW_SQL ���/����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String mng00111() throws Exception {

		Mng001D dao = new Mng001D();
		if (dao.mng00111_1() == 0) {
			dao.mng00111_2();
		}

		return MasterController.execute("mng00110");
	}

}
