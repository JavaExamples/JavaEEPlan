<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Response 操作cookie</title>
<script type="text/javascript">
	function resetValue() {
		document.getElementById("userName").value = "";
		document.getElementById("password").value = "";
	}
</script>

<!-- 读取cookie -->
<%
	String c_userName = null;
	String c_pwd = null;
	Cookie[] cookies = request.getCookies();
	for(int i = 0; cookies != null && i < cookies.length; i++) {
		if (cookies[i].getName().endsWith("userNameAndPwd")) {
			String userNameAndPwd = cookies[i].getValue();
			c_userName = userNameAndPwd.split("-")[0];
			c_pwd = userNameAndPwd.split("-")[1];
		}
	}
	
	if(c_userName==null || c_pwd == null) {
		c_userName = "";
		c_pwd = "";
	}
%>
</head>
<body>
	<!-- 3.操作Cookie应用 -->
	<!-- post get 方法比较: post 放数据包里, get 放URL后面 get 数据量小, 不安全 -->
	<!-- cookie 和 session 比较: cookie 信息是存客户端的, session 信息是存服务器的 -->
	<form action="userLogin.jsp" method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input id="userName" name="userName" value="<%= c_userName%>"></td>
			</tr>
			<tr>
				<td>密 码:</td>
				<td><input id="password" name="pwd" value="<%= c_pwd%>"></td>
			</tr>
			<tr>
				<td>记住密码:</td>
				<!-- 若选中checkbox 则返回yes, 否则为null -->
				<td><input type="checkbox" id="remeber" name="remeber"
					value="yes"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交">:</td>
				<td><input type="button" value="重置" onclick="resetValue()"></td>
			</tr>
		</table>
	</form>
</body>
</html>