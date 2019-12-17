<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<head><%@ include file="head.jsp" %></head>
<html>
<style>
	.submit{
		box-shadow: 3px 6px 12px #CCCCCC;
		background-color: coral;
		width: 50px;
		    display: inline-block;
		    padding: 4px 5px;
		    margin-bottom: 0;
		    font-size: 14px;
		    font-weight: 400;
		    line-height: 1.42857143;
		    text-align: center;
		    white-space: nowrap;
		    vertical-align: middle;
		    -ms-touch-action: manipulation;
		    touch-action: manipulation;
		    cursor: pointer;
		    -webkit-user-select: none;
		    -moz-user-select: none;
		    -ms-user-select: none;
		    user-select: none;
		    background-image: none;
		    border: 1px solid transparent;
		    border-radius: 4px;
	}
	.box{
		padding: 10px 0;
	}
</style>
<body  class="fwq-content">
	<div style="border: 1px solid #CCCCCC;;box-shadow: 3px 6px 12px #CCCCCC;padding: 20px;
		    border-radius: 8px;">
<center>
<font size=3>
	
	<table>
		<form action="helpShowMember" method="post" name="form">
			<div class="box">
			分页显示全体会员:
				<input type="hidden" value="1" name="showPage" size=6>
				<input class="submit" type="submit" value="显示" name="submit">
			</div>		
		</form>
		
		<form action="helpShowMember" method="get" name="form">
		<div class="box">输入要查找的会员名：
			<input type="text" name="logname" size=7>
			<input class="submit" type="submit" value="显示" name="submit">
		</form>
		</div>
	</table>
</font>
</center>
</div>
</body>
</html>