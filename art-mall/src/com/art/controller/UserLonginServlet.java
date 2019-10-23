package com.art.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.art.service.impl.AdminServiceImpl;
import com.art.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserLonginServlet
 */
@WebServlet("/UserLonginServlet")
public class UserLonginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLonginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String user_name = request.getParameter("user-name");
		String user_password = request.getParameter("user-password");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		UserServiceImpl user = new UserServiceImpl();
		

		switch (user.checkLogin(user_name, user_password)) {
		case 1:
			response.sendRedirect("/art-mall/ArtPageServlet");
			break;
			
		case 2:
			out.print("<h3>用户名密码错误</h3>");
			break;
			
		case 3:
			out.print("<h3>用户不存在</h3>");
			break;

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
