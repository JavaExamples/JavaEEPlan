package com.classcontent.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet-service-Get");
		// 让doPost处理 -- 减少重复代码量
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet-service-Post处理");
		resp.setCharacterEncoding("utf-8"); // 设置response 编码
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.print("<head><meta charset=\"UTF-8\"><title>Hello Guibs</title></head>");
		out.println("<body>Hello 阿桂</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	public void destroy() {
		System.out.println("servlet-销毁-长时间不用则销毁");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("servlet-初始化-单实例-若servlet 实例存在就不会初始化");
	}
	
	
	
}
