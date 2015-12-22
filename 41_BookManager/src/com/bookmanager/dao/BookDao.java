package com.bookmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookmanager.model.Book;
import com.bookmanager.util.StringUtil;

/**
 * 图书Dao类
 * @author guibs
 *
 */
public class BookDao {
	public int add(Connection con, Book book) throws Exception {
		String sql = "insert into t_book values(null, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setInt(5, book.getBookTypeId());
		pstmt.setString(6, book.getBookDesc());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 图书查询
	 * @param con
	 * @param book
	 * @return
	 * @throws SQLException 
	 */
	public ResultSet getBookList(Connection con, Book book) throws SQLException {
		StringBuffer sb = new StringBuffer("select * from t_book b, t_bookType bt where b.bookTypeId = bt.id");
		if (book != null) {
			if (StringUtil.isNotEmpty(book.getBookName())) {
				sb.append(" and b.bookName like '%" + book.getBookName() + "%'");
			}
			if (StringUtil.isNotEmpty(book.getAuthor())) {
				sb.append(" and b.author like '%" + book.getAuthor() + "%'");
			}
			if (book.getBookTypeId()!=null && book.getBookTypeId() != 0) {
				sb.append(" and b.bookTypeId =" + book.getId());
			}
			// 替换第一个and为where, 完成sql语句
			PreparedStatement pstmt = con.prepareStatement(sb.toString());
			return pstmt.executeQuery();
		}
		// 替换第一个and为where, 完成sql语句
					PreparedStatement pstmt = con.prepareStatement(sb.toString());
					return pstmt.executeQuery();
	}
	
	/**
	 * 图书信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id) throws Exception {
		String sql = "delete from t_book where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 更新图书信息
	 * @param con
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public int update(Connection con, Book book) throws SQLException {
		String sql = "update t_book set bookName = ?, author = ?, sex = ?, price = ?, bookDesc = ?, bookTypeId = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setString(5, book.getBookDesc());
		pstmt.setInt(6, book.getBookTypeId());
		pstmt.setInt(7, book.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 指定类别下是否存在图书
	 * @param con
	 * @param bookTypeId
	 * @return
	 * @throws SQLException 
	 */
	public boolean existBookByBookTypeId(Connection con, String bookTypeId) throws Exception {
		String sql = "select * from t_book where bookTypeId = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookTypeId);
		ResultSet rs = pstmt.executeQuery();
		return rs.next();
	}
}