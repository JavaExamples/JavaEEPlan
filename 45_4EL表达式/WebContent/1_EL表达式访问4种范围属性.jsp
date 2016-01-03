<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("pIF", "pageValue");
		request.setAttribute("rIF", "requestValue");
		session.setAttribute("sIF", "sessionValue");
		application.setAttribute("aIF", "applicationValue");
	%>
	<!-- EL表达式取值 -->
	<!-- 若参数名相同, 则寻找值的顺序是page->request->session->application -->
	<h1>${pIF }</h1>
	<h1>${rIF }</h1>
	<h1>${sIF }</h1>
	<h1>${aIF }</h1>
</body>
</html>