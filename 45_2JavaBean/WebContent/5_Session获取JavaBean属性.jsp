<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session获取JavaBean属性</title>
</head>
<body>
<!-- 检测若底层存在则直接利用 -->
<jsp:useBean id="stu" scope="session" class="com.classcontent.model.Student"></jsp:useBean>

姓名:<jsp:getProperty property="name" name="stu"/><br>
年龄:<jsp:getProperty property="age" name="stu"/><br>
</body>
</html>