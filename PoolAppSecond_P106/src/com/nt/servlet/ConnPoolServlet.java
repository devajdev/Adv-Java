package com.nt.servlet;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.sql.DataSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;

public class ConnPoolServlet extends HttpServlet {
	
	@Resource(name="mypool")
	private DataSource ds;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
														throws ServletException, IOException {
	
		Connection con=null;
		ResultSet rs=null;
		Statement st=null;
		PrintWriter pw=null;
		String tabName=null;
		ResultSetMetaData rsmd=null;
		int colCnt=0;
		
		//general Setting
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read data from browser
		tabName=req.getParameter("table");
		//write jdbc code for remaining work
		try {
			//get con obj from jdbc con pool
		    con=makeConnection();
			//create statement obj
			st=con.createStatement();
			//send and execue sql query
			rs=st.executeQuery("select * from "+tabName);
			//get result set mata data
			rsmd=rs.getMetaData();
			//print col name
			colCnt=rsmd.getColumnCount();
			
			pw.println("<table border='1' bgcolor='cyan'>");
			pw.println("<tr bgcolor='red'>");
			for(int i=1;i<=colCnt;++i) {
				
				pw.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
			}
			
			pw.println("</tr>");
			//process the ResultSet
			while(rs.next()) {
				
				pw.println("<tr>");
				for(int i=1;i<=colCnt;++i) {
					
					pw.println("<td>"+rs.getString(i)+"</td>");
				}
				pw.println("</tr>");
			}
			pw.println("</table>");
			pw.println("<br><a href='index.html'>Try Again</a>");
			//close jdbc obj
			
			rs.close();
			st.close();
			con.close();
			
		}//try close
		catch(Exception e) {
			pw.println("<b><center>Internal Problem</center></b>");
			pw.println("<br><a href='index.html'>Try Again</a>");
		}
		//close Stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
												throws ServletException, IOException {
		
		doGet(req,res);
	}
	
	private Connection makeConnection() {
		Connection con1=null;
		try {
			
			con1=ds.getConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con1;
		
	}//makeConnection
}//class