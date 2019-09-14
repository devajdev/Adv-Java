package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DbServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
	Connection cn=null;
	PreparedStatement ps=null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
		ps=cn.prepareStatement("select empno,ename,sal from emp where empno=?");
	}//try close
	catch(Exception e) {
		e.getMessage();
	}	
	try {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
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
	}//try close
	catch(Exception e) {
		e.getMessage();
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
}