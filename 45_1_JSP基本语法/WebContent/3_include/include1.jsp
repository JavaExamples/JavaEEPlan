<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@include静态包含</title>
</head>
<body>
<!-- @include静态包含 -->
<!-- 先将包含文件放入页面, 而后一起编译 -->
<!-- Head -->
<%@include file="Head.html" %>
<p>Content</p>
<!-- Footer -->
<%@include file="Footer.jsp" %>
</body>
</html>