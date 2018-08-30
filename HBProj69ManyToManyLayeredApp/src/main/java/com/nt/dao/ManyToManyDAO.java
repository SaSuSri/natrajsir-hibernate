package com.nt.dao;

import java.util.List;



import com.nt.domain.Project;

public interface ManyToManyDAO {
	
	public List<Project> listAllProjectsWithProgrammers();
	public  int  removeProrammerFromProject(int prgmrId,int projId);
	public  List<Project> listOtherProjectsInfoWhereGivenProgrammerNotWorking(int prgmrId);
	public  int  moveProgrammerToAnotherExistingProject(int prgmrId,int oldProjId,int newProjId);

}
