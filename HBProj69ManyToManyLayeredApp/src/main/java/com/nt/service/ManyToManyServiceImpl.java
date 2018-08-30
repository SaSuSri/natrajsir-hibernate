package com.nt.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.nt.dao.ManyToManyDAO;
import com.nt.dao.ManyToManyDAOFactory;
import com.nt.domain.Programmer;
import com.nt.domain.Project;
import com.nt.dto.ProgrammerDTO;
import com.nt.dto.ProjectDTO;

public class ManyToManyServiceImpl implements ManyToManyService {

@Override
	public List<ProjectDTO> getAllProjectsWithProgrammers() {
		 
		  ManyToManyDAO dao=null;
		  List<Project> listProjects=null;
		  List<ProjectDTO> listProjectsDTO=null;
		  Set<Programmer>setProgrammers=null;
		  Set<ProgrammerDTO> setProgrammersDTO=null;
		  ProgrammerDTO programmerDTO =null;
		  ProjectDTO projectDTO=null;
		  //use DAO
		 dao=ManyToManyDAOFactory.getInstance();
		 listProjects=dao.listAllProjectsWithProgrammers();
		 //copy ListDomain to ListDTO
		 listProjectsDTO=new ArrayList<ProjectDTO>();
		 for(Project project:listProjects){
			 projectDTO=new ProjectDTO();
			 projectDTO.setProid(project.getProid());
			 projectDTO.setProname(project.getProname());
		     setProgrammers=project.getProgrammers();
		     setProgrammersDTO=new HashSet<ProgrammerDTO>();
			 for(Programmer programmer:setProgrammers){
				  programmerDTO=new ProgrammerDTO();
				  programmerDTO.setPid(programmer.getPid());
				  programmerDTO.setPname(programmer.getPname());
				  programmerDTO.setSalary(programmer.getSalary());
				  setProgrammersDTO.add(programmerDTO);
			  }//for
			 projectDTO.setProgrammers(setProgrammersDTO);
			 listProjectsDTO.add(projectDTO);
		 }//for
		 System.out.println("service"+listProjectsDTO.size());
		return listProjectsDTO;

	}//method

@Override
	public String deleteProgrammerFromProject(int prgmrId,int projId) {
	ManyToManyDAO dao=null;
	int result=0;
	   //use dAO
	 dao=ManyToManyDAOFactory.getInstance();
	 result=dao.removeProrammerFromProject(prgmrId,projId);
	 if(result==0)
		 return "Programmer deletion failed";
	 else
		 return "programmer deleted";
	 }//method

@Override
	public List<ProjectDTO> getAllProjectsWhereGivenProgrammerIsNotWorking(int prgmrId) {
	ManyToManyDAO dao=null;
	List<Project> listProjs=null;
    List<ProjectDTO> listProjsDTO=null;
    ProjectDTO projectDTO=null;
	   //use dAO
	 dao=ManyToManyDAOFactory.getInstance();
      listProjs=dao.listOtherProjectsInfoWhereGivenProgrammerNotWorking(prgmrId);
      //Convert ListProject to ListProjectDTO
      listProjsDTO =new ArrayList();
      for(Project proj:listProjs){
    	  projectDTO=new ProjectDTO();
    	  projectDTO.setProid(proj.getProid());
    	  projectDTO.setProname(proj.getProname());
    	  listProjsDTO.add(projectDTO);
      }//for
		return listProjsDTO;
	}//method
  
 @Override
	public String changeProgrammerToAnotherProject(int prgmrId, int oldProjId, int newProjId) {
	 ManyToManyDAO dao=null;
	 int result=0;
	 //use DAO
	 dao=ManyToManyDAOFactory.getInstance();
	 result=dao.moveProgrammerToAnotherExistingProject(prgmrId, oldProjId, newProjId);
	 if(result==0)
		 return "Prorammer is not moved to Another Project";
	 else
		 return "Programmer no:"+prgmrId+" is moved new Project no:"+newProjId+" from old Project"+oldProjId;
	}//method
}//class
