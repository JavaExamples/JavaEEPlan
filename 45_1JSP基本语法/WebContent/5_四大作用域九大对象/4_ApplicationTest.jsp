<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Application Scope Test</title>
</head>
<body>
<%
	// Application 中的值
	String a_name = (String)application.getAttribute("s_name");
	int a_age = (Integer)application.getAttribute("s_age");
%>
<font>Application姓名:<%=a_name %></font><br>
<font>Application年龄:<%=a_age %></font><br>
</body>
</html>