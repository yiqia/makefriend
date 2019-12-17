<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<head><%@ include file="head.jsp" %></head>
<link rel="stylesheet" type="text/css" href="style/register.css"/>
<html>
<body >
	

<form action="helpRegister" name=form method="post" class="form_box">
	<table class="table1" >
		<p class="msg">输入您的信息，会员名必须由字母和数字组成，带*号项必须填写 .</p>
		<tr><td>会员名称：</td><td><input type="text" name="logname"><span>*</span></td></tr>
		<tr><td>设置密码：</td><td><input type="text" name="password"><span>*</span></td></tr>
		<tr><td>电子邮件：</td><td><input type="text" name="email"></td></tr>
		<tr><td>联系电话：</td><td><input type="text" name="phone"></td></tr>
	</table>
	<table style="width: 100%">
		<tr class="msg"><td><font size=2>输入您的简历和交友标准：</font></td></tr>
		<tr>
			<td><textarea class="textarea" name="message" rows="6" cols="30"></textarea></td>
		</tr>
		<tr><td><input class="submit" type="submit" name="g" value="提交"></td></tr>
	</table>
</form>

</body>
</html>