<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="mybean.data.Register" %>
<jsp:useBean id="register" class="mybean.data.Register" scope="request" />
<head><%@ include file="head.jsp" %></head>
<html>
<body >
	<div style="border: 1px solid #CCCCCC;;box-shadow: 3px 6px 12px #CCCCCC;padding: 20px;
		    border-radius: 8px;">
	<center>
		<font size=4>
			<!-- 此显示提示信息 -->
			<p style="padding-bottom: 10px;"><br><jsp:getProperty property="backNews" name="register"/></p>
		</font>
		
		<!-- 如果注册成功此处会显示注册信息 -->
		<table >
			<tr style="height: 50px;"><td>注册的会员名称：</td>
				<td><jsp:getProperty property="logname" name="register"/></td>
			</tr>
			<tr style="height: 50px;"><td>注册的电子邮件：</td>
				<td><jsp:getProperty property="email" name="register"/></td>
			</tr>
			<tr  style="height: 50px;"><td>注册的联系电话：</td>
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
	</div>
</body>
</html>