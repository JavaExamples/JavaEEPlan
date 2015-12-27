<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp:include动态包含</title>
</head>
<body>
<!-- jsp:include动态包含 -->
<!-- 先各自单独编译, 而后将编译结果放入页面 -->
<!-- Head -->
<jsp:include page="Head.html"/>
<p>Content</p>
<!-- Footer -->
<jsp:include page="Footer.jsp"/>
</body>
</html>