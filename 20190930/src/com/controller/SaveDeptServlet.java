package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Dept;
import com.service.DeptService;

/**
 * Servlet implementation class SaveDeptServlet
 */
@WebServlet("/SaveDeptServlet")
public class SaveDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DeptService ds = new DeptService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno =Integer.parseInt( request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		Dept dept = new Dept(deptno, dname, loc);
		boolean rs = ds.saveDept(dept);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='utf-8'>");
		out.print("</head>");
		out.println("<body>");

		if(rs) {
			out.print("<h2>部门信息保存成功</h2>");
		}else {
			out.print("<h2>部门信息保存失败</h2>");
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
