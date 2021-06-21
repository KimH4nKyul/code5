package com.code5.fw.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author zero
 *
 */
public class Transaction_SQLITE_JDBC_OOP extends Transaction {

	// DriverManager ��ü�� org.sqlite.JDBC ��ü�� ���
	// Reflection, DriverManager ��ü�� org.sqlite.JDBC ��ü ���

	/**
	 *
	 */
	protected Connection createConnection() throws SQLException {

		try {

			String className = "org.sqlite.JDBC";
			Class.forName(className);

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}

		String url = "jdbc:sqlite:C:\\public\\sqlite\\code5.db";
		Connection conn = DriverManager.getConnection(url);

		return conn;

	}

}
