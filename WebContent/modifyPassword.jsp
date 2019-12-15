<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<head><%@ include file="head.txt" %></head>
<html>
<body bgcolor=cyan>
<font size=2>
<center>
	<br>请输入您的当前密码和新密码：
	<form action="helpModifyPassword" method="post">
		<br>当前密码：<input type="password" name="oldPassword">
		<br>新密码：<input type="password" name="newPassword">
		<br><input type="submit" name="g" value="提交">
	</form>
</center>
</font>
</body>
</html>