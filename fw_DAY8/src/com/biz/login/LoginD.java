package com.biz.login;

import java.sql.SQLException;

import com.code5.fw.data.Table;
import com.code5.fw.db.SqlRunner;

/**
 * 
 * FW ���̺� ����
 * 
 * @author seuk
 * 
 */
public class LoginD {

	private static String FORM_NO_01 = "LOGIND_01";
	private static String FORM_NO_02 = "LOGIND_02";
	private static String FORM_NO_03 = "LOGIND_03";

	/**
	 * 
	 */
	private SqlRunner sql = SqlRunner.getSqlRunner();

	/**
	 * @return
	 * 
	 *         ����� ������ �����´�.
	 */
	Table login_01() throws SQLException {
		return sql.getTable(FORM_NO_01);
	}

	/**
	 * @return
	 * @throws SQLException
	 * 
	 *                      �α��� ���� ������Ʈ
	 */
	int login_02() throws SQLException {
		return sql.executeSql(FORM_NO_02);
	}

	/**
	 * @return
	 * @throws SQLException
	 * 
	 *                      �α��� ���� ������Ʈ
	 */
	int login_03() throws SQLException {
		return sql.executeSql(FORM_NO_03);
	}

}
