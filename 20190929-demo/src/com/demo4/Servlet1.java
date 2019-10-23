package com.demo4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='utf-8'>");
		out.print("</head>");
		out.print("<body>");
		
		out.print("<form action='/0928/servlet2' method='post'>");
		out.print("”√ªß√˚£∫<input type='text' name='username' /><br/>");
		out.print("√‹¬Î£∫<input type='password' name='password' /><br/>");
		out.print("<input type='submit' value='µ«   ¬º' /><br/>");
		out.print("</form>");
		
		out.print("</body>");
		out.print("</html>");

	}
}
