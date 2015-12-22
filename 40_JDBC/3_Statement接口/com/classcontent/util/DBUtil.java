package com.classcontent.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBUtil {
	// 数据库驱动名
	private static String jdbcName = "com.mysql.jdbc.Driver";
	// 数据库地址
	private static String dbURL = "jdbc:mysql://localhost:3306/db_bank";
	// 用户名
	private static String dbUserName = "root";
	// 密码
	private static String dbPassword = "zxly82";
	
	/**
	 * 根据该类中静态变量获取数据库连接(useSSL=false)
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		dbURL += "?useSSL=false";
		Connection con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		return con;
	}

	/**
	 * 
	 * 获取数据库连接(自定义)
	 * @param jdbcName		数据库驱动
	 * @param dbURL 		数据库地址
	 * @param dbUserName	数据库用户名
	 * @param dbPassword	数据库用户密码
	 * @return				数据库连接
	 * @throws Exception
	 */
	public Connection getCon(String jdbcName, String dbURL, String dbUserName, String dbPassword) throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		return con;
	}
	
	/**
	 * 
	 * 获取数据库连接(自定义且设置SSL)
	 * @param jdbcName		数据库驱动
	 * @param dbURL 		数据库地址
	 * @param useSSL		是否使用SSL
	 * @param dbUserName	数据库用户名
	 * @param dbPassword	数据库用户密码
	 * @return				数据库连接
	 * @throws Exception
	 * 
	 * Sat Dec 19 15:53:52 CST 2015 WARN: Establishing SSL connection without
	 * server's identity verification is not recommended. According to MySQL
	 * 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be
	 * established by default if explicit option isn't set. For compliance with
	 * existing applications not using SSL the verifyServerCertificate property
	 * is set to 'false'. You need either to explicitly disable SSL by setting
	 * useSSL=false, or set useSSL=true and provide truststore for server
	 * certificate verification.
	 *
	 */
	public Connection getCon(String jdbcName, String dbURL, boolean useSSL, String dbUserName, String dbPassword) throws Exception {
		Class.forName(jdbcName);
		if (useSSL) {
			dbURL += "?useSSL=true";
		} else {
			dbURL += "?useSSL=false";
		}
		Connection con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @param con 需要被关闭的数据库连接
	 * @throws Exception
	 */
	public void closeConnection(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}
	
	/**
	 * 关闭Statement, Connection
	 * @param stmt
	 * @param con
	 * @throws Exception
	 */
	public void closeAll(Statement stmt, Connection con) throws Exception {
		if (stmt != null) {
			stmt.close();
			if (con != null) {
				con.close();
			}
		}
	}
}
