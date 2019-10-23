package com.demo3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequstServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//请求中的参数值
		String name = req.getParameter("uname");
		String pwd = req.getParameter("upwd");
		System.out.println(name+"\t"+pwd);
				
		String sex = req.getParameter("sex");
		System.out.println(sex);
		//请求中的重名参数值
		String[] hbs = req.getParameterValues("hobby");
		for(String b : hbs) {
			System.out.print(b+"\t");
		}
		System.out.println();
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='utf-8'>");
		out.print("</head>");
		out.print("<body>");

		if(name.equals("admin") && pwd.equals("123456")) {
			out.print("登录成功");
		}else {
			out.print("登录失败");
		}
		out.print("</body>");
		out.print("</html>");
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决post请求中的中文乱码
		req.setCharacterEncoding("utf-8");
		//请求中的参数值
		String name = req.getParameter("uname");
		String pwd = req.getParameter("upwd");
		System.out.println(name+"\t"+pwd);
		
		String sex = req.getParameter("sex");
		System.out.println(sex);
		//请求中的重名参数值
		String[] hbs = req.getParameterValues("hobby");
		for(String b : hbs) {
			System.out.print(b+"\t");
		}
		System.out.println();
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='utf-8'>");
		out.print("</head>");
		out.print("<body>");

		if(name.equals("admin") && pwd.equals("123456")) {
			out.print("登录成功");
		}else {
			out.print("登录失败");
		}
		out.print("</body>");
		out.print("</html>");

	}
}
