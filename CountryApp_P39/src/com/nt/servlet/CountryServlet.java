package com.nt.servlet;
import java.io.*;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet{

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String  statesIndia[]={"AP", "TS", "MH","MP", "UP"};
		 String UsStates[]= {"CA", "LA", "NY", "CR", "AZ"};
		 String ausisStates[]= {"TMS", "BB", "CBR"};
		 String country=null;
		 //read form data
 		 country=req.getParameter("country");
		 //general settings
		 PrintWriter pw=res.getWriter();
		 res.setContentType("text/html");
		 //get states based on the country that is selected.
		 if(country.equals("India")) {
		 pw.println("states="+Arrays.toString(statesIndia));
		 }
		 else if(country.equals("us")) {
		 pw.println("states="+Arrays.toString(UsStates));
		 }
		 else
		 {
		 pw.println("states="+Arrays.toString(ausisStates));
		 }
		 pw.close();
		 }
	
	 
	 @Override
	 public void doPost(HttpServletRequest req, HttpServletResponse res)
			 throws ServletException, IOException{
	 doGet(req, res);

	 }
}