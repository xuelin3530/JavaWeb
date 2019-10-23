<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<frameset cols="20%, *">
	<frame src="menu.jsp"  name="left"/>
	<frame src="${pageContext.request.contextPath }/ShowServlet?type=教学部"  name="right"/>
</frameset>
<body>

</body>
</html>