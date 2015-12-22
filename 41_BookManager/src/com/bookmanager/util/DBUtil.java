package com.bookmanager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	// 数据库路径
	private String dbURL = "jdbc:mysql://localhost:3306/db_book?useSSL=false";
	// 数据库用户名
	private String dbUserName = "root";
	// 数据库密码
	private String dbPassword = "zxly82";
	// 数据库驱动名称
	private String jdbcName = "com.mysql.jdbc.Driver";
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}
	
	/**
	 * 用Main方法测试数据库连接获取和关闭功能
	 */
	/*
	public static void main(String[] args) {
		DBUtil dbUtil = new DBUtil();
		Connection con = null;
		
		// 测试获取数据库连接
		try {
			con = dbUtil.getCon();
			System.out.println("数据库连接获取成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接获取失败");
			e.printStackTrace();
		}
		
		// 测试关闭数据库连接
		try {
			dbUtil.closeCon(con);
			System.out.println("数据库连接关闭成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接关闭失败");
			e.printStackTrace();
		}
	}
	*/
}
