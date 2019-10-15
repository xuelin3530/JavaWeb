<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	//数组格式
	var jsonArr = ["Tom","Rose","Mary"];
	//对象格式
	var jsonObj = {"id":1, "name":"Tom", "age":18, "sex":"男"};
	//两个学生对象，数组嵌套对象
	var jsonArr2 = [{"id":101,"name":"小郭","age":20,"sex":"男"},{"id":102,"name":"小杜","age":22,"sex":"男"}];
	//对象嵌套数组
	var jsonObj2 = {"name":"小明","age":25, "girlF":["翠花","小红","小黄"]};
	
/* 	前端要在页面中得到以上类型的对象并解析，然后显示在所想显示的标签中；
	后端要得到一个集合或一个对象，然后转成以上字符串格式传给前端页面。 */
	
</script>
</body>
</html>