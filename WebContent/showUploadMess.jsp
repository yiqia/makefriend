<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="mybean.data.UploadFile" %>
<jsp:useBean id="upFile" class="mybean.data.UploadFile" scope="session"/>
<head><%@ include file="head.txt" %></head>
<html>
<body >
<div style="border: 1px solid #CCCCCC;;box-shadow: 3px 6px 12px #CCCCCC;padding: 20px;
	    border-radius: 8px;">
	<center>
		<font size=2 color=blue>
		<br><jsp:getProperty property="backNews" name="upFile"/>
		</font>
		<br><font size=2>
		<br><p style="padding: 20px 0;">保存后的文件名字：<jsp:getProperty property="savedFileName" name="upFile"/></p>
		<br>
		<img src="image\<jsp:getProperty name="upFile" property="savedFileName"/>" width=100 height=120>图像效果</img>
		</font>
	</center>
</div>
</body>
</html>