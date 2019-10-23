package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Employee;
import com.service.EmployeeService;

/**
 * Servlet implementation class FindServlt
 */
@WebServlet("/FindServlt")
public class FindServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeService es = new EmployeeService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindServlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取request数据，调用service方法，将结果保存到容器中，跳转到jsp
		String name = request.getParameter("ename");
		String postname = request.getParameter("pname");
		
		Employee emp = new Employee();
		emp.setName(name);
		emp.getPost().setName(postname);
		
		List<Employee> list = es.getEmpsByNameOrPost(emp);
		
		HttpSession session = request.getSession();
		session.setAttribute("emps", list);
		System.out.println(list.size());
		request.getRequestDispatcher("/WEB-INF/show.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
