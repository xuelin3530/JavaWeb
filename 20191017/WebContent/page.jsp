<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#pagediv, #div2{
	width:400px;
	text-align:center;
}
#pagediv a{
	display:inline-block;
	width:30px;
}
</style>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
</head>
<body>
<c:if test="${empty page }">
	<c:redirect url="/PageServlet"></c:redirect>
</c:if>
<input type="radio" value="5" name="size" checked="checked"/>每页5条
<input type="radio" value="10" name="size"  ${size==10? "checked='checked'" :"" }/>每页10条
<input type="radio" value="20" name="size"  ${size==20? "checked='checked'" :"" }/>每页20条
<table border="1" cellspacing='0' width="400">
	<tr>
		<th>编号</th>
		<th>姓名</th>
		<th>性别</th>
		<th>联系方式</th>
		<th>部门</th>
	</tr>
	<tbody id="tbody">
		<c:forEach items="${page.list }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.uname }</td>
				<td>${user.sex }</td>
				<td>${user.tel }</td>
				<td>${user.depa }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div id="pagediv">
	<c:forEach begin="1" end="${page.totalPage }" var="i">
		<a href="#">${i }</a>
	</c:forEach>
</div>
<div id="div2">
	共${page.totalRecord }记录 共${page.totalPage }页
</div>

</body>
<script type="text/javascript">
$("input[name='size']").click(function(){
	var size = $(this).val();
	window.location = "${pageContext.request.contextPath }/PageServlet?size="+size+"&no=1";
});

$("#pagediv").on("click", "a", function(){
	var no = $(this).html();
	window.location = "${pageContext.request.contextPath }/PageServlet?no="+no+"&size="+${size};
	
});

</script>
</html>