// JavaScript Document


	window.onload=function(){
		
		/*侧边栏动画*/
		 var cebianlan = document.getElementById("xiangleftright");
			cebianlan.onclick=function(){
				var cebianlanleft = document.getElementById("left");
					if(cebianlanleft.style.left==0+"px"){
						cebianlanleft.style.left=-250+"px";
						var zhezhao = document.getElementById("zhezhao");
							document.body.removeChild(zhezhao);
					}else{
						cebianlanleft.style.left=0+"px";
						var zhezhao = document.createElement("div");
				   		zhezhao.id="zhezhao";
						document.body.appendChild(zhezhao);
					}
			}
	
			
	}
		/*删除遮罩 并且侧边栏隐藏*/
	
		function sczhezhao(){
			var cebianlanleft = document.getElementById("left");
			var zhezhao = document.getElementById("zhezhao");
				document.body.removeChild(zhezhao);
				cebianlanleft.style.left=-250+"px";
				
		}
		

				/*点击跳转到iframe地址*/
						function iFrame(url){
						var iframe = byId("iFrame-content");
							iframe.src=url;
							sczhezhao();
					}

			/*点击隐藏和现实下拉菜单*/
				

		