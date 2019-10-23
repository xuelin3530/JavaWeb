package com.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.question.pojo.Page;
import com.question.service.IQuestionService;
import com.question.service.impl.QuestionServiceImpl;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private IQuestionService qs = new   QuestionServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageno=0, size=0, typeid=0, level=0;
		String strid = request.getParameter("typeid");
		if(strid!=null) {
			typeid = Integer.parseInt(strid);
		}
		String strlevel = request.getParameter("level");
		if(strlevel!=null) {
			level = Integer.parseInt(strlevel);
		}
		String strno = request.getParameter("no");
		if(strno!=null) {
			pageno = Integer.parseInt(strno);
		}
		String strsize = request.getParameter("size");
		if(strsize!=null) {
			size = Integer.parseInt(strsize);
		}
		
		Page page = qs.getQuestionByCondition(typeid, level, pageno, size);
		//String str = JSON.toJSONString(page);
		String str = new Gson().toJson(page);
		response.getWriter().print(str);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
