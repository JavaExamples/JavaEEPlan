package com.classcontent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.classcontent.model.Book;
import com.classcontent.util.DBUtil;

public class BLOBDemo {
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
		String addSQL = "insert into t_book values (null, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(addSQL);
		// 设置值
		pstmt.setString(1, book.getBookName());
		pstmt.setDouble(2, book.getPrice());
		pstmt.setString(3, book.getAuthor());
		pstmt.setInt(4, book.getBookTypeId());
		// InputStream读取文件并传入数据库
		File context = book.getContext(); // 获取文件
		InputStream inputStream = new FileInputStream(context);
		pstmt.setAsciiStream(5, inputStream, context.length());
		
		// 读取图片传入数据库
		File pic = book.getPic();// 获取图片文件
		InputStream inputStream2 = new FileInputStream(pic);
		pstmt.setBinaryStream(6, inputStream2, pic.length());
		
		// 执行
		int result = pstmt.executeUpdate();
		dbUtil.closeAll(pstmt, con); // 因为pstmt是stmt的子类, 所以通用
		return result;
	}
	
	/**
	 * 获取图书
	 * @param id
	 * @throws Exception
	 */
	public static void getBook(int id) throws Exception {
		Connection con = dbUtil.getCon();
		String sql = "select * from t_book where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			String bookName = rs.getString("bookName");
			double price = rs.getDouble("price");
			String author = rs.getString("author");
			int bookTypeId = rs.getInt("bookTypeId");
			
			// 获取BigText
			Clob cb = rs.getClob("context");
			// 转化为String
			String context = cb.getSubString(1, (int) cb.length());
			
			// 获取pic
			Blob b =rs.getBlob("pic");
			//输出
			System.out.println(bookName);
			System.out.println(price);
			System.out.println(author);
			System.out.println(bookTypeId);
			System.out.println(context);
			// 转存pic
			FileOutputStream out = new FileOutputStream("/Users/guibs/Desktop/test2.jpg");
			out.write(b.getBytes(1, (int) b.length()));
		}
		dbUtil.closeAll(pstmt, con);
	}
	
	public static void main(String[] args) throws Exception {
		/*
		 * 存入数据库一个Book对象
		 */
//		File context = new File("/Users/guibs/Desktop/test.txt");
//		File pic = new File("/Users/guibs/Desktop/test.jpg");
//		Book book = new Book("bigtext", 100, "guibs", 1, context, pic);
//		int result = addBook(book);
//		if(result == 1) {
//			System.out.println("添加成功");
//		} else {
//			System.out.println("添加失败");
//		}
		/*
		 * 取出一个Book对象
		 */
		getBook(18);
	}
}
