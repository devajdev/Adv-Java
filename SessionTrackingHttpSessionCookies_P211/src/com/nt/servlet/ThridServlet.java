package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dao.JobSeekerDAO;
import com.nt.dto.JobSeekerDTO;

@WebServlet("/thirdurl")
public class ThridServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String loc=null;
		int  ctc=0;
		HttpSession ses=null;
		String name=null,addr=null,skill=null;
		int  age=0, exp=0;
		int result=0;
		JobSeekerDTO dto=null;
		JobSeekerDAO dao=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form3/req3 data..
		loc=req.getParameter("loc");
		ctc=Integer.parseInt(req.getParameter("ctc"));
		
		//get Access to HttpSession object
		ses=req.getSession(false);
		//read form1/form2 data from HttpSession obj as session attribute values (Session tracking)
		name=(String)ses.getAttribute("name");
		addr=(String)ses.getAttribute("addr");
		age=(Integer)ses.getAttribute("age");
		skill=(String)ses.getAttribute("skill");
		exp=(Integer)ses.getAttribute("exp");
		dto=new JobSeekerDTO();
		dto.setName(name);
		dto.setAddr(addr);
		dto.setAge(age);
		dto.setSkill(skill);
		dto.setExp(exp);
		dto.setLoc(loc);
		dto.setCtc(ctc);
		dao=new JobSeekerDAO();
		result=dao.insert(dto);
		if(result==0)
			pw.println("<h1 style='color:red;text-align:center'>Registraion Failed </h1>");
		else
			pw.println("<h1 style='color:red;text-align:center'>Registraion Succeded </h1>");
		//add hyperlink
		pw.println("<br> <a href='index.html'>home </a>");
		//close stream
		pw.close();
		
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}
}