<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="mybean.data.ModifyMessage" %>
<jsp:useBean id="modify" class="mybean.data.ModifyMessage" scope="request"/>
<head><%@ include file="head.txt" %></head>
<html>
<body bgcolor=yellow>
<font size=3>
<center>
	<jsp:getProperty property="backNews" name="modify"/>,
	您修改的信息如下：
	<table border=1>
		<tr><td>新电话</td>
			<td>新email</td>
			<td>新简历和交友标准</td>
		</tr>
		<tr><td><jsp:getProperty property="newPhone" name="modify"/>
			<td><jsp:getProperty property="newEmail" name="modify"/>
			<td><textarea>
				<jsp:getProperty property="newMessage" name="modify"/>
			</textarea></td>
		</tr>
	</table>
</center>
</font>
</body>
</html>