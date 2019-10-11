package com.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet({ "/Servlet1", "/MyServlet1" })
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc1 = request.getServletContext();
		ServletContext sc2 = this.getServletContext();
		System.out.println(sc1 == sc2);
		System.out.println("servlet1's context:"+sc1);
		
		String realPath = sc1.getRealPath("/image");
		String rootPath = sc1.getContextPath();
		System.out.println("realPath:"+realPath);
		System.out.println("rootPath:"+rootPath);
		
		sc1.setAttribute("className", "J1903");
		System.out.println("���ݱ���ɹ�");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
