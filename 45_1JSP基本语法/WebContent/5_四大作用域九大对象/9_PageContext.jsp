<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PageContext 对象</title>
</head>
<body>
<!-- pageContext 对象是一个比较特殊的对象. -->
<!-- 他相当于页面中所有对象功能的集合, 即使用它可以访问到本页面中的所有对象 -->
<!-- pageContext 内置对象由 JSP容器创建并初始化, pageContext 对象提供了对JSP页面所有对象及控件的访问 -->

<%
	// 默认Page 范围
	pageContext.setAttribute("name0", "pageInfo");
	request.setAttribute("name1", "requestInfo");
	session.setAttribute("name2", "sessionInfo");
	application.setAttribute("name3", "applicationInfo");
	
	out.println("使用pageContext<br>");
	out.println("page中的属性是:" + pageContext.getAttribute("name0") + "<br>");
	out.println("request中的属性是:" + pageContext.getRequest().getAttribute("name1") + "<br>");
	out.println("session中的属性是:" + pageContext.getSession().getAttribute("name2") + "<br>");
	out.println("application中的属性是:" + pageContext.getServletContext().getAttribute("name3") + "<br>");
%>
</body>
</html>