package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
public class WishServlet extends HttpServlet {
public void service(HttpServletRequest req, HttpServletResponse res) throws
ServletException, IOException{
	PrintWriter pw=null;
	Calendar calendar=null;
	int hour=0;
	//General Setting
	pw=res.getWriter();
	//set content type
	res.setContentType("text/html");
	//Get stream Date
	calendar =Calendar.getInstance();
	hour=calendar.get(Calendar.HOUR_OF_DAY);
	//generate the wish Msg
	if(hour<=12)
		pw.println("<h1 style='color:red'>Good Morning</center></h1>");
	else if(hour<=17)
		pw.println("<h1 style='color:green'>Good AfterNoon</center></h1>");
	else if(hour<=20)
		pw.println("<h1 style='color:red'>Good Evening</center></h1>");
	else
		pw.println("<h1 style='color:red'>Good Night</center></h1>");
	//generate the hyperlink
	pw.println("<br><a href=page.html>Go Back</a>");
	//close the stream
	pw.close();
}//service(-,-)
}//class