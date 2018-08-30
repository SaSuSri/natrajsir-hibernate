package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dao.StudentDAOFactory;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService{

	@Override
	public List<StudentDTO> fetchAllStudents() {
		StudentDAO dao=null;
		List<StudentBO> listBO=null;
		StudentDTO dto=null;
		List<StudentDTO>listDTO=null;
		//get dAO
		dao=StudentDAOFactory.getInstance();
		//use DAO
		listBO=dao.getAllStudents();
		//copy listBO to listDTO
		listDTO=new ArrayList<StudentDTO>();
		for(StudentBO bo:listBO){
			dto=new StudentDTO();
			dto.setSno(bo.getSno());
			dto.setSname(bo.getSname());
			dto.setSadd(bo.getSadd());
			listDTO.add(dto);
		}//for
   return listDTO;	
	}//method
	
	@Override
	public StudentDTO fetchStudentByNo(int no) {
		 StudentDAO dao=null;
		 StudentBO bo=null;
		 StudentDTO dto=null;
		//get DAO
		 dao=StudentDAOFactory.getInstance();
		 //use DAO
		 bo=dao.getStudentByNo(no);
		 //Convert StudentBO to StudentDTO();
		 dto=new StudentDTO();
		 dto.setSno(bo.getSno());
		 dto.setSname(bo.getSname());
		 dto.setSadd(bo.getSadd());
		return dto;
	}//method
	@Override
	public String modifyStudent(StudentDTO dto) {
		StudentBO bo=null;
		StudentDAO dao=null;
		int count=0;
		//Convert StudentDTO to StudentBO
		  bo=new StudentBO();
		  bo.setSno(dto.getSno());
		  bo.setSname(dto.getSname());
		  bo.setSadd(dto.getSadd());
		  //get DAO
		  dao=StudentDAOFactory.getInstance();
		  //use DAO
		  count=dao.updateStudent(bo);
		  if(count==0)
			  return bo.getSno()+" updation failed";
		  else
			  return bo.getSno()+" updation done";
	}//method
}//class
