<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入用到的类 -->
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Request Scope Test</title>
</head>
<body>
	<%
		// 取值
		String r_name = (String) request.getAttribute("r_name");
		int r_age = (Integer) request.getAttribute("r_age");

		// Session中的值
		String s_name = (String) session.getAttribute("s_name");
		int s_age = (Integer) session.getAttribute("s_age");
	%>

	<font>姓名:<%=r_name%></font>
	<br>
	<font>年龄:<%=r_age%></font>
	<br>

	<font>Session姓名:<%=s_name%></font>
	<br>
	<font>Session年龄:<%=s_age%></font>
	<br>
	
	<!-- 获取头信息 -->
	<%
		Enumeration enu = request.getHeaderNames();
		String headerName = null;
		String headerValue = null;
		while (enu.hasMoreElements()) {
			headerName = (String) enu.nextElement();
			headerValue = request.getHeader(headerName);
		}
	%>
	<font>HeaderName:<%=headerName%></font><br>
	<font>HeaderValue:<%=headerValue%></font><br>

</body>
</html>