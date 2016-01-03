<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 设置为errorPage, 使内置对象exception 生效 -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
</head>
<body>
	<!-- 与会报错的页面放在一个文件夹 -->
	<%
		if (exception != null) {
			out.println("程序错误信息:");
			out.println(exception.getMessage());
		}
	%>
</body>
</html>