// [1]
package com.code5.biz.com002;

import com.code5.fw.db.Sql;
import com.code5.fw.web.Box;
import com.code5.fw.web.TransactionContext;

/**
 * 
 * BZ_BOARD ?��?��?�� ?���?
 * 
 * @author seuk
 * 
 */
class Comm002_test {

	/**
	 * @param xx
	 * @throws Exception
	 */
	public static void main(String[] xx) throws Exception {

		Box box = Box.getThread();

		for (int i = 0; i < 1000; i++) {

			box.put("NUM", "" + i);
			box.put("HEAD", "?���?[" + "" + i + "]");
			box.put("MAIN", "?��?��[" + "" + i + "]\n?��?��?��?��?��.");

			Sql.getSql().executeSql("BOARD_x");

		}

		TransactionContext.getThread().commit();

	}

}
