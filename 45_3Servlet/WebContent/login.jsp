<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form action="login" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<!-- el表达式, 用于自动填写请求里的参数 -->
				<td><input type="text" name="userName" value="${err_userName }"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="password" value="${err_password }"></td>
			</tr>
			<tr>
				<td><input type="submit" value="登入"></td>
				<td><font color="red">${err_message }</font></td>
			</tr>
		</table>
	</form>
</body>
</html> 