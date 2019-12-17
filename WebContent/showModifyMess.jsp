<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="mybean.data.ModifyMessage" %>
<jsp:useBean id="modify" class="mybean.data.ModifyMessage" scope="request"/>
<head><%@ include file="head.jsp" %></head>
<style type="text/css">
	.table td{
		border: 1px solid #ccc;
		    border-radius: 4px;
		    text-align: center;
	}
</style>
<html>
<body >
	<div style="border: 1px solid #CCCCCC;;box-shadow: 3px 6px 12px #CCCCCC;padding: 20px;
		    border-radius: 8px;">
<font size=3>
<center>
	<p style="padding: 10px 0;"><jsp:getProperty property="backNews" name="modify"/>,
	您修改的信息如下：</p>
	<table class="table">
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
</div>
</body>
</html>