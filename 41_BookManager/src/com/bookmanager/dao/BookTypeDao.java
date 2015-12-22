package com.bookmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookmanager.model.BookType;
import com.bookmanager.util.StringUtil;

/**
 * 图书类别Dao类
 * @author guibs
 *
 */
public class BookTypeDao {
	/**
	 * 图书类别添加
	 * @param con		数据库连接
	 * @param bookType	要添加类别
	 * @return			操作的记录数
	 * @throws Exception 
	 */
	public int add(Connection con, BookType bookType) throws Exception {
		String sql = "insert into t_bookType values(null, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询图书类别信息
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception 
	 */
	public ResultSet getBookTypeList(Connection con, BookType bookType) throws Exception {
		StringBuffer sb = new StringBuffer("select * from t_bookType");
		if (StringUtil.isNotEmpty(bookType.getBookTypeName())) {
			sb.append(" and bookTypeName like '%" + bookType.getBookTypeName() + "%'");
		}
		// 替换第一个and为where, 完成sql语句
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replace("and", "where"));
		return pstmt.executeQuery();
	}
}
