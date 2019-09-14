package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw=null;
		String comp=null;
		int val1=0,val2=0;
		//get printwriter obj
		pw=resp.getWriter();
		//set response content type
		resp.setContentType("text/html");
		//read s1 param value to know the component that is used to send the request
		comp=req.getParameter("s1");
		//write logic
		if(comp.equals("link1")) {
			//sys date
			pw.println("Date & time "+new Date());
		}
		else if(comp.equals("link2")) {
			//sys process
			pw.println("System properties "+System.getProperties());
		}
		else if(comp.equals("add")) {
			//for add button
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.print("Addition : "+(val1+val2));
		}
		else if(comp.equals("sub")) {
			//for sub button
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.print("Subtraction : "+(val1-val2));
		}
		else {
			//for mul button
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.print("Multiplication : "+(val1*val2));
		}
		//add hyperlink
		pw.println("<a href='form.html'>Home</a>");
		}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doGet(req, resp);
	}
	}