package qfedu.lianxi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Emp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='utf-8'>");
		out.print("</head>");
		out.println("<body>");
		//判断request是否有error参数
		if(request.getParameter("error")!=null) {
			String err = request.getParameter("error");
			if("1".equals(err)) {
				out.print("<p style='color:red'>用户名不存在</p>");
			}else if("2".equals(err)) {
				out.print("<p style='color:red'>用户名或密码错误</p>");
			}
		}
		
		out.println("<form action='/20190930/CheckLoginServlet' method='post'>");
		out.println("用户名：<input type='text' name='username' /><br/><br/>");
		out.println("密码：<input type='text' name='password' /><br/><br/>");
		out.print("<button>登   录</button>");
		out.println("</form>");
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
