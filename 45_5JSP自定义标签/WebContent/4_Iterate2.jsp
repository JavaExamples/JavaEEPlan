<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="hello" uri="/WEB-INF/Guibs.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List people = new ArrayList();
		people.add("a1");
		people.add("b1");
		people.add("c1");
		pageContext.setAttribute("p", people);
	%>
	<hello:iterate2 items="p" var="pn">
	${pn }
	</hello:iterate2>
</body>
</html>