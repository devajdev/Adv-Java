package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int val=0;
		int square=0;
		//general setting
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		val=Integer.parseInt(req.getParameter("t1"));
		square=val*val;
		pw.println("<h1 style='color:red'>First Servlet  Square Result:: "+square+"</h1>");
		//get servlet context of current web application
		ServletContext sc1=getServletContext();
		//get servlet context for another web app
		ServletContext sc2=sc1.getContext("/WASecApp_P140");
		//get req dispatcher
		RequestDispatcher rd=sc2.getRequestDispatcher("/s2url");
		rd.include(req, res);
		//close stream
		pw.close();
		
	}//doGet(-,-)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
