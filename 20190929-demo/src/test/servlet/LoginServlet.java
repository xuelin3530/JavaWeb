package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.UserDao;
import test.pojo.User;
import test.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String lname = request.getParameter("loginname");
		String lpwd = request.getParameter("loginpwd");
		
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		UserService us = new UserService();
		if(us.checkLogin(lname, lpwd)) {
			out.print("<h3>欢迎"+lname+"</h3>");
			out.print("<ol>");
			for(User u : us.getAllUsers()) {
				out.print("<li>"+u.getUsername()+"--"+u.getPassword()+"</li>");
			}
			out.print("</ol>");
		}else {
			out.print("<h3>登录失败</h3>");
		}
		
		
//		UserDao ud = new UserDao();
//		User user = ud.getUserByName(lname);
//		if(user!=null) {
//			if(user.getUsername().equals(lname) && user.getPassword().equals(lpwd)) {
//				out.print("<h3>欢迎"+user.getUsername()+"</h3>");
//			}else {
//				out.print("<h3>用户名或密码错误</h3>");
//			}
//		}else {
//			out.print("<h3>用户名不存在</h3>");
//		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
