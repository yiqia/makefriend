<%@page import="java.util.ArrayList"%>
<%@page import="mybean.data.MemberInform"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="mybean.data.ShowByPage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="show" class="mybean.data.ShowByPage" scope="session"/>
<head><%@ include file="head.txt" %></head>
<link rel="stylesheet" type="text/css" href="style/login.css"/>
<html>
<body>
<div style="border: 1px solid #CCCCCC;;box-shadow: 3px 6px 12px #CCCCCC;padding: 20px;
		    border-radius: 8px;">
<%	Integer pages = (Integer)request.getAttribute("page"); 
	Integer pagess = (Integer)request.getAttribute("pages"); 
	if(pages<=0) pages = 1;
	show.setShowPage(pages);
	show.setPageAllCount(pagess);	
%>
<center>
	<table class="zlk_table">
		<br>当前显示的内容是：
		<tr>
			<th>会员名</th>
			<th>电话</th>
			<th>email</th>
			<th>简历和交友标准</th>
			<th>用户照片</th>
		</tr>
			<c:forEach items="${list}" var="emp">
			<tr>
				<td>${emp.logname}</td>
				<td>${emp.email}</td>
				<td>${emp.phone}</td>
				<td>${emp.message}</td>
				<td><image style="max-height:49px;" src='https://qq.q05.cc/cc.q05.mkfriend/image/${emp.pic}'/></td>
			</tr>
		</c:forEach>
	</table>
	<br>每页最多显示<jsp:getProperty property="pageSize" name="show"/>
	<br>
	
	当前显示第<font color=darkred>
		<jsp:getProperty property="showPage" name="show"/>	
	</font>页
	
	<br>共<jsp:getProperty property="pageAllCount" name="show"/>页
	<br>单击“上一页”或“下一页”按钮查看信息
	<table >
		<tr><td><form action="helpShowMember" method="post">
			<input type="hidden" name="showPage" value="<%=show.getShowPage()-1 %>">
			<input style="padding: 1px;" class="submit" type="submit" name="g" value="上一页">
		</form></td>
		<td><form action="helpShowMember" method="post">
			<input type="hidden" name="showPage" value="<%=show.getShowPage()+1 %>">
			<input style="padding: 1px;" class="submit" type="submit" name="g" value="下一页">
		</form></td>
		<td><form action="helpShowMember" method="post">
			输入页码：<input type="text" name="showPage" size=5>
			<input type="submit" name="g" value="提交">
		</form></td>
	</table>
</center>
</div>
</body>
</html>