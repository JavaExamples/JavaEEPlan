package com.classcontent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classcontent.model.Book;
import com.classcontent.util.DBUtil;

public class ResultSetDemo1 {
	private static DBUtil dbUtil = new DBUtil();
	
	/**
	 * 根据列顺序
	 * @throws Exception
	 */
	private static void listBook() throws Exception {
		Connection con = dbUtil.getCon();
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt(1);
			String bookName = rs.getString(2);
			double price = rs.getDouble(3);
			String author = rs.getString(4);
			int bookTypeId = rs.getInt(5);
			System.out.println(id);
			System.out.println(bookName);
			System.out.println(price);
			System.out.println(author);
			System.out.println(bookTypeId);
			System.out.println("==========");
		}
	}
	
	/**
	 * 根据列id
	 * @throws Exception
	 */
	private static void listBook2() throws Exception {
		Connection con = dbUtil.getCon();
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String bookName = rs.getString("bookName");
			double price = rs.getDouble("price");
			String author = rs.getString("author");
			int bookTypeId = rs.getInt("bookTypeId");
			System.out.println(id);
			System.out.println(bookName);
			System.out.println(price);
			System.out.println(author);
			System.out.println(bookTypeId);
			System.out.println("==========");
		}
	}
	
	/**
	 * 面向对象
	 * @throws Exception
	 */
	private static List<Book> listBook3() throws Exception {
		List<Book> bookList = new ArrayList<Book>();
		Connection con = dbUtil.getCon();
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String bookName = rs.getString("bookName");
			double price = rs.getDouble("price");
			String author = rs.getString("author");
			int bookTypeId = rs.getInt("bookTypeId");
			bookList.add(new Book(id, bookName, price, author, bookTypeId));
		}
		return bookList;
	}
	
	public static void main(String[] args) throws Exception {
		List<Book> ls = listBook3();
		for (Book book : ls) {
			System.out.println(book.getBookName());
		}
	}
}
