<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<head><%@ include file="head.txt" %></head>
<html>
<body bgcolor=pink>
	<font size=2>
		<center>
			<br><br>
			<table border=2>
				<tr><th>请您登录</th></tr>
				<form action="helpLogin" method="post">
					<tr><td>登录名称：<input type="text" name="logname"></td></tr>
					<tr><td>输入密码：<input type="text" name="password"></td></tr>
			</table>	
					<br>
					<input type="submit" name="g" value="提交">
				</form>
		</center>
	</font>
</body>
</html>