<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<head><%@ include file="head.txt" %></head>
<link rel="stylesheet" type="text/css" href="style/register.css"/>
<html>
<body >
	<div style="border: 1px solid #CCCCCC;;box-shadow: 3px 6px 12px #CCCCCC;padding: 20px;
		    border-radius: 8px;">
<center>
<font size=2>
	<form action="helpModifyMess" name="form" method="post">
		<table class="table1">
			<tr><td>新联系电话：</td>
				<td><input type="text" name="newPhone"></td>
			</tr>
			<tr><td>新电子邮件：</td>
				<td><input type="text" name="newEmail"></td>
			</tr>
		</table>
		<table style="width: 100%;">
			<tr><td>新简历和交友标准：</td>
			</tr>
			<tr><td><textarea class="textarea" name="newMessage" rows="6" cols="30"></textarea>
				</td>
			</tr>
			<tr><td><input style="width: 65px;" class="submit" type="submit" name="g" value="提交修改"></td>
			</tr>
			<tr><td><input style="width: 65px;float:none;"  class="submit" type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</font>
</center>
</div>
</body>
</html>