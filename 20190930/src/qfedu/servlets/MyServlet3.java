package qfedu.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="my3", urlPatterns= {"/my3","/myservlt3"}, loadOnStartup=1)
public class MyServlet3 extends HttpServlet {
	public MyServlet3() {
		System.out.println("MyServlet3 create");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("<h1>Servlet3.0 output</h1>");
	}

}
