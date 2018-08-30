package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.SRService;
import com.nt.service.SRServiceImpl;
import com.nt.vo.StudentVO;

public class SRControllerServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   String name=null,m1=null,m2=null,m3=null;
		   StudentVO vo=null;
		   StudentDTO dto=null;
		   SRService service=null;
		   String result=null;
		   RequestDispatcher rd=null;
		  //read form data
		   name=req.getParameter("sname");
		   m1=req.getParameter("m1");
		   m2=req.getParameter("m2");
		   m3=req.getParameter("m3");
		   //create VO class obj
		   vo=new StudentVO();
		   vo.setSname(name);
		   vo.setM1(m1);
		   vo.setM2(m2);
		   vo.setM3(m3);
		   //Convert VO Class obj to DTO class obj
		   dto=new StudentDTO();
		   dto.setSname(vo.getSname());
		   dto.setM1(Integer.parseInt(vo.getM1()));
		   dto.setM2(Integer.parseInt(vo.getM2()));
		   dto.setM3(Integer.parseInt(vo.getM3()));
		   //use Service class services
		   service=new SRServiceImpl();
		   result=service.generateResult(dto);
		   //keep result in request scope
		   req.setAttribute("resultMsg",result);
		   //forward the request to jsp comp
		   rd=req.getRequestDispatcher("result.jsp");
		   rd.forward(req, res);
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class
