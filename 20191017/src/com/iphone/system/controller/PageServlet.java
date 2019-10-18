package com.iphone.system.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.iphone.system.pojo.Page;
import com.iphone.system.service.IUserService;
import com.iphone.system.service.impl.UserServiceImpl;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService us = new UserServiceImpl();
    /**
     * Default constructor. 
     */
    public PageServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//请求类型是ajax还是普通请求
		String reqtype = request.getParameter("type");
		//当前页码和煤业大小
		int no = 1, size = 10;
		if(request.getParameter("no")!=null) {
			no=Integer.parseInt(request.getParameter("no"));
		}
		if(request.getParameter("size")!=null) {
			size= Integer.parseInt(request.getParameter("size"));
		}
		Page page = us.getUserByPage(size,no);
		
		if("ajax".equals(reqtype)) {
			String str = JSON.toJSONString(page);
			response.getWriter().print(str);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("page", page);
			request.getRequestDispatcher("/show.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
