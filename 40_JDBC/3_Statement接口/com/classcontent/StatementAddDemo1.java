package com.classcontent;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.classcontent.util.DBUtil;

public class StatementAddDemo1 {
	public static void main(String[] args) {
		// 创建DBUtil实例, 管理数据库连接的创建和关闭
		DBUtil dbUtil = new DBUtil();
		// 添加数据SQL('' 和 \"\" 都可以)
		String addSql = "insert into t_book values (null, 'Swift', 120, \"Guibs\", 1)";
		// 数据库连接
		Connection con = null;
		try {
			// 获取数据库连接
			con = dbUtil.getCon();
			System.out.println("获取连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("获取连接失败");
			e.printStackTrace();
		}
		// 创建Statement实例
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			System.out.println("Statement实例创建成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Statement实例创建失败");
			e.printStackTrace();
		}
		// 执行sql语句, 返回受影响的记录数量
		int result = -1;
		try {
			result = stmt.executeUpdate(addSql);
			System.out.println("SQL语句执行成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL语句执行失败");
			e.printStackTrace();
		}
		// 显示结果
		System.out.println(result);
		// 关闭Statement
		try {
			stmt.close();
			System.out.println("Statement关闭成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Statement关闭失败");
			e.printStackTrace();
		}
		// 关闭数据库连接
		try {
			dbUtil.closeConnection(con);
			System.out.println("连接关闭成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("连接关闭失败");
			e.printStackTrace();
		}
	}
}
