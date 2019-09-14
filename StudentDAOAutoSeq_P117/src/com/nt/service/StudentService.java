package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentService {

	public String generateResult(StudentDTO dto) {
		
		int total=0;
		double avg=0.0;
		String result=null;
		StudentDAO dao=null;
		StudentBO bo=null;
		int count=0;
		//use b.logic to cal total, avg, res
		total=(dto.getM1()+dto.getM2()+dto.getM3());
		avg=total/3;
		if(avg<35)
			result="Fail";
		else
			result="Pass";
		//prapare bo obj data for persitance data
		bo=new StudentBO();
		bo.setName(dto.getName());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//use DAO
		dao=new StudentDAO();
		count=dao.insert(bo);
		if(count==0)
			return "Registration Failed";
		else
			return "Registration Successed and Result "+result;
	}
}