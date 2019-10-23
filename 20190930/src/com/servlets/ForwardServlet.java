package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * req.getRequestDispatcher(url).forward(req, resp);
		 * 服务器url  /资源
		 * 地址栏不会显示url
		 * 请求1次 响应1次
		 * */
		
		req.getRequestDispatcher("/test.html").forward(req, resp);
	}
}
