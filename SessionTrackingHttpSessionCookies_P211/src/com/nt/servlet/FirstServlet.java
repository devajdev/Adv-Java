package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addr=null;
		int age=0;
		HttpSession ses=null;
		
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form1/req1 data
		name=req.getParameter("name");
		addr=req.getParameter("addr");
		age=Integer.parseInt(req.getParameter("age"));
		
		//create HttpSession object
		ses=req.getSession(true);
		//add form1/req1 data to Session attributes
		ses.setAttribute("name", name);
		ses.setAttribute("age", age);
		ses.setAttribute("addr", addr);
		//ses.setMaxInactiveInterval(60);
		//Generate form2 dynamically
		pw.println("<body bgcolor='pink'>");
		pw.println("<table Align=center>");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<h1 style='color:red'><center>Provide SkillSet & Experience</center></h1>");
		pw.println("<form action='secondurl' method='POST'>");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println(" Experince :: <input type='text' name='exp'><br>");
		pw.println("</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>");
		pw.print(" Skillset :: <select name='skill'>");
		pw.print("<option value=Java>JAVA/J2EE</option>");
		pw.print("<option value=.Net>.Net</option>");
		pw.print("<option value=Oracle>Oracle</option>");
		pw.println("</select>");
		pw.println("</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<input type='submit' value='continue'>");
		pw.println("</td>");
		pw.println("</tr>");
		pw.println("</table>");
		pw.println("</form>");
		pw.println("<br>FirstServlet:: Session Id::"+ses.getId());
		pw.println("</body>");
		// close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
             doGet(req,res);
	}//doPost(-,-)

}
