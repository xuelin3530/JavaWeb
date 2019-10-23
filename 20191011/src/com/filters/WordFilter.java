package com.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class WordFilter
 */
//@WebFilter("/servlets/MyServlet")
@WebFilter(servletNames = { "aaa" })
public class WordFilter implements Filter {

	private static List<String> words = new ArrayList<String>();
    public WordFilter() {
        words.add("习近平");
        words.add("sb");
        words.add("xxx");
    }

    @Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		MyRequest req = new MyRequest((HttpServletRequest)request);
		req.setList(words);
		chain.doFilter(req, response);//放行
	}

	@Override
	public void destroy() {
	}
}

class MyRequest extends HttpServletRequestWrapper{
	private List<String> list;
	public MyRequest(HttpServletRequest request) {
		super(request);
	}

	
	public void setList(List<String> list) {
		this.list = list;
	}


	@Override
	public String getParameter(String name) {
		String str = super.getParameter(name);
		for(String s : list) {
			if(str.contains(s)) {
				str = str.replaceAll(s, "*");
			}
		}
		return str;
	}

}
