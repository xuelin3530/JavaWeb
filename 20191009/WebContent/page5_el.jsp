<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.pojo.Post, java.util.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
Post post = new Post(1,"行政助理","行政辅助人员");
session.setAttribute("p", post);

	String[] names = {"张三","李四","王五"};
	session.setAttribute("arr", names);
	
	List<Integer> list = new ArrayList<Integer>();
	list.add(10);
	list.add(20);
	list.add(30);
	list.add(40);
	session.setAttribute("nums", list);
	
	Map<String, Integer> map = new HashMap<String, Integer>();
	map.put("a", 100);
	map.put("b", 200);
	map.put("c", 300);
	
	session.setAttribute("mm", map);
	
	List<Post> ps = new ArrayList<Post>();
	ps.add(new Post(11,"总裁秘书","总裁助理"));
	ps.add(new Post(22,"总裁","公司负责人"));
	ps.add(new Post(33,"秘书助理","打杂"));
	
	session.setAttribute("list", ps);
	
	Post post2 = new Post(100,"前台","接待来访");
	Map<String, Post> map2 = new HashMap<String, Post>();
	map2.put("post1", post2);
	session.setAttribute("m2", map2);
	
	
	Map<String, List> map3 = new HashMap<String, List>();
	map3.put("list", ps);
	session.setAttribute("m3", map3);
	
%>
<body>
${sessionScope.m3.list[1].name }
<hr/>

输出容器中对象的属性值{scope.name.attributeName }<br/>
${sessionScope.p.id }---${p.name }--${p.desc }
<hr/>
输出容器中数组某个元素{scope.name[index]}<br/>
${sessionScope.arr[1] }---${arr[2] }
<hr/>
输出容器中list集合中某个元素{scope.name[index] }<br/>
${sessionScope.nums[2] }--${nums[0] }
<hr/>
输出容器中map集合中某个元素{scope.name.key}--{scope.name["key"]}<br/>
${sessionScope.mm.b }---${mm["b"] }<br/>
<hr/>
${sessionScope.list[0].name } -- ${list[1].desc } -- ${list[1]["desc"] }<br/>
${sessionScope.m2.post1.id }--${m2["post1"].name } -- ${m2["post1"]["desc"] }
<hr/>


</body>
</html>