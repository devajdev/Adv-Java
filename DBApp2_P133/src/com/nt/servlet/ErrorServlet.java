package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
															throws ServletException, IOException {
		RequestDispatcher rd=null, rd1=null, rd2=null;
		rd1=req.getRequestDispatcher("/headurl");
		rd1.include(req, res);
		
		//general setting
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//display error msg
		pw.println("<h1><center>Internal Problem</center></h1>");
		pw.println("<a href='input.html'>Try Again</a>");
		
		rd2=req.getRequestDispatcher("/footer.html");
		rd2.include(req, res);
		
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}