<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
	h1{color:red;}
</style>
</head>
<%! int num = 100; %>
<body>
<h1>你好 JSP</h1>
<%
	System.out.print("hello jsp console wirte");
    out.print("<h1>你好 JSP输出</h1>");
%>
<hr/>
<%
String name = (String) session.getAttribute("name");
%>
<H2><% out.print(name); %> <%=name %></H2>
<hr/>
<%
out.print(request.getParameter("age"));
%>
<%=request.getParameter("age") %>
<hr/>
num = <% out.print(num); %><br/>
num = <%=num/0 %>
</body>
<script type="text/javascript">
	alert("hello JSP");
</script>
</html>
<!-- html注释 --><%--jsp注释--%> 