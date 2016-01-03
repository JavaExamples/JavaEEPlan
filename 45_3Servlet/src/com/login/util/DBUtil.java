package com.login.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	private String dbURL = "jdbc:mysql://localhost:3306/db_jsp?useSSL=false";
	private String dbUserName = "root";
	private String dbPassword = "zxly82";
	private String jdbcName = "com.mysql.jdbc.Driver";
	
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		return con;
	}
	
	public void closeCon(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DBUtil dbUtil = new DBUtil();
		try {
			dbUtil.getCon();
			System.out.println("连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
