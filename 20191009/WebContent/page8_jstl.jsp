<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.pojo.Post"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.setAttribute("name", "张三");
	session.setAttribute("age", 78);
	session.setAttribute("sex", "男");
	

	List<Integer> list = new ArrayList<Integer>();
	list.add(10);
	list.add(20);
	list.add(30);
	list.add(40);
	session.setAttribute("nums", list);
	
	List<Post> ps = new ArrayList<Post>();
	ps.add(new Post(11,"总裁秘书","总裁助理"));
	ps.add(new Post(22,"总裁","公司负责人"));
	ps.add(new Post(33,"秘书助理","打杂"));
	
	session.setAttribute("list", ps);
%>

<c:if test="${empty name }">
	名字不存在
</c:if>
<hr/>
<c:if test="${age < 18 }">
	对不起，不能买烟~~
</c:if>
<hr/>
<c:if test="${sex=='男' }">干活去</c:if>
<hr/>
<c:choose>
	<c:when test="${age < 6 or age >=70 }">免费入园</c:when>
	<c:when test="${age>=6 and age<=10 or age>=60 and age<=69 }">半价入园</c:when>
	<c:when test="${sex=='女' }">八折入园</c:when>
	<c:otherwise>全价入园</c:otherwise>
</c:choose>
<hr/>

<c:forEach var="n" begin="1" end="10" step="2">
	${n*10 }<br/>
</c:forEach>

<hr/>

<c:forEach items="${nums }" var="i" >
	${i },
</c:forEach>
<hr/>
<ul>
	<c:forEach items="${list }" var="p">
		<li>${p.id }--${p.name }--${p.desc }</li>
	</c:forEach>
</ul>
<hr/>
<table border="1" width="300">
	<c:forEach items="${list }" var="pp">
		<tr>
			<td>${pp.id }</td>
			<td>${pp.name }</td>
			<td>${pp.desc }</td>
		</tr>
	</c:forEach>
</table>
<hr/>
<c:forTokens items="2019-10-9" delims="-" var="d">
	${d }<br/>
</c:forTokens>

</body>
</html>