package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FormServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{
	String name=null,gender=null,ms=null,addrs=null,qlfy=null,crs[]=null,hb[]=null;
	int age=0;
	PrintWriter pw=null;
	//get PrintWriter object
	pw=response.getWriter();
	//set response content type
	response.setContentType("text/html");
	//read from data
	name =request.getParameter("tname");
	age=Integer.parseInt(request.getParameter("tage"));
	gender=request.getParameter("gen");
	ms=request.getParameter("ms");
	addrs=request.getParameter("taddress");
	qlfy=request.getParameter("qlfy");
	crs=request.getParameterValues("crs");
	hb=request.getParameterValues("hb");
	
	//write request processing logic
	if(gender.equalsIgnoreCase("M"))
	{
		if(age<=5) 
			pw.println(name+" You are baby boy");
		else if(age<=12) 
			pw.println(name+" You are smolll boy");
				else if(age<=19) 
					pw.println(name+" You are teenage boy");
				else if(age<=35) 
					pw.println(name+" You are young man ");
				else if(age<=50) 
					pw.println(name+" You are middle aged man");
				else pw.println(name+" You are Budda");
	}//if close
	
	else if(gender.equalsIgnoreCase("F"))
	{
		if(age<=5)
			pw.println(name+" You are baby girl");
			else if(age<=12)
			pw.println(name+" You are small girl");
				else if(age<=19)
					pw.println(name+" You are teenage girl");
				else if(age<=35)
					pw.println(name+" You are young woman");
				else if(age<=50)
					pw.println(name+" You are middle aged woman");
				else pw.println(name+" You are old women");
	}//else if close
	
	pw.println("<br>Name = "+name);
	pw.println("<br>Age = "+age);
	pw.println("<br>Gender = "+gender);
	pw.println("<br>Marital Status = "+ms);
	pw.println("<br>Address = "+addrs);
	pw.println("<br>Qualification = "+qlfy);
	pw.println("<br>Course = "+Arrays.toString(crs));
	pw.println("<br>Hobbies = "+Arrays.toString(hb));
	}//doGet(-,-)
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
				doPost(req,res);
	}
}