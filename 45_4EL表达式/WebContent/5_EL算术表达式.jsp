<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL表达式集合操作</title>
</head>
<body>
	<%
		int num1 = 10;
		int num2 = 5;
		request.setAttribute("n1", num1);
		request.setAttribute("n2", num2);
	%>

	10 + 5：${n1 + n2 }<br> 
	10 - 5：${n1 - n2 }<br>
	10 > 5：${n1 > n2 }<br>
</body>
</html>