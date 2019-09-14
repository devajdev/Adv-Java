package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int cube=0;
		//general setting
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		int val=Integer.parseInt(req.getParameter("t1"));
		cube=val*val*val;
		//display cube
		pw.println("<h1 style='color:blue'> Second Servlet Cube Result:: "+cube+"</h1>");
		//dont close stream
		pw.println("<h3><a href='index.html'>Find Another number</a></h3>");
	}//doGet
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
