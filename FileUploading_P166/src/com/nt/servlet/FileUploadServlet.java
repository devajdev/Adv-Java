package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;



@WebServlet("/uploadurl")
public class FileUploadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		MultipartFormDataRequest nreq=null;
		UploadBean upb=null;
		Hashtable ht=null;
		Enumeration e=null;
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		try {
			//prepare special request obj
			nreq=new MultipartFormDataRequest(req);
			//specify file uploading setting
			upb=new UploadBean();
			upb.setFolderstore("C:/store");
			upb.setOverwrite(false);
			//complete file uploading
			upb.store(nreq);
			
			//display the name of uploaded file
			pw.println("<h1> The Upload Files Are </h1>");
			ht=nreq.getFiles();
			e=ht.elements();
			while(e.hasMoreElements()) {
				UploadFile file=(UploadFile) e.nextElement();
				pw.println("<br>"+file.getFileName()+"  "+file.getFileSize());
			}//while
		}//try
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}//doPost
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}