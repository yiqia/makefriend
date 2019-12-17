<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<head>
<link href="style/reset.css" rel="stylesheet" />
<link href="style/main.css" rel="stylesheet" />
<link href="style/yiqi.css" rel="stylesheet" />	
<%@ include file="head.txt" %></head>
<link rel="stylesheet" type="text/css" href="style/login.css"/>
<html>
<body>
			<div class="box">
				<table  style="width: 100%;">
					<tr><th style="padding: 10px 0;">登录账号：</th></tr>
					<form action="helpLogin" method="post">
						<tr style="height: 60px;"><td><input type="text" name="logname" placeholder="账号" class="logname"></td></tr>
						<tr style="height: 60px;"><td><input type="text" name="password" placeholder="密码" class="logname"></td></tr>
				</table>	
						<br>
						<input class="submit" type="submit" name="g" value="提交">
				</form>
				
			</div>
</body>
</html>