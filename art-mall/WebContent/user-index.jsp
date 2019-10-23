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
            <img src="image/logo.png">
        </div>
        <div class="auth fr">
            <ul>
                <li><a href="#">登录</a></li>
                <li><a href="#">注册</a></li>
            </ul>
        </div>
    </div>
    <div class="content">
        <div class="banner">
            <img class="banner-img" src="./image/welcome.png" width="732px" height="372" alt="图片描述">
        </div>

        <div class="img-content">
            <ul>
            
            <c:forEach items="${arts }" var="art">
                <li>
                    <img class="img-li-fix" src="/art-mall${art.art_cover }" alt="${art.art_name }">
                    <div class="info">
                        <h3 class="img_title">${art.art_name }</h3>
                       
                        <p>
                            ${art.art_introduction }
                        </p>
                    <div class="btn">
                            <a href="/art-mall/ShowArtDetailServlet?id=${art.art_id }" class="edit">详细信息</a>
                            
                        </div>
                    </div>
                </li>
			</c:forEach>
			
                
            </ul>
        </div>
        <div class="page-nav">
            <ul>
                <li><a href="#">首页</a></li>
                <li><a href="#">上一页</a></li>
                <li><span class="first-page">1</span></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>...</li>
                <li><a href="#">98</a></li>
                <li><a href="#">99</a></li>
                <li><a href="#">下一页</a></li>
                <li><a href="#">尾页</a></li>
            </ul>
        </div>
    </div>

    <div class="footer">
        <p><span>M-GALLARY</span>©2017 POWERED BY IMOOC.INC</p>
    </div>
</body>
</html>