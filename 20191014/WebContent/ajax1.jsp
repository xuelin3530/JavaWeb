<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button id="btn">ajax 请求</button>
<div id="div1">div1</div>
<input type="text" name="uname" />
</body>
<script type="text/javascript">
	document.getElementById("btn").onclick=function(){
		
		//获取请求对象
		var req;
		//高版本浏览器 XMLHttpRequest(), ie低版本 ActiveXObject("Microsoft.XMLHTTP")
		if(window.XMLHttpRequest){
			req = new window.XMLHttpRequest();
		}else{
			req = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		//设置请求url
		req.open("GET","a.txt");
		//发送请求
		req.send();
		
		//如果请求成功，要做什么 onreadystatechange
		req.onreadystatechange=function(){
			//请求成功 readystate==4 && status==200
			console.log(req.readyState);
			console.log(req.status);
			if(req.readyState==4 && req.status==200){
				//获得响应结果
				var txt = req.responseText;
				//处理响应结果
				document.getElementById("div1").innerHTML = txt;
			}
			
		};
		
	};





</script>
</html>