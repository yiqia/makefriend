<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="mybean.data.MemberInform" %>
<head><%@ include file="head.jsp" %></head>
<jsp:useBean id="inform" class="mybean.data.MemberInform" scope="request"/>
<html>
<body >
	<div style="border: 1px solid #CCCCCC;;box-shadow: 3px 6px 12px #CCCCCC;padding: 20px;
		    border-radius: 8px;">
<center>
	<table border=2>
		<tr>
			<th>会员名</th>
			<th>电话</th>
			<th>email</th>
			<th>简历和交友标准</th>
			<th>用户照片</th>
		</tr>
		<tr>
			<td><jsp:getProperty property="logname" name="inform"/></td>
			<td><jsp:getProperty property="phone" name="inform"/></td>
			<td><jsp:getProperty property="email" name="inform"/></td>
			<td><jsp:getProperty property="message" name="inform"/></td>
			<td><img src="image/<jsp:getProperty name="inform" property="pic"/>" width=50 height=50/></td>
		</tr>
	</table>
</center>
</div>
</body>
</html>