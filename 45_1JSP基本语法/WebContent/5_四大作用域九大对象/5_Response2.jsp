<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Response对象页面重定向</title>
</head>
<body>
	<!-- 2.页面重定向, 客户端跳转 -->
	<%
		// 页面重定向(客户端跳转) -- 除了session 和application 的值, 不能带任何数据. 且地址会变
		response.sendRedirect("https://www.baidu.com");
	%>
</body>
</html>