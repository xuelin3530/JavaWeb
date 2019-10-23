package com.question.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.question.service.IQuestionService;
import com.question.service.impl.QuestionServiceImpl;

/**
 * Servlet implementation class GetTypeServlet
 */
@WebServlet("/GetTypeServlet")
public class GetTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private IQuestionService qs = new QuestionServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = JSON.toJSONString(qs.getAllTypes());
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
