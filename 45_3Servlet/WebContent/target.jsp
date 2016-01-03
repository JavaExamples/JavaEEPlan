<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Target</title>
</head>
<body>
<h1>目标地址</h1>
<!-- RedirectServlet 时request值 无法取到, 因为redirect 页面重定向 -->
<!-- ForwardServlet 时request值 可以取到 -->
request值: <%=request.getAttribute("requestKey") %><br>
session值: <%=session.getAttribute("sessionKey") %><br>
application值: <%=application.getAttribute("applicationKey") %><br>
</body>
</html>