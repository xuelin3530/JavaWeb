<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="style/common.css" />
    <link rel="stylesheet" type="text/css" href="style/index.css" />
</head>
<body>
    <div class="header">
        <div class="logo f1">
            <a href="#"><img src="image/logo.png"></a>
        </div>
        <div class="auth fr">
            <ul>
               
                <li><a href="admin-add.html">添加作品</a></li>
            </ul>
        </div>
    </div>
    <div class="content">
        <div class="banner">
            <img class="banner-img" src="./image/welcome.png" width="732px" height="372" alt="图片描述">
        </div>

        <div class="img-content">
        
            <ul>
           <%--  <c:forEach items="${arts }" var="art"> --%>
            <c:forEach items="${sessionScope.page.list }" var="art">
                <li>
                    <img class="img-li-fix" src="/art-mall${art.art_cover }" alt="${art.art_name }">
                    <div class="info">
                        <h3 class="img_title">${art.art_name }</h3>
                       
                        <p>
                            ${art.art_introduction }
                        </p>
                    <div class="btn">
                   			<a href="/art-mall/GetArtByIdServlet?id=${art.art_id }" class="edit" >编辑</a>
                            <a href="/art-mall/DeleteArtServlet?id=${art.art_id }" class="del">删除</a> 
                        </div>
                    </div>
                </li>
             </c:forEach>
            </ul>
            
        </div>
        
	<div class="page-nav">
            <ul>
                <c:forEach begin="1" end="${sessionScope.page.totalPage }" var = "no">
                	<li><a href="/art-mall/ArtPageServlet?no=${no }">${no }</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>

    <div class="footer">
        <p><span>M-GALLARY</span>©2017 POWERED BY IMOOC.INC</p>
    </div>
</body>
</html>