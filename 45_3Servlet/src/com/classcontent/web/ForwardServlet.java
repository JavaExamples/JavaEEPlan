package com.classcontent.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 服务器内部跳转
 * @author guibs
 *
 */
public class ForwardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("requestKey", "request值");
		HttpSession session = req.getSession(); // 获取session
		session.setAttribute("sessionKey", "session值");
		ServletContext application = this.getServletContext(); // 获取application
		application.setAttribute("applicationKey", "application值");
		// 服务器内部跳转
		RequestDispatcher rd = req.getRequestDispatcher("target.jsp");
		rd.forward(req, resp); // 服务器转发
		
	}
	
}
