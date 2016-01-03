<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaBean引入Java实体类</title>
</head>
<body>
	<!-- id: 实例化对象名称 -->
	<!-- score: 保存范围(默认page) [page, request, session, application] -->
	<!-- class: 类的完整名称 -->
	<jsp:useBean id="stu" scope="page"
		class="com.classcontent.model.Student"></jsp:useBean>
	<%
		stu.setName("jb_guibs");
		stu.setAge(23);
	%>
	姓名:<%=stu.getName()%><br> 年龄:<%=stu.getAge()%><br>
</body>
</html>