package com.classcontent;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.classcontent.model.Book;
import com.classcontent.util.DBUtil;

public class PreparedStatementUpdate {
	
	private static DBUtil dbUtil = new DBUtil();
	
	/**
	 * 更新图书
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int updateBook(Book book) throws Exception {
		// 获取连接
		Connection con = dbUtil.getCon();
		// PreparedStatement的SQL语句
		String updateSQL = "update t_book set bookName = ?, price = ?, author = ?, bookTypeid = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(updateSQL);
		// 设置值
		pstmt.setString(1, book.getBookName());
		pstmt.setDouble(2, book.getPrice());
		pstmt.setString(3, book.getAuthor());
		pstmt.setInt(4, book.getBookTypeId());
		pstmt.setInt(5, book.getId());
		// 执行
		int result = pstmt.executeUpdate();
		dbUtil.closeAll(pstmt, con); // 因为pstmt是stmt的子类, 所以通用
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		int result = updateBook(new Book(14, "g", 1, "g", 1));
		if(result == 1) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}
	}
}
