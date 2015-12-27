<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Response对象刷新页面</title>
</head>
<body>
	<!-- response 内置对象和request 内置对象是相应的 -->
	<!-- response 内置对象用于响应客户请求, 向客户端输出信息; javax.servlet.HttpServletResponse(接口) -->
	<!-- 1.自动刷新应用 -->
	<%
		// 每秒刷新一次叶面
		response.setHeader("refresh", "1");
		// 获取时间
		Date myDate = new Date();
	%>

	当前时间:<%=myDate.toLocaleString()%>
</body>
</html>