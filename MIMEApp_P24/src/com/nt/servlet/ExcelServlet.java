package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcelServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
														throws ServletException, IOException {
		//get print writer object
		PrintWriter pw=res.getWriter();
		//set response type
		res.setContentType("application/vnd.ms-excel");
		//write logic to display output
		pw.println("<table border ='1'>");
		pw.println("<tr><th>Player</th><th>Role</th></tr>");
		pw.println("<tr><th>Dhoni</th><th>Captain</th></tr>");
		pw.println("<tr><th>Sachin</th><th>Bastman</th></tr>");
		pw.println("<tr><th>Pandya</th><th>All Rounder</th></tr>");
		pw.println("</table>");
		//close stream object
		pw.close();
	}//close service
}//class close
