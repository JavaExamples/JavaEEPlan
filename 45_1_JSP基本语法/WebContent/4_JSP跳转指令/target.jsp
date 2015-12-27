<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>target</title>
</head>
<body>
	服务器内部跳转后的页面
	<br>
	<!-- 显示传递的值 -->
	userName:<%=request.getParameter("name")%><br> 
	userName:<%=request.getParameter("password")%><br>
</body>
</html>