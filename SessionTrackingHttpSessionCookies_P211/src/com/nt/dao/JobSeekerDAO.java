package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import com.nt.dto.JobSeekerDTO;

public class JobSeekerDAO extends HttpServlet {
	private String query="INSERT INTO INFO VALUES(REGNO.NEXTVAL,?,?,?,?,?,?,?)";
	
	public int insert(JobSeekerDTO dto) {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		try{
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dev","duggu");
			//create PreparedStatement object
			ps=con.prepareStatement(query);
			//set value obj to query
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getAddr());
			ps.setInt(3, dto.getAge());
			ps.setInt(4, dto.getExp());
			ps.setString(5, dto.getSkill());
			ps.setInt(6, dto.getCtc());
			ps.setString(7, dto.getLoc());
			result=ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 finally {
			 try {
				 if(ps!=null)
					 ps.close();
			 }
			 catch(SQLException e) {
			 e.printStackTrace();
			 }
			 try {
				 if(con!=null)
					 con.close();
			 }
			 catch(SQLException e) {
			 e.printStackTrace();
			 }
		 }//finally
		return result;
	}
}