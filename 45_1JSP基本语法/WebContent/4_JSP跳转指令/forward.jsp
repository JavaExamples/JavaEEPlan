<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forward</title>
</head>
<body>
	<!-- 设置传递的值 -->
	<jsp:forward page="target.jsp">
		<jsp:param value="guibs" name="name" />
		<jsp:param value="123456" name="password" />
	</jsp:forward>
</body>
</html>