<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaBean设置属性_结果</title>
</head>
<body>
<!-- 创建JavaBean 实体 stu -->
<jsp:useBean id="stu" scope="page" class="com.classcontent.model.Student"></jsp:useBean>
<%
	request.setCharacterEncoding("utf-8"); // 设置request 编码
	/*
	// 设置属性方法1:
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	stu.setName(name);
	stu.setAge(Integer.parseInt(age));
	*/
%>
<!-- 设置JavaBean 属性方法2: -->
<!-- property="*": 自动匹配所有属性 -->
<!-- <jsp:setProperty property="*" name="stu"/> -->

<!-- 设置JavaBean 属性方法3: -->
<!-- 手动设置 -->
<!-- 若控件的name 与JavaBean 属性名 不匹配, 则用param -->
<jsp:setProperty property="name" name="stu" param="userName"/>
<!-- 手动设置value, 不用传过来的参数 -->
<jsp:setProperty property="age" name="stu" value="22"/>

姓名:<jsp:getProperty property="name" name="stu"/><br>
年龄:<jsp:getProperty property="age" name="stu"/><br>
</body>
</html>