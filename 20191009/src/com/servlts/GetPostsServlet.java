package com.servlts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Post;

/**
 * Servlet implementation class GetPostsServlet
 */
@WebServlet("/GetPostsServlet")
public class GetPostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPostsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Post> list = new ArrayList<Post>();
		list.add(new Post(1,"行政助理","行政辅助人员"));
		list.add(new Post(2,"行政主管","行政负责人"));
		list.add(new Post(3,"业务经理","业务负责人"));
		list.add(new Post(4,"业务代理","业务人员"));
		list.add(new Post(5,"总经理","公司负责人"));
		
		HttpSession session = request.getSession();
		session.setAttribute("ps", list);
		
		response.sendRedirect("/20191009/showPost.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
