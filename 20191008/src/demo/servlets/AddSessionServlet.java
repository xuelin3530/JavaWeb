package demo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddSessionServlet")
public class AddSessionServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session对象
		HttpSession  session = request.getSession();
		//session保存数据
		session.setAttribute("name", "汤姆");
		User u = new User(1,"Tom","123456","男",18);
		session.setAttribute("user", u);
		
		//发呆时间
		session.setMaxInactiveInterval(100);
		
		System.out.println("session save data ok");
		response.getWriter().print(session.getId());
	}

}
