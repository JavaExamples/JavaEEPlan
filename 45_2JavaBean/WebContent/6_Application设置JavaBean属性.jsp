<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Application设置JavaBean属性</title>
</head>
<body>
<jsp:useBean id="stu" scope="application" class="com.classcontent.model.Student"></jsp:useBean>
<jsp:setProperty property="name" name="stu" value="a_Joker"/>
<jsp:setProperty property="age" name="stu" value="22"/>
<h1>Application设置完毕</h1>
</body>
</html>