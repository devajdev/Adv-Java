package com.nt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ss=null;
		String engine=null;
		String url=null;
		ss=req.getParameter("ss");
		engine=req.getParameter("engine");
		//prepare query for send redirection
		if(engine.equalsIgnoreCase("google")) {
			url="https://www.google.co.in/search?q="+ss;
		}
		else if(engine.equalsIgnoreCase("bing")) {
			url="https://www.bing.com/search?q="+ss;
		}
		else {
			url="https://in.search.yahoo.com/search?p="+ss;
		}
		//redirect the particular search engine
		res.sendRedirect(url);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}