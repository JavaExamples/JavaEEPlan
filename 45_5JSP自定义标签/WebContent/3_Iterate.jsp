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
		people.add("a");
		people.add("b");
		people.add("c");
		pageContext.setAttribute("p", people);
	%>
	<hello:iterate items="p" var="pn">
		${pn }<br>
	</hello:iterate>
</body>
</html>