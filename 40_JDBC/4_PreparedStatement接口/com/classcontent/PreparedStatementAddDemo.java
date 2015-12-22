package com.classcontent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.classcontent.model.Book;
import com.classcontent.util.DBUtil;

public class PreparedStatementAddDemo {
	
	private static DBUtil dbUtil = new DBUtil();
	
	/**
	 * 添加图书
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int addBook(Book book) throws Exception {
		// 获取连接
		Connection con = dbUtil.getCon();
		// PreparedStatement的SQL语句
		String addSQL = "insert into t_book values (null, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(addSQL);
		// 设置值
		pstmt.setString(1, book.getBookName());
		pstmt.setDouble(2, book.getPrice());
		pstmt.setString(3, book.getAuthor());
		pstmt.setInt(4, book.getBookTypeId());
		// 执行
		int result = pstmt.executeUpdate();
		dbUtil.closeAll(pstmt, con); // 因为pstmt是stmt的子类, 所以通用
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		int result = addBook(new Book("kkk", 12, "k", 3));
		if (result == 1) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}
}
