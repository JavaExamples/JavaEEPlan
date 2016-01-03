<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP接收请求参数</title>
</head>
<body>
<%
	// 设置request 编码
	request.setCharacterEncoding("utf-8");
%>
<!-- EL表达式接收参数 -->
姓名:${param.name }<br>
爱好:${paramValues.hobby[0] }<br>
爱好:${paramValues.hobby[1] }<br>
爱好:${paramValues.hobby[2] }<br>
</body>
</html>