package com.classcontent;

import java.sql.Connection;
import java.sql.Statement;

import com.classcontent.util.DBUtil;

public class StatementDeleteDemo {
	private static DBUtil dbUtil = new DBUtil();
	
	private static int deleteBook(int id) throws Exception {
		Connection con = dbUtil.getCon(); // 获取连接
		String delSQL = "delete from t_book where id =" + id;
		Statement stmt = con.createStatement(); // 创建Statement实例
		int result = stmt.executeUpdate(delSQL);
		dbUtil.closeAll(stmt, con);
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		int result = deleteBook(2);
		if (result == 1) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}
}
