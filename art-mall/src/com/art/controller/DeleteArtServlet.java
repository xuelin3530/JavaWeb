package com.art.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.art.pojo.Art;
import com.art.service.IArtService;
import com.art.service.impl.ArtServiceImpl;

/**
 * Servlet implementation class DeleteArtServlet
 */
@WebServlet("/DeleteArtServlet")
public class DeleteArtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IArtService ias = new ArtServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteArtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		
		Art art = new Art();
		
		art.setArt_id(Integer.parseInt(id));
		
		ias.deleteArt(Integer.parseInt(id));
        
        response.sendRedirect("/art-mall/ShowArtsServlet");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
