<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><a href="${pageContext.request.contextPath }/FiledownServlet?name=my.java">my.java下载</a></p>
<p><a href="${pageContext.request.contextPath }/FiledownServlet?name=a.docx">a.docx下载</a></p>
<p><a href="${pageContext.request.contextPath }/FiledownServlet?name=海蜇.jpg">海蜇图片下载</a></p>
</body>
</html>