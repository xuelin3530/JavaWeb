package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendRedirect")
public class SendRedirectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//重定向到test.hmtl
		/*
		 * resp.sendRedirect(url)
		 * 客户端url  /项目名/资源 
		 * 在地址栏会显示url
		 * 请求2次 响应2次
		 * */
		resp.sendRedirect("/20190930/test.html");
	}
}
