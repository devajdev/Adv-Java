package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CheckInputFilter implements Filter {
	
	public CheckInputFilter() {
		System.out.println("CheckInputFilter.CheckInputFilter()");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("CheckInputFilter.init()");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CheckInputFilter.doFilter()");
		//general setting
		PrintWriter pw=null;
		int v1=0;
		int v2=0;
		pw=res.getWriter();
		res.setContentType("text/html");
		v1=Integer.parseInt(req.getParameter("t1"));
		v2=Integer.parseInt(req.getParameter("t2"));
		if(v1<0||v2<0) {
		//display the message
		pw.println("<h1 style='color:red;text-align:center'>Please enter only Positive Number...</h1>");
		//hyperlink
		pw.println("<a href='page.html'>Try Again</a>");
		}
		else {
			chain.doFilter(req, res);
		}
		//close stream
		pw.close();
	}
	@Override
	public void destroy() {
		System.out.println("CheckInputFilter.destroy()");
	}

}
