package com.code5.fw.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

/**
 * @author seuk
 *
 */
public class Transaction_SQLITE_POOL extends Transaction {

	/**
	 *
	 */
	protected Connection createConnection() throws SQLException {

		SQLiteConfig config = new SQLiteConfig();
		Connection conn = org.sqlite.JDBC.createConnection("jdbc:sqlite:C:\\public\\sqlite\\code5.db",
				config.toProperties());

		conn.setAutoCommit(false);

		return conn;

	}

}
