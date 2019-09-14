package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAO {
	private static final String query="insert into student_tab1 values(sno_auto.nextval,?,?,?,?)";
	
	public int insert(StudentBO bo) {
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try {
			//create initial context
			ic=new InitialContext();
			//get Datasource obj through lookup
			ds=(DataSource)ic.lookup("java:/comp/env/mypool");
			//get coonection from jdbc con pool
			con=ds.getConnection();
			//create preparestatement obj
			ps=con.prepareStatement(query);
			//set value obj to query
			ps.setString(1, bo.getName());
			ps.setInt(2, bo.getTotal());
			ps.setDouble(3, bo.getAvg());
			ps.setString(4, bo.getResult());
			//execute query
			result=ps.executeUpdate();
			
		}//try close
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
