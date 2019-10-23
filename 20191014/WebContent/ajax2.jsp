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
<div id="div1"></div>
<input type="text" id="name" />
<input type="text" id="age" />
</body>
<script type="text/javascript">
	document.getElementById("btn").onclick = function(){
		var req ;
		if(window.XMLHttpRequest){
			req = new window.XMLHttpRequest();
		}else{
			req = new ActiveXObject("Miscosoft.XMLHTTP");
		}
		var name = document.getElementById("name").value;
		var age = document.getElementById("age").value;
		req.open("GET","${pageContext.request.contextPath}/AjaxServlet1?nn="+name+"&age="+age);
		req.send();
		
		req.onreadystatechange=function(){
			if(req.readyState==4 && req.status==200){
				var txt = req.responseText;
				//string => json
				var json = JSON.parse(txt);
				console.log(txt);
				console.log(json);
				document.getElementById("div1").innerHTML = "姓名:"+json["name"]+"<br/> 性别:"+json.sex+"<br/> 年龄："+json["age"];
			}
		};
		
		
		
		
		
		
		
		
		
	};
</script>
</html>