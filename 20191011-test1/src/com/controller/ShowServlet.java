package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.User;
import com.service.IUserService;
import com.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService us = new UserServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取type
		String type=request.getParameter("type");
		
		HttpSession session = request.getSession();
		//调用不同Service
		switch(type) {
		case "教学部":
			session.setAttribute("deptName", "教学部");
			List<User> list = us.getUsersByDepa("教学部");
			session.setAttribute("users", list);
			break;
		case "市场部":
			session.setAttribute("deptName", "市场部");
			List<User> list2 = us.getUsersByDepa("市场部");
			session.setAttribute("users", list2);
			break;
		case "就业部":
			session.setAttribute("deptName", "就业部");
			List<User> list3 = us.getUsersByDepa("就业部");
			session.setAttribute("users", list3);
			break;
		}
		request.getRequestDispatcher("/list2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
