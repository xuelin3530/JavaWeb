<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>请联系管理员</h1>
<%= exception.getMessage() %>
<% exception.printStackTrace(); %>
</body>
</html>