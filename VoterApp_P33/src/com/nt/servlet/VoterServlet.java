package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class VoterServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		PrintWriter pw=null;
		String name=null;
		String tage=null;
		int age=0;
		//general string
		pw=res.getWriter();
		res.setContentType("text/html");
		//get request parameter values(form data)
		name=req.getParameter("name");
		tage=req.getParameter("age");
		age=Integer.parseInt(tage);
		//write processing processing logic
		if(age>=18){
			pw.println("<h1 style='color:green'>"+name+"  You are eligilble for vote</h1>");
		}
		else{
			pw.println("<h1 style='color:red'>"+name+"  You are not  eligilble for vote</h1>");
		}
		//add hyperlink
		pw.println("<a href='input.html'><img src='james.jpg'></a>");
		//close stream
		pw.close();
	}
}//class
