package com.bookmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookmanager.model.User;

/**
 * 用户Dao类
 * @author guibs
 *
 */
public class UserDao {
	
	/**
	 * 登录验证
	 * @param con			数据库连接
	 * @param user			由登陆页面获取的用户对象
	 * @return				数据库中存在的用户对象或null
	 * @throws Exception
	 */
	public User login(Connection con, User user) throws Exception {
		User resultUser = null;
		String isExist = "select * from t_user where userName = ? and password = ?";
		PreparedStatement pstmt = con.prepareStatement(isExist);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) { // true 用户存在
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}
}
