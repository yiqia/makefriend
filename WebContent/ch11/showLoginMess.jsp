<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="mybean.data.Login" %>
<jsp:useBean id="login" class="mybean.data.Login" scope="session"/>
<head><%@ include file="head.txt" %></head>
<html>
<body bgcolor=pink>
	<center>
		<font size=4 color=blue>
			<br><jsp:getProperty property="backNews" name="login"/>
		</font>
		<font size=2 color=cyan>
		<%	
			// 登录成功 显示会员名
			if(login.getSuccess()==true){
		%>
				<br>登录会员名称：<jsp:getProperty property="logname" name="login"/>
		<%	}
			else{	// 登录失败 显示登录失败的会员名和密码
		%>	
				<br>登录会员名称：<jsp:getProperty property="logname" name="login"/>
				<br>登录会员密码：<jsp:getProperty property="password" name="login"/>
		<%	
			}
		%>
		</font>
	</center>
</body>
</html>