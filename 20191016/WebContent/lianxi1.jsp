<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示图书信息</title>
<style>
.bookimg{
	background:url(img/book.jpg) no-repeat 2px center;
	background-size:30px 30px;
	padding-left:30px;
}
tbody tr{
	height:50px;
}

.first{
	display:none;
}
</style>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		"type":"GET",
		"url":"${pageContext.request.contextPath}/servlet/ShowServlet",
		"dataType":"json",
		"success":function(data){ fullTable(data); }
	});
	
	function fullTable(data){
		$("tbody").empty();
		for(var i=0; i<data.length; i++){
			var book =data[i];
			var newtr = $("thead tr:last").clone(true);
			newtr.removeClass("first");
			newtr.children("td").eq(0).html(book["id"]);
			newtr.children("td").eq(1).html(book["bname"]);
			newtr.children("td").eq(1).css("background-image","url(/20191016"+book["cover"]+")");
			newtr.children("td").eq(2).html(book["pname"]);
			newtr.children("td").eq(3).html(book["press"]);
			newtr.children("td").eq(4).html(book["money"]);
			var txt = book["introduction"];
			txt = txt.length>30? txt.substring(0,30)+"...." : txt;
			newtr.children("td").eq(5).html(txt);
			
			$("tbody").append(newtr);
		}
	}
	
});
</script>
</head>
<body>
<table border="1" cellspacing="0">
<thead>
	<tr>
		<th>编号</th>
		<th>书名</th>
		<th>作者</th>
		<th>出版社</th>
		<th>定价</th>
		<th>简介</th>
	</tr>
	<tr class="first">
		<td>111</td>
		<td class="bookimg">匿名书籍</td>
		<td>匿名作者</td>
		<td>匿名出版社</td>
		<td>无定价</td>
		<td>无简介</td>
	</tr>
	</thead>
	<tbody>
	
	</tbody>
	
		
	
</table>

</body>
</html>