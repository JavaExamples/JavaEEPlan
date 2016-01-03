package com.login.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet 过滤器 Filter
 * @author guibs
 *
 */
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest sreq, ServletResponse sres, FilterChain fc)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)sreq;
		HttpSession session = request.getSession();
		Object o = session.getAttribute("currUser");
		String path = request.getServletPath();
		if(o==null && path.indexOf("logined") >= 0) {
			// 用户未登入且请求的url不含login
			request.getRequestDispatcher("login.jsp").forward(sreq, sres);
		} else {
			// 用户已登录或请求的url是含login
			fc.doFilter(sreq, sres);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
