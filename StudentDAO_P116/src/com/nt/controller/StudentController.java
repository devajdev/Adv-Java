package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;

public class StudentController extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StudentVO vo=null;
		String no,name,m1,m2,m3,result;
		StudentDTO dto=null;
		PrintWriter pw=null;
		//ServletOutputStream sos=null;
		StudentService service=null;
		//read data from form
		no=req.getParameter("no");
		name=req.getParameter("name");
		m1=req.getParameter("m1");
		m2=req.getParameter("m2");
		m3=req.getParameter("m3");
		//create vo class obj
		vo=new StudentVO();
		vo.setNo(no);
		vo.setName(name);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
		//convert vo class obj to dto obj
		dto=new StudentDTO();
		dto.setNo(Integer.parseInt(vo.getNo()));
		dto.setName(vo.getName());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		//use service class
		service=new StudentService();
		result=service.generateResult(dto);
		//display result
		//sos=res.getOutputStream();
		pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<h1>Result"+result+"</h1>");
		//add hyperlink
		pw.println("<a href='form.html'>Home</a>");
		//close stream
		pw.close();
		
	}//doGet(-,-);
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}