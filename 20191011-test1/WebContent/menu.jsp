<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>用户菜单</h1>
<p><a href="${pageContext.request.contextPath }/ShowServlet?type=教学部" target="right">教学部</a></p>
<p><a href="${pageContext.request.contextPath }/ShowServlet?type=市场部" target="right">市场部</a></p>
<p><a href="${pageContext.request.contextPath }/ShowServlet?type=就业部" target="right">就业部</a></p>
</body>
</html>