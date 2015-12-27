<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Config 对象</title>
</head>
<body>
	<!-- Config 内置对象是JSP 页面通过JSP 容器进行初始化时被传递的对象; javax.servlet.ServletConfig -->
	<!-- 在Servlet 初始化的时候, JSP引擎通过config 向他传递信息 -->
	<!-- 这种信息可以是属性名和属性值匹配的参数, 也可以是通过ServletContext 对象传递的服务器相关信息 -->
	<!-- 看web.xml -->
	<%
		String servletPara1 = config.getInitParameter("initName1");
		String servletPara2 = config.getInitParameter("initName2");
	%>
	<h1>ServletPara1:<%=servletPara1 %><br></h1>
	<h1>ServletPara2:<%=servletPara2 %><br></h1>
</body>
</html>