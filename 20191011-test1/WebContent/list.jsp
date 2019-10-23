<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${sessionScope.deptName }用户列表</h1>
<input type="checkbox" id="all" />全选
<button id="addBtn">添加</button>
<button id="updateBtn">修改</button>
<button id="delBtn">删除</button>
<table border="1" width="300">
	<tr>
		<th>选择</th>
		<th>编号</th>
		<th>姓名</th>
		<th>性别</th>
		<th>电话</th>
	</tr>
	<c:forEach items="${sessionScope.users }" var ="u">
		<tr>
		<th><input type="checkbox"  name="xz" value="${u.id }" /></th>
		<th>${u.id }</th>
		<th>${u.uname }</th>
		<th>${u.sex }</th>
		<th>${u.tel }</th>
	</tr>
	</c:forEach>
</table>
</body>
<script type="text/javascript">
	document.getElementById("all").onchange=function(){
		var chs = document.getElementsByName("xz");
		for(var i=0; i<chs.length; i++){
			chs[i].checked = this.checked;
		}
		
	};
	
	document.getElementById("addBtn").onclick = function(){
		window.location = "${pageContext.request.contextPath}/add.jsp";
	}
	
	document.getElementById("updateBtn").onclick = function(){
		var chs = document.getElementsByName("xz");
		var cnt =0;
		var id = 0;
		for(var i=0; i<chs.length; i++){
			if(chs[i].checked){
				cnt++;
				id = chs[i].value;
			}
		}
		if(cnt!=1){
			alert("请选择一条记录进行修改");
			return;
		}
		
		
		window.location = "${pageContext.request.contextPath}/GetUserServlet?id="+id;
		
	};
	
	document.getElementById("delBtn").onclick = function(){
		var chs = document.getElementsByName("xz");
		var cnt=0;
		var ids = "";
		for(var i=0; i<chs.length; i++){
			if(chs[i].checked){
				cnt++;
				ids = ids + chs[i].value+",";
			}
		}
		if(cnt==0){
			alert("请至少选中一条记录删除");
			return ;
		}
		
		var rs = window.confirm("确定要删除这些记录吗？");
		if(!rs){
			return;
		}
		
		ids = ids.substring(0,ids.length-1);
		
		window.location = "${pageContext.request.contextPath}/DelUserServlet?id="+ids;
	};

</script>
</html>