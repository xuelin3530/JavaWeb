<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<P>c:set 定义一个变量，并将放入某个容器中(不用)</P>
<c:set var="val" value="test_c" scope="session"></c:set>
${sessionScope.val }
<p>c:out 输出容器中的值(很少)</p>
<c:out value="${val }" default="val不存在"></c:out><br/>
<c:out value="${val2 }" default="val2不存在"></c:out><br/>
${empty val2 ? 'val2不存在~~~~' : val2 }<br/>
<p>c:remove 将某个值从容器中删除掉(很少)</p>
<c:remove var="val" scope="session"/>
${empty val ? 'val不存在~~~~' : val }<br/>
</body>
</html>