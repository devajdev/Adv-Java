package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		String name=null;
		int age=0;
		String ms;
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		name=req.getParameter("pname");
		age=Integer.parseInt(req.getParameter("page"));
		ms=req.getParameter("ms");
		if(ms==null) {
			ms="single";
		}
		//forward the first form data value
		if(ms.equals("married")) {
			pw.println("<form action='s2url' method='POST'>");
			pw.println("<b>Spouse Name::</b><input type='hidden' name='f1val'><br>");
			pw.println("<b>Number of Children::</b><input type='hidden' name='f2val'><br>");
			pw.println("<b>Marrital Status::</b><input type='hidden' name='f3val'><br>");
			pw.println("<input type='submit' value='Submit'>");
			pw.println("</form>");
		}
		else {
			pw.println("<form action='s2url' method='POST'>");
			pw.println("<b>When You Want marry::</b><input type='hidden' name='f1val'><br>");
			pw.println("<b>Why are you marry::</b><input type='hidden' name='f2val'><br>");
			pw.println("<b>Marrital::</b><input type='hidden' name='f3val'><br>");
			pw.println("<input type='submit' value='Submit'>");
			pw.println("</form>");
		}
		pw.close();
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doGet(req,res);
}
}
