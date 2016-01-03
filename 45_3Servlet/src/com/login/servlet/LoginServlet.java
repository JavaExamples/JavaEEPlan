package com.login.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.UserDao;
import com.login.model.User;
import com.login.util.DBUtil;

public class LoginServlet extends HttpServlet {
	
	DBUtil dbUtil = new DBUtil();
	UserDao userDao = new UserDao();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		// 需要将mysql 的jar包放入WEB-INF的lib下
		Connection con = null;
		try {
			User currUser = new User(userName, password);
			con = dbUtil.getCon();
			User resUser = userDao.login(con, currUser);
			if (resUser==null){
				// 用户不存在
				req.setAttribute("err_message", "用户名或密码错误");
				req.setAttribute("err_userName", userName);
				req.setAttribute("err_password", password);
				// 转发(服务器跳转)
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			} else {
				// 用户存在
				HttpSession session = req.getSession();
				session.setAttribute("currUser", resUser);
				// 因为保存在session 所以可以直接重定向
				resp.sendRedirect("logined.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
