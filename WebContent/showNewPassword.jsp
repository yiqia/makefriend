<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="mybean.data.Password" %>
<jsp:useBean id="password" class="mybean.data.Password" scope="request"/>
<head><%@ include file="head.txt" %></head>
<style type="text/css">
	p{
		height: 30px;
		line-height: 30px;
	}
</style>
<html>
<body >
	<div style="border: 1px solid #CCCCCC;;box-shadow: 3px 6px 12px #CCCCCC;padding: 20px;
		    border-radius: 8px;">
<center><font size=3>
	<p><jsp:getProperty property="backNews" name="password"/></p>
	<p>您的新密码：<jsp:getProperty property="newPassword" name="password"/></p>
	<p>您的旧密码：<jsp:getProperty property="oldPassword" name="password"/></p>
</font></center>
</div>
</body>
</html>