<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="mybean.data.Password" %>
<jsp:useBean id="password" class="mybean.data.Password" scope="request"/>
<head><%@ include file="head.txt" %></head>
<html>
<body bgcolor=yellow>
<center><font size=3>
	<br><jsp:getProperty property="backNews" name="password"/>
	<br>您的新密码：<jsp:getProperty property="newPassword" name="password"/>
	<br>您的旧密码：<jsp:getProperty property="oldPassword" name="password"/>
</font></center>
</body>
</html>