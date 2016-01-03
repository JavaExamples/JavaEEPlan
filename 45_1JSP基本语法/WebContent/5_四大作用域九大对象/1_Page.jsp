<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page Scope</title>
</head>
<body>
<!-- Page 范围: 只在一个页面中保存数据 javax.servlet.jsp PageContext(抽象类) -->
<%
	// 设置两个page 范围的数据 --> key: value
	pageContext.setAttribute("p_name", "p_guibs");
	pageContext.setAttribute("p_age", 23);
%>

<%
	// 取值
	String p_name = (String)pageContext.getAttribute("p_name");
	int p_age = (Integer)pageContext.getAttribute("p_age");
	
	// Session中的值
	String s_name = (String)session.getAttribute("s_name");
	int s_age = (Integer)session.getAttribute("s_age");
%>

<font>姓名:<%=p_name %></font><br>
<font>年龄:<%=p_age %></font><br>

<font>Session姓名:<%=s_name %></font><br>
<font>Session年龄:<%=s_age %></font><br>
</body>
</html>