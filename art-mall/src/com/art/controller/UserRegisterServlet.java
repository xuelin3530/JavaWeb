package com.art.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.art.pojo.User;
import com.art.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
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
		
		User user = new User();
		
		user.setUser_name(user_name);
		user.setUser_password(user_password);
		
		PrintWriter out = response.getWriter();
		
		UserServiceImpl usi = new UserServiceImpl();
		
		boolean cnt = usi.addUser(user);
		if (cnt) {
//			request.getRequestDispatcher("/art-mall/user-index.html").forward(request, response);
			response.sendRedirect("/art-mall/user-login.html");
		}else {
			out.print("注册失败");
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
