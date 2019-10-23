<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.Random,java.io.File" isErrorPage="true"
   %>
<%@ page import = "java.net.Socket"  %>
<%@page  errorPage="/error.jsp"  %>
    <%--language 语言 
      contentType 、pageEncoding 编码
       import 导包和类--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	Random rad = new Random();
	int num = rad.nextInt(100);
	
	
%>
<%=num/0 %>
</body>
</html>