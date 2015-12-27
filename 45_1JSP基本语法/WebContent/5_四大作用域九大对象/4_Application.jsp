<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Application Scope</title>
</head>
<body>
<!-- Application 范围: 在整个服务器上保存数据, 所有用户共享; javax.servlet.ServletContext(接口) -->
<%
	// 设置两个application 范围的数据 --> key: value
	application.setAttribute("s_name", "s_guibs");
	application.setAttribute("s_age", 23);
%>
<script type="text/javascript">
	alert("Application值设置完毕, 数据在服务器端, 浏览器关了也无所谓.")
</script>
</body>
</html>