<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Out 对象</title>
</head>
<body>
	<!-- Out内置对象主要用来向客户端输出各种类型的数据, 同时还可以管理应用服务器上的输出缓冲区. -->
	<!-- 所以out 内置对象的方法是向客户端输出数据和管理缓冲区; 底层javax.servlet.jspWriter -->
	<%
		// 输出对象
		out.println("<h1>");
		out.println("Hello JSP");
		out.println("</h1>");
	%>

	<%
		// 管理缓冲区
		int totalBuffer = out.getBufferSize(); // 获取总共缓冲区的大小
		int available = out.getRemaining(); // 获取未使用的缓冲区大小
		int using = totalBuffer - available; // 获取使用的缓冲区大小

		out.println("总共缓冲区的大小:" + totalBuffer + "<br>");
		out.println("未使用的缓冲区大小:" + available + "<br>");
		out.println("使用的缓冲区大小:" + using + "<br>");
	%>
</body>
</html>