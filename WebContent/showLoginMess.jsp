<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="mybean.data.Login" %>
<jsp:useBean id="login" class="mybean.data.Login" scope="session"/>
<head><%@ include file="head.txt" %></head>
<html>
<body >
	<div style="border: 1px solid #CCCCCC;;box-shadow: 3px 6px 12px #CCCCCC;padding: 20px;
		    border-radius: 8px;">
	<center>
		<font size=4 style="color: black;
    padding-bottom: 20px;
    display: inline-block;width: 170px;">
			<br><jsp:getProperty property="backNews" name="login"/>
		</font>
		<font size=2 color=black>
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
	</div>
</body>
</html>