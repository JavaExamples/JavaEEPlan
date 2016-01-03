<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 导入操作cookie 所需要的包 -->
    <%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
</head>
<body>
<%
	// 括号里对应控件的name
	String userName = request.getParameter("userName");
	String pwd = request.getParameter("pwd");
	String remember = request.getParameter("remeber");
	
	if("yes".equals(remember)) {
		Cookie userNameAndPwd = new Cookie("userNameAndPwd", userName + "-" + pwd);
		// 设置cookie 有效期, 以秒为单位
		userNameAndPwd.setMaxAge(1*60*60*24*7);
		// 保存cookie
		response.addCookie(userNameAndPwd);
		System.out.println("保存成功");
	}
%>
用户名:<%=userName %>
密码:<%=pwd %>
是否记住密码:<%=remember %>
</body>
</html>