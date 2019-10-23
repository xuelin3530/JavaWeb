package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Emp;
import com.service.EmpService;

/**
 * Servlet implementation class FindEmpServlet
 */
@WebServlet("/FindEmpServlet2")
public class FindEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmpService es = new    EmpService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ename = request.getParameter("ename");
		List<Emp> list = es.getEmpsByName(ename);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='utf-8'>");
		out.print("</head>");
		out.println("<body>");
		if(list.size()>0) {
			
			out.print("<table border='1' width='800'>");
			out.print("<tr>");
			out.print("<th>编号</th><th>姓名</th><th>工作</th><th>入职时间</th><th>领导编号</th>"
					+ "<th>工资</th><th>奖金</th><th>部门编号</th>");
			for(Emp e : list) {
				out.print("<tr>");
				out.print("<th>"+e.getEmpno()+"</th><th>"+e.getEname()+"</th><th>"+e.getJob()+"</th>"
						+ "<th>"+e.getHiredate()+"</th><th>"+e.getMgr()+"</th>"
						+ "<th>"+e.getSal()+"</th><th>"+e.getComm()+"</th><th>"+e.getDeptno()+"</th>");
				out.print("</tr>");
			}
			out.print("</tr>");
			out.print("</table>");
			
		}else {
			out.print("<h3>无符合条件的员工信息</h3>");
		}
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
