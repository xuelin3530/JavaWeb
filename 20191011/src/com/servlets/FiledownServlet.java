package com.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FiledownServlet
 */
@WebServlet("/FiledownServlet")
public class FiledownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiledownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("name");
		String filepath = request.getServletContext().getRealPath("/file");
		File file = new File(filepath, filename);
		InputStream in = new FileInputStream(file);
		
		//设置响应类型为附件下载
		filename = URLEncoder.encode(filename, "utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		
		OutputStream out = response.getOutputStream();
		byte[] buf = new byte[1024];
		int len = -1;
		while((len = in.read(buf))>0) {
			out.write(buf, 0, len);
		}
		 in.close();
		 out.close();
		 System.out.println("下载完毕");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
