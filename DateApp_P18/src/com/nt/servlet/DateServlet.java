package com.nt.servlet;
import javax.servlet.*;
import java.io.*;
import java.util.*;
public class DateServlet extends GenericServlet {
public void service (ServletRequest req, ServletResponse res) throws ServletException,IOException{
			//set reponse content type
	res.setContentType("text/html");
	//get printwriter obj
	PrintWriter pw=res.getWriter();
	//write response
	Date d=new Date();
	pw.println("<b><i><center><h1 style=color:'green'>Date and time is, "+d+"<h1></center></i></b>");
	/*try {
		Thread.sleep(2000);
	}
	catch(Exception e) {
	}
	pw.println("<br>our servlet class(DateServlet)object hashcode "+this.hashCode());
	pw.println("<br>request obj hashcode "+req.hashCode());
	pw.println("<br>respones obj hashcode "+res.hashCode());
	pw.println("<br>Current thread hashcode "+res.hashCode());
	*/
	//close stream
	pw.close();
	}//service(-,-)
}//class
