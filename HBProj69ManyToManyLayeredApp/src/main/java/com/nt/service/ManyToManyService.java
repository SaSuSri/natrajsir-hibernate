package com.nt.service;

import java.util.List;

import com.nt.dto.ProjectDTO;

public interface ManyToManyService {
	public List<ProjectDTO> getAllProjectsWithProgrammers();
	public String deleteProgrammerFromProject(int prgmrId,int projId);
	public List<ProjectDTO> getAllProjectsWhereGivenProgrammerIsNotWorking(int prgmrId);
	public  String  changeProgrammerToAnotherProject(int prmrId,int oldProjId,int newProjId);

}
