package com.art.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.art.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminLonginServlet
 */
@WebServlet("/AdminLonginServlet")
public class AdminLonginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminLonginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String admin_name = request.getParameter("admin-name");
		String admin_password = request.getParameter("admin-password");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		AdminServiceImpl admin = new AdminServiceImpl();
		

		switch (admin.checkLogin(admin_name, admin_password)) {
		case 1:
			response.sendRedirect("/art-mall/ArtPageServlet");
//			request.getRequestDispatcher("/art-mall/admin-index.html").forward(request,response);
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
