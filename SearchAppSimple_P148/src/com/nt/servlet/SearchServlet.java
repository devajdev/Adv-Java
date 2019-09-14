package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
												throws ServletException, IOException {
		//general setting
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String ss=req.getParameter("ss");
		pw.println("<a href='https://www.google.co.in/search?q="+ss+"'>Go to</a>");
		
		pw.close();
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
}
