<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	session.setAttribute("age", "28");
	session.setAttribute("name", "Tom");
%>
</head>
<body>
${2>3 }<br/>
${3/2 }<br/>
${age+10 }<br/>
${true and false }<br/>
${not true }<br/>
${empty name }---name= ${name }
</body>
</html>