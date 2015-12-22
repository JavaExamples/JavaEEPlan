package com.classcontent;

import java.sql.Connection;
import java.sql.Statement;

import com.classcontent.model.Book;
import com.classcontent.util.DBUtil;

public class StatementUpdateDemo {
	// DBUtil实例
	private static DBUtil dbUtil = new DBUtil();

	/**
	 * 自定义更新(面向对象版本)
	 * 
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int updateBook(Book book) throws Exception {
		Connection con = dbUtil.getCon(); // 获取连接
		String updataSQL = "update t_book set bookName = '" + book.getBookName() + "', price = " + book.getPrice()
				+ ", author = '" + book.getAuthor() + "', bookTypeId = " + book.getBookTypeId() + " where id = " + book.getId();
		Statement stmt = con.createStatement(); // 创建Statement实例
		int result = stmt.executeUpdate(updataSQL);
		dbUtil.closeAll(stmt, con);
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		Book book = new Book(2, "33", 22, "2233", 2);
		int result = updateBook(book);
		if (result == 1) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}
	}
}
