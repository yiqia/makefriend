<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="mybean.data.Register" %>
<jsp:useBean id="register" class="mybean.data.Register" scope="request" />
<head><%@ include file="head.txt" %></head>
<html>
<body bgcolor=cyan>
	<center>
		<font size=4>
			<!-- 此显示提示信息 -->
			<br><jsp:getProperty property="backNews" name="register"/>
		</font>
		
		<!-- 如果注册成功此处会显示注册信息 -->
		<table>
			<tr><td>注册的会员名称：</td>
				<td><jsp:getProperty property="logname" name="register"/></td>
			</tr>
			<tr><td>注册的电子邮件：</td>
				<td><jsp:getProperty property="email" name="register"/></td>
			</tr>
			<tr><td>注册的联系电话：</td>
				<td><jsp:getProperty property="phone" name="register"/></td>
			</tr>
		</table>
		<table><tr><td>您的简历和交友标准：</td></tr>
			<tr><td><textarea name="message" rows="6" cols="30">
				<jsp:getProperty property="message" name="register"/>
			</textarea>
			</td></tr>
		</table>
	</center>
</body>
</html>