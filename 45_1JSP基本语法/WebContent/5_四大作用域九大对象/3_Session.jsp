<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session Scope</title>
</head>
<body>
<!-- Session 范围: 在一次会话范围中中保存数据, 仅供单个用户使用 javax.servlet.http.HttpSession(接口) -->
<%
	// 设置两个session 范围的数据 --> key: value
	session.setAttribute("s_name", "s_guibs");
	session.setAttribute("s_age", 23);
%>
<script type="text/javascript">
	alert("Session值设置完毕, 浏览器不关他就在")
</script>
</body>
</html>