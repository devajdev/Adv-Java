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
		RequestDispatcher rd=null;
		//general setting
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//display error msg
		pw.println("<h1><center>Internal Problem <br><br> You Entered Wrong Emp Number</center></h1>");
		pw.println("<a href='index.html'>Try Again</a>");
		//close stream
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}