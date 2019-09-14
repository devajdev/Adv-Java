package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter pw=null;
		String link=null;
		Locale locales[]=null;
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read "s1" request param value to know the hyperlink that is clicked
		link=req.getParameter("s1");
		if(link.equalsIgnoreCase("link1")) {
			//get all available locals
			locales=Locale.getAvailableLocales();
			for(Locale lc:locales) {
				pw.println(lc.getDisplayLanguage()+"<br>");
			}
		}//if close
		else if (link.equalsIgnoreCase("link2")) {
			//get all available locals
			locales=Locale.getAvailableLocales();
			for(Locale lc:locales) {
				pw.println(lc.getDisplayCountry()+"<br>");
			}//for close
		}//else if close
		else {
			pw.println("Date and Time "+new Date());
		}
		//add hyperlink
		pw.println("<a href='page.html'>home</a>");
	}//doGet(-,-) close
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doGet(req, resp);
	}
}//class close
