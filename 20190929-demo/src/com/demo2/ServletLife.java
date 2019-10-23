package com.demo2;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletLife implements Servlet {
	
	public ServletLife() {
		System.out.println("Servlet对象被Tomcat容器创建成功********");
	}
	

	@Override
	public void destroy() {
		System.out.println("Servlet对象已被销毁~~~~~");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet对象完成初始化工作");
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet对象正在为您工作");
		
	}

}
