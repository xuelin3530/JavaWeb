package com.library.system.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import com.library.system.dao.impl.UserDaoImpl;
import com.library.system.pojo.User;
import com.library.system.service.impl.UserServiceImpl;


@WebServlet("/LoginAction")

public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    UserServiceImpl us = new UserServiceImpl();


    public LoginAction() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname = request.getParameter("username");
		String upassword = request.getParameter("password");
		
		User us1 = new User(); 
		
		us1.setUsername(uname);
		us1.setPassword(upassword);
		
		String us2 = us.login(us1);
		
		if (us2.equals("true")) {
			HttpSession session = request.getSession();
		    session.setAttribute("adminname", uname);
		}
		
		response.getWriter().print(us2);
        
		
	}

}
