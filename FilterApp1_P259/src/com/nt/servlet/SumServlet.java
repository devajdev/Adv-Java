package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SumServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		//general setting
		PrintWriter pw=null;
		int v1=0;
		int v2=0;
		int sum=0;		
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		v1=Integer.parseInt(req.getParameter("t1"));
		v2=Integer.parseInt(req.getParameter("t2"));
		sum=v1+v2;
		//display the result
		pw.println("<h1 style='color:red;text-align:center'>Sum is :: "+sum+"</h1>");
		//close stram
		pw.println("<a href='page.html'>Try Again</a>");
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}