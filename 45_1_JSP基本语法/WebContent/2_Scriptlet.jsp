<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- < %!... % >这个标签定义全局变量, 方法, 类 -->
<%!String str = "这个标签里可以定义全局变量, 方法, 类";%>
<%!public void fun1() {
		System.out.println("全局方法");
	}%>
<%!class C {
		// private int a;
		public void introduce() {
			System.out.print("我是全局类");
		}
	}%>
<!-- < %... % >这个标签定义局部变量, 编写语句-->
<%
	// Java单行注释
	/*
	Java多行注释
	*/
	int a = 123;
	String b = "这个标签可以设置局部变量";
	out.print(a + b);
%>
<title>Scriptlet</title>
</head>
<body>
	<!-- < %=... % >这个标签输出一个变量或具体内容-->
	<%="要输出的内容<br>"%>
	<%=b + "<br>"%>
	<%=str + "<br>"%>
</body>
</html>