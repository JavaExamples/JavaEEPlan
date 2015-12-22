package com.classcontent;

import java.sql.Connection;
import java.sql.Statement;

import com.classcontent.model.Book;
import com.classcontent.util.DBUtil;

public class StatementAddDemo2 {
	// DBUtil实例
	private static DBUtil dbUtil = new DBUtil();
	
	/**
	 * 自定义添加
	 * @param bookName
	 * @param price
	 * @param author
	 * @param bookTypeId
	 * @return
	 * @throws Exception
	 */
	private static int addBook(String bookName, float price, String author, int bookTypeId) throws Exception{
		Connection con = dbUtil.getCon(); // 获取连接 
		String addSQL = "insert into t_book values(null, '" + bookName +"'," + price +", '" + author + "', " + bookTypeId +")";
		Statement stmt = con.createStatement(); // 创建Statement实例
		int result = stmt.executeUpdate(addSQL);
		dbUtil.closeAll(stmt, con);
		return result;
	}
	
	/**
	 * 自定义添加(面向对象版本)
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int addBook2(Book book) throws Exception{
		Connection con = dbUtil.getCon(); // 获取连接 
		String addSQL = "insert into t_book values(null, '" + book.getBookName() +"'," + book.getPrice() +", '" + book.getAuthor() + "', " + book.getBookTypeId() +")";
		Statement stmt = con.createStatement(); // 创建Statement实例
		int result = stmt.executeUpdate(addSQL);
		dbUtil.closeAll(stmt, con);
		return result;
	}
	
	public static void main(String[] args) throws Exception {
//		int result = addBook("JavaG", 110, "Guibs", 1);
		int result = addBook2(new Book("test2", 112, "guibs_o", 1));
		System.out.println(result);
		if (result == 1) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}
}
