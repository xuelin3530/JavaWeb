<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,java.util.ArrayList, com.pojo.Post" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示岗位信息</title>
</head>
<body>
<%
	List<Post> list = (List<Post>)session.getAttribute("ps");
%>

<table border="1" width="300">
	<tr>
		<td>编号</td>
		<td>职位</td>
		<td>描述</td>
	</tr>
	<%
		for(Post p : list){
	%>
		<tr>
			<td><%=p.getId() %></td>
			<td><%=p.getName() %></td>
			<td><%=p.getDesc() %></td>
		</tr>
	<% 		
		}
	%>
</table>

</body>
</html>