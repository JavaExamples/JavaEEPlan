<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入Student.class -->
<%@ page import="com.classcontent.model.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>非JavaBean方式引入Java实体类</title>
</head>
<body>
	<!-- 非JavaBean 方式引入Student -->
	<%
		Student stu = new Student();
		stu.setName("njb_guibs");
		stu.setAge(23);
	%>
	姓名:<%=stu.getName() %><br>
	年龄:<%=stu.getAge() %><br>
</body>
</html>