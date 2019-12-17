<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<head><%@ include file="head.jsp" %></head>
<style type="text/css">
	.submit{
		background-color: coral;
		border-radius: 4px;
		border: 0px;
		    height: 25px;
		    width: 50px;
		    float: right;
			box-shadow: 3px 6px 12px #CCCCCC
	}
	.input{
		border: 1px solid #000000;
		border-radius: 4px;
	}
	.box{
		height: 50px;
	}
</style>
<html>
<body>
	<div style="border: 1px solid #CCCCCC;;box-shadow: 3px 6px 12px #CCCCCC;padding: 20px;
		    border-radius: 8px;">
<font size=2>
<center>
	<p style="padding: 10px 0;color: darkred;">请输入您的当前密码和新密码：</p>
	<form action="helpModifyPassword" method="post">
		<div class="box">
			当前密码：<input class="input" type="password" name="oldPassword">
		</div>
		<div class="box">
			新密码：<input style="margin-left: 10px;" class="input" type="password" name="newPassword">
		</div>
		<div class="box">
			<input class="submit" type="submit" name="g" value="提交">
		</div>
	</form>
</center>
</font>
</div>
</body>
</html>