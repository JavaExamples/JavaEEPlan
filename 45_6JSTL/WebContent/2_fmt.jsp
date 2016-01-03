<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FMT</title>
</head>
<body>
	<%
		//设置日期
		pageContext.setAttribute("date", new Date());
	%>
	中文日期:
	<fmt:setLocale value="zh_CN"/>
	<fmt:formatDate value="${date }"/>
	<hr>
	英文日期:
	<fmt:setLocale value="en_US"/>
	<fmt:formatDate value="${date }"/>
	<hr>
	
	<!-- 设置编码 -->
	<fmt:requestEncoding value="utf-8"/>
</body>
</html>