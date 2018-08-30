package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.delegate.ManyToManyBusinessDeligage;
import com.nt.dto.ProjectDTO;
import com.nt.errors.InternalProblemException;

public class ManyToManyController extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 String paramValue=null;
		 ManyToManyBusinessDeligage delegate=null;
		 List<ProjectDTO> listDTO=null;
		 boolean isException=false;
		 RequestDispatcher rd=null;
		 String prgmrDeletionMsg=null;
		 int prgmrNo=0;
		 int projNo=0;
		 int oldProjNo=0;
		 int newProjNo=0;
		 String changeProjectMsg=null;
		 //get Addtional req param value
		 paramValue=req.getParameter("param");
		 if(paramValue.equals("allDetails")){
			 delegate=new ManyToManyBusinessDeligage();
			 try{
			 listDTO=delegate.delegateForGetAllProjectWithProgrammer();
			 System.out.println("controller:"+listDTO.size());
			 //keep listDTO in request scope
			 req.setAttribute("listDTO",listDTO);
			 //forward request to details.jsp
			 rd=req.getRequestDispatcher("/details.jsp");
			 rd.forward(req,res);
			 }
			 catch(InternalProblemException ipe){
				 isException=true;
				 ipe.printStackTrace();
			 }
		 }//if
		 else if(paramValue.equals("link1")){
			 prgmrNo=Integer.parseInt(req.getParameter("prgmrid"));
			 projNo=Integer.parseInt(req.getParameter("projid"));
			 //use Delegate
			 delegate=new ManyToManyBusinessDeligage();
			 try{
			 prgmrDeletionMsg=delegate.removeProgrammerFromProjectDelegate(prgmrNo,projNo);
			 listDTO=delegate.delegateForGetAllProjectWithProgrammer();
			 //keep listDTO in request scope
			 req.setAttribute("listDTO",listDTO);
			 req.setAttribute("prgmrMsg", prgmrDeletionMsg);
			 req.setAttribute("prgmrId",prgmrNo);
			 //forward request to details.jsp
			 rd=req.getRequestDispatcher("/details.jsp");
			 rd.forward(req,res);
			 }
			 catch(InternalProblemException ipe){
				 isException=true;
				 ipe.printStackTrace();
			 }
			 
		 }
		 else if(paramValue.equals("link2")){
			 prgmrNo=Integer.parseInt(req.getParameter("prgmrid"));
			 projNo=Integer.parseInt(req.getParameter("projid"));
			 try{
			 //use Delegate
				 delegate=new ManyToManyBusinessDeligage();
			 listDTO=delegate.getAllProjectsWhereGivenProgrammerIsNotWorkingDelegate(prgmrNo);
			 //keep listDTO in request scope
			 req.setAttribute("listDTO",listDTO);
			req.setAttribute("prgmrId",prgmrNo);
			req.setAttribute("projId", projNo);
			 rd=req.getRequestDispatcher("/changeProject.jsp");
			 rd.forward(req,res);
			 }
			 catch(InternalProblemException ipe){
				 isException=true;
				 ipe.printStackTrace();
			 }
		 }
		 else if(paramValue.equals("changeProject")){
			 prgmrNo=Integer.parseInt(req.getParameter("h_prgmrId"));
			 oldProjNo=Integer.parseInt(req.getParameter("h_oldprojId"));
			 newProjNo=Integer.parseInt(req.getParameter("new_projectId"));
			 //use Delegate
			 delegate=new ManyToManyBusinessDeligage();
			 try{
				changeProjectMsg=delegate.changeProgrammerToAnotherProjectDelegate(prgmrNo, oldProjNo, newProjNo);
				 listDTO=delegate.delegateForGetAllProjectWithProgrammer();
				 //keep listDTO in request scope
				 req.setAttribute("listDTO",listDTO);
				 req.setAttribute("prgmrMsg", changeProjectMsg);
				 req.setAttribute("prgmrId",prgmrNo);
				 //forward request to details.jsp
				 rd=req.getRequestDispatcher("/details.jsp");
				 rd.forward(req,res);
			 }
			 catch(InternalProblemException e){
				 e.printStackTrace();
				 isException=true;
			 }
			 
		 }//if
		 
		 
		 if(isException){
			 rd=req.getRequestDispatcher("err.jsp");
			 rd.forward(req,res);
		 }
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class

