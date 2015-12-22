package com.classcontent;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.classcontent.model.Book;
import com.classcontent.util.DBUtil;

public class PreparedStatementDeleteDemo {

	private static DBUtil dbUtil = new DBUtil();
	
	/**
	 * 删除图书
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int deleteBook(int id) throws Exception {
		// 获取连接
		Connection con = dbUtil.getCon();
		// PreparedStatement的SQL语句
		String updateSQL = "delete from t_book where id = ?";
		PreparedStatement pstmt = con.prepareStatement(updateSQL);
		// 设置值
		pstmt.setInt(1, id);
		// 执行
		int result = pstmt.executeUpdate();
		dbUtil.closeAll(pstmt, con); // 因为pstmt是stmt的子类, 所以通用
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		int result = deleteBook(4);
		if(result == 1) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}
}
