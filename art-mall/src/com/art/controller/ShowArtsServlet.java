package com.art.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.art.pojo.Art;
import com.art.service.IArtService;
import com.art.service.impl.ArtServiceImpl;

/**
 * Servlet implementation class ShowArtsServlet
 */
@WebServlet("/ShowArtsServlet")
public class ShowArtsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IArtService ias = new ArtServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowArtsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Art> list = ias.getAllArts();
		
		request.getSession().setAttribute("arts",list);
		String root = this.getServletContext().getContextPath();
		response.sendRedirect(root+"/admin-index.jsp");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
