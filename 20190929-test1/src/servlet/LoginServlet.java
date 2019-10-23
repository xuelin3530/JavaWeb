package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import pojo.User;
import service.UserService;

/**
 * Servlet implementation class LoginServlet
 * 
 * Servlet接受一个请求以后，调用Dao类的操作，然后判断登录是否成功
 * 
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
	 * 从请求中获取用户名和密码
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		①考虑中文乱码问题，设置中文编码
		request.setCharacterEncoding("utf-8");
//		②此处先写servlet后写页面，起名
		String lname = request.getParameter("loginname");
		String lpwd = request.getParameter("loginpwd");
		
		
//		设置响应编码
		response.setContentType("text/html;charset=utf-8");
//		打印流
		PrintWriter out = response.getWriter();
//		⑤增加service后新增代码段
		UserService us = new UserService();
//		checkLogin返回ture则登录成功
		if(us.checkLogin(lname, lpwd)) {
			
			out.print("<h3>欢迎"+lname+"</h3>");
			out.print("<ol>");
//			遍历
			for(User u : us.getAllUsers()) {
				out.print("<li>"+u.getUsername()+"--"+u.getPassword()+"</li>");
			}
			out.print("</ol>");
			
		}else {
			out.print("<h3>登录失败</h3>");
		}
//		注释代码为servlet直接调用Dao
//		③调用UserDao方法
//		UserDao ud = new UserDao();
//		User user = ud.getUserByName(lname);
		
//		④获取User中的密码和当前密码对比
		
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
