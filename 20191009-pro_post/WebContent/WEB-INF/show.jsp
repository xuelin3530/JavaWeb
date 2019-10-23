<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示查询结果</title>
<style>
	.even{
		background: pink;
	}
	.odd{
		background: greenyellow;
	}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${fn:length(emps)==0 }">
			<h2>无符合条件的记录</h2>
		</c:when>
	<c:otherwise>
		<table border="0" width="600" align="center">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>岗位</td>
			<td>年龄</td>
			<td>性别</td>
			<td>工龄</td>
		</tr>
		<c:forEach items="${emps }" var="e" varStatus="vs">
			<tr  class="${vs.index%2==0?'odd':'even' }">
			<td>${e.id }</td>
			<td>${e.name }</td>
			<td>${e.post.name }</td>
			<td>${e.age }</td>
			<td>${e.sex }</td>
			<td>${e.year }</td>
		</tr>
		</c:forEach>
		</table>
	</c:otherwise>
	</c:choose>
</body>
</html>