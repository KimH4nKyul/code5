package com.code5.biz.comm001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.code5.fw.web.Box;

/**
 * @author seuk
 * 
 *         �������� DAO
 *
 */
public class Comm001D {

	/**
	 * @param pageNo
	 * @return
	 * 
	 *         �������� ����Ʈ ��ȸ
	 */
	List<Map<String, String>> comm00101() {

		Box box = Box.getThread();
		String pageNo = box.s("pageNo");

		// DAO �κ��� ���߿� �ϼ��˴ϴ�.
		pageNo.toString();

		Map<String, String> hm = new HashMap<String, String>();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		list.add(hm);

		return list;
	}
}
