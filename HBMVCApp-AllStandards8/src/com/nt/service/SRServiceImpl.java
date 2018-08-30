package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.SRDAO;
import com.nt.dao.SRDAOFactory;
import com.nt.dto.StudentDTO;

public class SRServiceImpl implements SRService {

	@Override
	public String generateResult(StudentDTO dto) {
		int total=0;
		float avg=0.0f;
		String result=null;
		SRDAO dao=null;
		int count=0;
		StudentBO bo=null;
		//write b.logic to get total,avg,result
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(avg<35)
			result="fail";
		else
			result="pass";
		//prepare BO having persistable DAta
		bo=new StudentBO();
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//use DAO
		dao=SRDAOFactory.getInstance();
		count=dao.insert(bo);
		if(count==0)
			return " Result :"+result+" ,but Registration failed";
		else
			return " Result :"+result+" , Registration succedeed";
	}//method
}//class

