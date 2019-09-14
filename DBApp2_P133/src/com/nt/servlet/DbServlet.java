package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DbServlet extends HttpServlet {
@Override
public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
	Connection cn=null;
	PreparedStatement ps=null;
	RequestDispatcher rd=null, rd1=null, rd2=null;
	try {
		ServletContext sc=getServletContext();
		String drivername=sc.getInitParameter("driver");
		String conn=sc.getInitParameter("conn");
		String dbuser=sc.getInitParameter("user");
		String dbpwd=sc.getInitParameter("pass");
		Class.forName(drivername);
		cn=DriverManager.getConnection(conn,dbuser,dbpwd);
		ps=cn.prepareStatement("select empno,ename,sal from emp where empno=?");
	}//try close
	catch(Exception e) {
		e.getMessage();
	}	
	try {
		rd1=req.getRequestDispatcher("/headurl");
		rd1.include(req, res);
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<b>Before Riseing Exception</b>");
		int empno=Integer.parseInt(req.getParameter("teno"));
		ps.setInt(1, empno);
		ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			pw.println("<br>Employee Number : "+rs.getInt(1));
			pw.println("<br>Employee Name &nbsp;&nbsp;&nbsp;: "+rs.getString(2));
			pw.println("<br>Employee Salary &nbsp;&nbsp;: "+rs.getInt(3));
			}
			else {
				pw.println("<br>Record Not Found");		
			}
			//add hyperlink
			pw.println("<br><br><a href='input.html'>Search Another Emp Result</a>");
			//get access to servlet config obj
			//include footer content
			rd2=req.getRequestDispatcher("/footer.html");
			rd2.include(req, res);
			
			rs.close();
			pw.close();
	}//try close
	catch(Exception e) {
		e.getMessage();
		rd=req.getRequestDispatcher("/errurl");
		rd.forward(req, res);
	}
	
	
	
	finally {
		try {
			if(cn!=null)
				cn.close();
		}
		catch(Exception e) {
			e.getMessage();
		}
		try {
			if(ps!=null)
				ps.close();
		}
		catch(Exception e) {
			e.getMessage();
		}
	}// finally close	
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
}