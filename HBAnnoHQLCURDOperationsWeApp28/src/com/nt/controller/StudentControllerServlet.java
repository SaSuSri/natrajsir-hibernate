package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.service.StudentServiceFactory;

public class StudentControllerServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StudentService service=null;
		List<StudentDTO> listDTO=null;
		RequestDispatcher rd=null;
		String param=null;
		int no=0;
		StudentDTO dto=null;
		String name=null,addrs=null;
		String edit_result=null;
		
		//read param request param value
		param=req.getParameter("param");
		//get Service class obj
		service=StudentServiceFactory.getInstance();
		if(param.equalsIgnoreCase("report")){
		//use Service 
		listDTO=service.fetchAllStudents();
		//place results in request scope
		req.setAttribute("resultList", listDTO);
		//forward to report.jsp
		rd=req.getRequestDispatcher("/report.jsp");
		rd.forward(req,res);
		}
		else if(param.equalsIgnoreCase("edit")){
		  //read no param value
			no=Integer.parseInt(req.getParameter("no"));
			//use Service
			dto=service.fetchStudentByNo(no);
			//keep dto in request scope
			req.setAttribute("stDTO",dto);
			//forward request to jsp
			rd=req.getRequestDispatcher("/edit_student.jsp");
			rd.forward(req,res);
		}//else
		else if(param.equalsIgnoreCase("update")){
			//read form data
			no=Integer.parseInt(req.getParameter("no"));
			name=req.getParameter("name");
			addrs=req.getParameter("addrs");
			//convert form Data into DTO
			dto=new StudentDTO();
			dto.setSno(no);dto.setSname(name);dto.setSadd(addrs);
			//use Service class 
			edit_result=service.modifyStudent(dto);
			//keep reuslt in request scope
			req.setAttribute("editResult", edit_result);
			//forward request to jsp
			rd=req.getRequestDispatcher("/edit_student.jsp");
			rd.forward(req,res);
		}
		
	
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      doGet(req,res);
	}//doPost(-,-)
}//class
