<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/FileUpServlet" method="post" enctype="multipart/form-data">
	书名：<input type="text" name="bname" /><br/>
	
	请选择文件：<input type="file" name="file" /><br/>
	请选择文件：<input type="file" name="file" />
	<button>上传</button>
</form>
</body>
</html>