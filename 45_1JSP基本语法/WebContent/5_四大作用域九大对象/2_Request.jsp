<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Request Scope</title>
</head>
<body>
<!-- Request 范围: 只在一个一次请求中保存数据 javax.servlet.http.HttpServletRequest(接口) -->
<%
	// 设置两个request 范围的数据 --> key: value
	request.setAttribute("r_name", "r_guibs");
	request.setAttribute("r_age", 23);
%>
<jsp:forward page="2_requestTest.jsp"></jsp:forward>
</body>
</html>