package com.code5.fw.db;

import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

/**
 * @author seuk
 *
 */
public class Transaction_MYSQL_JDBC extends Transaction {

	/**
	 * 
	 */
	private Connection conn = null;

	/**
	 *
	 */
	protected Connection getConnection() throws Exception {

		if (this.conn != null) {
			return this.conn;
		}

		// �ǹ������� ���̵�/�н�����/url �� �ڵ忡�� �˾� ���� ������ ó���մϴ�.
		Properties properties = new Properties();
		properties.put("user", "DB�̸�");
		properties.put("password", "�н�����");
		properties.put("url", "DBURL");

		Driver driver = (Driver) Class.forName("oracal.jdbc.driver.OracleDriver").getConstructor().newInstance();
		this.conn = driver.connect(properties.getProperty("url"), properties);

		return this.conn;

	}

}
