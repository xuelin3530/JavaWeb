package com.phone1000.system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.phone1000.system.pojo.Page;
import com.phone1000.system.service.IUserService;
import com.phone1000.system.service.impl.UserServiceImpl;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private IUserService us = new UserServiceImpl();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//请求类型是ajax是还普通请求
		String reqtype = request.getParameter("type");
		//当前页码和每页大小
		
		Page page = new Page();
		if(request.getParameter("no")!=null) {
			page.setPageno(Integer.parseInt(request.getParameter("no"))); 
		}
		if(request.getParameter("size")!=null) {
			page.setSize(Integer.parseInt(request.getParameter("size")));
		}
		
		 page = us.getUsersByPage(page.getSize(), page.getPageno());
		if("ajax".equals(reqtype)) {
			String str = JSON.toJSONString(page);
			response.getWriter().print(str);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("page", page);
			session.setAttribute("size", page.getSize());
			request.getRequestDispatcher("/page.jsp").forward(request, response);
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
