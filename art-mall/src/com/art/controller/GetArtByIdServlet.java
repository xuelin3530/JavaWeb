package com.art.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.art.service.IArtService;
import com.art.service.impl.ArtServiceImpl;

/**
 * Servlet implementation class GetArtByIdServlet
 */
@WebServlet("/GetArtByIdServlet")
public class GetArtByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IArtService ias = new ArtServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetArtByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		
		request.getSession().setAttribute("art", ias.getArtById(Integer.parseInt(id)));
		
	
		
		request.getRequestDispatcher("/admin-update.jsp").forward(request,response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
