package com.nt.delegate;

import java.util.List;

import org.hibernate.HibernateException;

import com.nt.dto.ProjectDTO;
import com.nt.errors.InternalProblemException;
import com.nt.service.ManyToManyService;
import com.nt.service.ManyToManyServiceImpl;

public class ManyToManyBusinessDeligage {

	public List<ProjectDTO> delegateForGetAllProjectWithProgrammer()throws InternalProblemException{
		ManyToManyService service=null;
		List<ProjectDTO> listProjects=null;
	  //use service	
		try{
			service=new ManyToManyServiceImpl();
			listProjects=service.getAllProjectsWithProgrammers();
		}//try
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());  //convert Technology Specifc Exception to ProjectSpecific Custom Exception
		}	  
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
		return listProjects;
	}//method
	
	public String  removeProgrammerFromProjectDelegate(int prgmrId,int projId)throws InternalProblemException{
		ManyToManyService service=null;
		String resultMsg=null;
		try{
		//use service
		  service=new ManyToManyServiceImpl();
		  resultMsg=service.deleteProgrammerFromProject(prgmrId,projId);
		
		}//try
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		  return resultMsg;
	}//method
	public List<ProjectDTO>getAllProjectsWhereGivenProgrammerIsNotWorkingDelegate(int prgmrId)throws InternalProblemException{
		ManyToManyService service=null;
		List<ProjectDTO> listProjsDTO=null;
		try{
		//use service
		  service=new ManyToManyServiceImpl();
		  listProjsDTO=service.getAllProjectsWhereGivenProgrammerIsNotWorking(prgmrId);
		}//try
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return listProjsDTO;
	}
	
	public String changeProgrammerToAnotherProjectDelegate(int prgmrId, int oldProjId, int newProjId)throws InternalProblemException {
		ManyToManyService service=null;
		String updateMsg=null;
		//use Service
		service=new ManyToManyServiceImpl();
		try{
			updateMsg=service.changeProgrammerToAnotherProject(prgmrId, oldProjId, newProjId);
	   }
	  catch(HibernateException he){
		  throw new InternalProblemException(he.getMessage());
	  }
	  catch(Exception e){
		  throw new InternalProblemException(e.getMessage());
	  }
		return updateMsg;
	}//method
	
}//class
