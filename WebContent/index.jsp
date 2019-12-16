<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="head.txt" %></head>
<!doctype html>
<html>
<script type="text/JavaScript" src="js/yiqi.js"></script>
<style>
	body { overflow-y: hidden; }
</style>
<body bgcolor="#F5F5F5">
	<div id="box">
	<div style="width:100%;height:80px"></div>
				<div class="bottom">
			<div id="left">
				<div class="touxiang" align="center">
					<img src="http://q2.qlogo.cn/headimg_dl?dst_uin=330729121&spec=5"  id="touxiang">
					<p>欢迎你</p>
				</div>
				<div align="left" class="cebianlan">
					<ul>
						<li  onClick="iFrame('hello.jsp')"><img src="./icon/zy.png"><a href="#">首页</a></li>
						<li onClick="iFrame('register.jsp')"><img src="./icon/chat.png"><a href="#">会员注册</a></li>
						<li onClick="iFrame('login.jsp')"><img src="./icon/yuanfen.png"><a href="#">会员登录</a></li>
						<li onClick="iFrame('upload.jsp')"><img src="./icon/love2.png"><a href="#">上传照片</a></li>
						<li onClick="iFrame('choiceLookType.jsp')"><img src="./icon/ip1.png"><a href="#">浏览会员</a></li>
						<li onClick="iFrame('inputModifyMess.jsp')"><img src="./icon/book.png"><a href="#">修改注册信息</a></li>
						<li  onClick="iFrame('modifyPassword.jsp')"><img src="./icon/touxiang.png"><a href="#">修改密码</a></li>
						<li  onClick="iFrame('hello.jsp')"><img src="./icon/touxiang.png"><a href="#">退出登录</a></li>
					</ul>
				</div>
			</div>
			<div id="right">
					<iframe src='./hello.jsp' width='100%' height='100%' frameborder='0' name="_blank" id="iFrame-content" ></iframe>
					
			</div>
		</div>
		<div class="head">
			<h1>交友信息发布网</h1>
			<div class="openclose" id="openclose">
				<img id="xiangleftright" src="./icon/candan.png">
			</div>
		</div>
		</div>
		
</body>

	<script type="text/JavaScript" src="js/main.js"></script>
	<script type="text/JavaScript">
			var xialaheight = 0;
				xialadianji = byId("head-right-xiala");
				function xialadj(){
					if(xialadianji.style.display=="none"){
					   			xialadianji.style.display="block";
								xialaheight=byId("head-right-xiala").scrollHeight,
								xialadianji.style.height=0+"px";
								xialadianji.style.height=xialaheight+"px";
					   }else if(xialadianji.style.height=="0px"){
								xialadianji.style.height=xialaheight+"px";
						}else{
								xialaheight=byId("head-right-xiala").scrollHeight,
								xialadianji.style.height=0+"px";
					   }
					
				}
				

	</script>
</html>