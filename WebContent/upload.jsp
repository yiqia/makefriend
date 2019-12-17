<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<head><%@ include file="head.jsp" %></head>
;<link rel="stylesheet" type="text/css" href="style/upload.css"/>
<html>
<body >
	<div class="upload">
		<font size=2 color=blue>
			<center>
				<br>
				<p>文件将被上传到Web服务目录mkfriend的子目录image中 .</p>
				<p>选择要上传的图像照片文件</p>
				<p style="color: darkred;">(名字不可以含有非ASCII码字符，比如汉字等)</p>
				<form action="helpUpload" method="post" ENCTYPE="multipart/form-data">
					<input style="    padding: 20px 0;" type="file" name="fileName" size="40">
					<br>
					<input class="submit" type="submit" name="g" value="提交" >
				</form>
			</center>
		</font>
		
	</div>
	
</body>
</html>