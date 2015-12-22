package com.classcontent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC 连接数据库
 * @author guibs
 * 
 * 1.加载驱动
 * 2.连接数据库
 * 3.使用语句操作数据库
 * 4.关闭数据库连接, 释放资源
 *
 */
public class ConnectionDBDemo {
	// JDBC驱动名
	private static String jdbcName = "com.mysql.jdbc.Driver";
	// 数据库地址
		/*
		 * Sat Dec 19 15:53:52 CST 2015 WARN: 
		 * Establishing SSL connection without server's identity verification is not recommended. 
		 * According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. 
		 * For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. 
		 * You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
		 */
	private static String dbURL = "jdbc:mysql://localhost:3306/db_book?useSSL=false";
	// 用户名
	private static String dbUserName = "root";
	// 密码
	private static String dbPassword = "zxly82";
	
	public static void main(String[] args) {
		try {
			// 1.加载驱动
			Class.forName(jdbcName);
			System.out.println("加载驱动成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载驱动失败");
			e.printStackTrace();
		}
		Connection con = null;
		try {
			// 2.获取数据库连接
			con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
			System.out.println("获取数据库连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("获取数据库连接失败");
			e.printStackTrace();
		}
	}
}
