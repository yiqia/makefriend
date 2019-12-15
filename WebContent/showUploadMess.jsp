<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="mybean.data.UploadFile" %>
<jsp:useBean id="upFile" class="mybean.data.UploadFile" scope="session"/>
<head><%@ include file="head.txt" %></head>
<html>
<body bgcolor=cyan>
<center>
	<font size=2 color=blue>
	<br><jsp:getProperty property="backNews" name="upFile"/>
	</font>
	<br><font size=2>
	<br>保存后的文件名字：<jsp:getProperty property="savedFileName" name="upFile"/>
	<br>
	<img src="image\<jsp:getProperty name="upFile" property="savedFileName"/>" width=50 height=120>图像效果</img>
	</font>
</center>
</body>
</html>