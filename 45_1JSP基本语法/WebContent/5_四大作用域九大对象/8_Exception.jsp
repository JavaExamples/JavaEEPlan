<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入异常页面 -->
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exception 对象</title>
</head>
<body>
	<!-- 用来处理JSP 文件在执行时发生的所有异常, 是java.lang.Throwable 类的一个对象 -->
	<%
		int a = 0;
		int b = 1;
		out.print(b / a);
	%>
</body>
</html>