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
		
		PrintWriter pw=null;
		String name=null;
		//int age=0;
		String ms=null;
		String f1val=null;
		String f2val=null;
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		name=req.getParameter("pname");
		String age=req.getParameter("page");
		//int age1=Integer.parseInt("age");
		ms=req.getParameter("ms");
		f1val=req.getParameter("f1val");
		f2val=req.getParameter("f2val");
		pw.println(name+".."+age+".."+ms+".."+f1val+".."+f2val);
		
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
