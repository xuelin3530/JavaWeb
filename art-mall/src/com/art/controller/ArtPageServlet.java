package com.art.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.art.pojo.Art;
import com.art.pojo.Page;
import com.art.service.IArtService;
import com.art.service.impl.ArtServiceImpl;

/**
 * Servlet implementation class ArtPageServlet
 */
@WebServlet("/ArtPageServlet")
public class ArtPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IArtService ias = new ArtServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

//		List<Art> list = ias.getAllArts();
//		
//		request.getSession().setAttribute("arts",list);
//		
		
		//当前页码和每页大小
		Page page = new Page();
		
		if(request.getParameter("no")!=null) {
			page.setPageno(Integer.parseInt(request.getParameter("no"))); 
		}
		if(request.getParameter("size")!=null) {
			page.setSize(Integer.parseInt(request.getParameter("size")));
		}
		
		page = ias.getArtsByPage(page.getSize(), page.getPageno());
		
		HttpSession session = request.getSession();
		session.setAttribute("page", page);
		session.setAttribute("size", page.getSize());
		
		request.getRequestDispatcher("/admin-index.jsp").forward(request, response);
		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
