<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tag C</title>
</head>
<%
	pageContext.setAttribute("people", "张三");
%>
<body>
	<c:out value="cout输出标签"></c:out>
	<c:out value="${people }"></c:out>
	<!-- c:out 若无输出对象，可以设置默认值 -->
	<c:out value="${people2 }" default="某人"></c:out>
	<br>

	<!-- c:set 设置不同作用域的值 -->
	<c:set var="cp" value="c—张三" scope="request"></c:set>
	<c:out value="${cp }"></c:out>

	<jsp:useBean id="peopleByClass" class="com.classcontent.model.People">
		<!-- c:set 给目标对象属性设置值 -->
		<c:set property="id" target="${peopleByClass }" value="007"></c:set>
		<c:set property="name" target="${peopleByClass }" value="Guibs"></c:set>
		<c:set property="age" target="${peopleByClass }" value="23"></c:set>
	</jsp:useBean>
	<br> 编号：${peopleByClass.id }
	<br> 姓名：${peopleByClass.name }
	<br> 年龄：${peopleByClass.age }
	<br>

	<!-- c:remove 移除对象 -->
	<c:remove var="cp" scope="request" />
	<br>
	<c:out value="${cp }" default="被移除了"></c:out>
	<br>

	<!-- c:catch 捕获异常信息 -->
	<c:catch var="errMsg">
		<%
			int a = 1 / 0;
		%>
	</c:catch>
	异常信息： ${errMsg }
	<br>

	<!-- c:if -->
	<c:if test="${peopleByClass.name == 'Guibs' }">
		<c:out value="Hello Guibs"></c:out>
	</c:if>

	<!-- c:choose -->
	<c:choose>
		<c:when test="${peopleByClass.age<18 }">
			<h1>未成年</h1>
		</c:when>
		<c:when test="${peopleByClass.age==18 }">
			<h1>刚成年</h1>
		</c:when>
		<c:when test="${peopleByClass.age>18 }">
			<h1>已成年</h1>
		</c:when>
	</c:choose>

	<!-- c:each -->
	<%
		int nums[] = { 1, 2, 3, 4, 5 };
		pageContext.setAttribute("nums", nums);
	%>
	<!-- 设置间隔为2 从第一个元素开始到第三个元素-->
	<c:forEach var="num" items="${nums}" step="2" begin="1" end="3">
		${num }
	</c:forEach>

	<!-- c:forTokens 分割字符串 -->
	<%
		String str1 = "www.guibs.com";
		String str2 = "1-2-3-4-5";
		pageContext.setAttribute("str1", str1);
		pageContext.setAttribute("str2", str2);
	%>
	<c:forTokens items="${str1 }" delims="." var="s1">
		${s1 }
	</c:forTokens>
	<c:forTokens items="${str2 }" delims="-" var="s2">
		${s2 }
	</c:forTokens>

	<!-- c:incloud 嵌入页面 -->
	<br>
	<c:import url="HelloWorld.jsp"></c:import>
	<br>

	<!-- c:url -->
	<c:url value="https://www.baidu.com" var="url">
		<c:param name="name" value="guibs"></c:param>
	</c:url>
	<a href="${url }">test</a>

	<!-- c:redirect 页面跳转 -->
	<c:redirect url="HelloWorld.jsp">
		<c:param name="name" value="guibs"></c:param>
	</c:redirect>
</body>
</html>