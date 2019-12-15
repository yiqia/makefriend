<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<head><%@ include file="head.txt" %></head>
<html>
<body bgcolor=cyan>
<font size=2>
<center>
<form action="helpRegister" name=form method="post">
	<table>
		输入您的信息，会员名必须由字母和数字组成，带*号项必须填写 .
		<tr><td>会员名称：</td><td><input type="text" name="logname">*</td></tr>
		<tr><td>设置密码：</td><td><input type="text" name="password">*</td></tr>
		<tr><td>电子邮件：</td><td><input type="text" name="email"></td></tr>
		<tr><td>联系电话：</td><td><input type="text" name="phone"></td></tr>
	</table>
	<table>
		<tr><td><font size=2>输入您的简历和交友标准：</font></td></tr>
		<tr>
			<td><textarea name="message" rows="6" cols="30"></textarea></td>
		</tr>
		<tr><td><input type="submit" name="g" value="提交"></td></tr>
	</table>
</form>
</center>
</font>
</body>
</html>