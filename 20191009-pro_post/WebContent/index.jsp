<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查找页面</title>
<style>
	.tr1{
		font-size:30px;
		color:#fff;
		background:brown;
		text-align: center;
		height:80px;
	}
	.tr2 td{
		background:yellow;
		height:30px;
		font-weight: blod;
		padding-left:5px;
	}
</style>
</head>
<body>

<form action="<%=application.getContextPath() %>/FindServlt" method="get">
<table border="0" width="600" align="center">
<tr class="tr1">
		<td colspan="2">雇员查询系统</td>
	</tr>
	<tr class="tr2">
		<td>员工姓名：</td>
		<td><input type="text" name = "ename"/></td>
	</tr>
	<tr  class="tr2">
		<td>职位：</td>
		<td><select name="pname">
<option value=''>请选择</option>
<option value='行政助理'>行政助理</option>
<option value='行政主管'>行政主管</option>
<option value='业务经理'>业务经理</option>
<option value='总经理'>总经理</option>
</select></td>
	</tr>
	<tr>
		<td colspan="2"><button>查询雇员明细</button></td>
	</tr>
</table>
</form>
</body>
</html>