package com.lianxi2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet2")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//读取cookie判断是否保存登录名
		String lname = "";
		Cookie[] cks = request.getCookies();
		if(cks!= null && cks.length>0) {
			for(Cookie c : cks) {
				if("lname".equals(c.getName())) {
					lname = URLDecoder.decode(c.getValue(), "utf-8") ;
					break;
				}
			}
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='utf-8'>");
		out.print("</head>");
		out.print("<body>");
		String url = this.getServletContext().getContextPath()+"/LoginServlet";
		out.println("<form action='"+url+"' method='get'>");
		out.print("<p>用户名：<input type='text' name='loginname' value='"+lname+"' /></p>");
		out.print("<p><button>登录</button></p>");
		out.print("</form>");
		out.print("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
