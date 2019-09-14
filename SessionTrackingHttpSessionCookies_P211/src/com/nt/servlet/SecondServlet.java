package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String skill=null;
		int exp=0;
		HttpSession ses=null;
	
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form2/req2 data
		skill=req.getParameter("skill");
		exp=Integer.parseInt(req.getParameter("exp"));

		//get Access to HttpSession obj
		ses=req.getSession(false);
		//keep form2/req2 data in Session as session attributes
		ses.setAttribute("skill",skill);
		ses.setAttribute("exp", exp);
		//generate form3 dynamically
		pw.println("<body bgcolor='magenta'>");
		pw.println("<h1 style='color:green;text-align:center'>Provide Preffered Location and Salary </h1>");
		pw.println("<form action='thirdurl' method='POST'>");
		pw.println("<table align=center>");
		pw.println(" preffered City:: <input type='text' name='loc'><br>");
		pw.println(" Expected salary:: <input type='text' name='ctc'><br>");
		pw.println("<input type='submit' value='submit'>");
		pw.println("</table>");
		pw.println("</form>");
		pw.println("<br>SecondServlet:: Session Id::"+ses.getId());
		pw.println("</body>");
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            doGet(req,res);
	}//doPost(-,-)
}//class