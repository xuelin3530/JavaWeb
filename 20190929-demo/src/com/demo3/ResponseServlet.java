package com.demo3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> list = new ArrayList<String>();
		list.add("小郭");
		list.add("小金");
		list.add("小王");
		list.add("小张");
		list.add("小杨");
		//响应客户端<h1>以下内容通过Servlet输入</h1>
		// HttpServletResponse 响应类型 resp响应对象
		//设置响应的编码方式
		resp.setContentType("text/html;charset=utf-8");
		//获取打印流
		PrintWriter out = resp.getWriter();
		//响应内容
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='utf-8'>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>Hello World</h1>");
		out.print("<h1>以下内容通过Servlet输入</h1>");
		out.print("<table border='1' width='200'>");
		out.print("<tr>");
		out.print("<td>序号</td>");
		out.print("<td>姓名</td>");
		out.print("</tr>");
		for(int i=0; i < list.size(); i++) {
			out.print("<tr>");
			out.print("<td>"+(i+1)+"</td>");
			out.print("<td>"+list.get(i)+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
		
	}
}
