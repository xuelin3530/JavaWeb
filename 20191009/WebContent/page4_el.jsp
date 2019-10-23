<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.pojo.Post" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	session.setAttribute("name", "Tom");
	session.setAttribute("age", 19);
	Post post = new Post(1,"行政助理","行政辅助人员");
	session.setAttribute("p", post);
	
	request.setAttribute("req", "请求数据");
	application.setAttribute("context", "全局数据");
	pageContext.setAttribute("page", "页面数据");
	
	pageContext.setAttribute("data", "page-data");
	request.setAttribute("data", "request-data");
	session.setAttribute("data", "session-data");
	application.setAttribute("data", "application-data");
	
%>
<body> 
${2+3 }<br/>
name= ${name }<br/>
age = ${age }<br/>
post.name = ${p.name }---post.desc = ${p.desc }<br/>
${req }<br/>
${context }<br/>
${page }<br/>
<hr/>
el表达式读取容器中内容的顺序，pageContext,requst,session,application保存名字为"data"，如果获取？
<p>如果不指定容器范围，则查找的顺序pageContext,request,session,application,如果所有容器中都没有则返回null,输出""</p>
<p>${data }</p>
<p>如果要获取指定容器中的数据{ xxxScope.name }</p>
requestScope.data = ${requestScope.data }<br/>
sessionScope.data = ${sessionScope.data }<br/>
applicationScope.data = ${applicationScope.data }

</body>
</html>