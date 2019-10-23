<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>详情</title>
    <link rel="stylesheet" type="text/css" href="style/common.css" />
    <link rel="stylesheet" type="text/css" href="style/detail.css" />
<!--<link rel="stylesheet" type="text/css" href="style/reset.css" />
    <link rel="stylesheet" type="text/css" href="style/style.css" />-->
</head>
<body class="bgf8">
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
        <div class="section" style="margin-top:20px;">
            <div class="width1200">
                <div class="fl"><img src="/art-mall${sessionScope.art.art_cover }"/></div>
                <div class="fl sec_intru_bg">
                    <dl>
                        <dt>${sessionScope.art.art_name }</dt>
                        <dd>
                            <p>发布人：<span>admin</span></p>
                            <p>发布时间：<span>2017年2月16日</span></p>
                            <p>修改时间：<span>2017年2月17日</span></p>
                            <p>浏览次数：<span>33221</span></p>
                        </dd>
                    </dl>
                    <ul>
                        <li>售价：<br/><span class="price">${sessionScope.art.art_price }</span>元</li>
                        <li class="btn"><a href="javascript:;" class="btn btn-bg-red" style="margin-left:38px;">立即购买</a></li>
                        <li class="btn"><a href="javascript:;" class="btn btn-sm-white" style="margin-left:8px;">收藏</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="secion_words">
            <div class="width1200">
                <div class="secion_wordsCon">
                        <p>${sessionScope.art.art_detail }</p>
                            </div>
                    </div>
                </div>
            </div>
            <div class="footer">
                <p><span>M-GALLARY</span>©2017 POWERED BY IMOOC.INC</p>
            </div>
        </div> 
    </body>
    </html>
