package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.pojo.User;
import com.service.IUserService;
import com.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DeletServlet2
 */
@WebServlet("/DeletServlet2")
public class DeletServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService us = new UserServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ids");
		String[] ids = id.split(",");
		for(String i : ids) {
			us.deleteUser(Integer.parseInt(i));
		}
		String depa = (String)request.getSession().getAttribute("deptName");
		List<User> list = us.getUsersByDepa(depa);
		response.setContentType("text/html;charset=utf-8");
		String str = JSON.toJSONString(list);
		response.getWriter().print(str);
	}

}
