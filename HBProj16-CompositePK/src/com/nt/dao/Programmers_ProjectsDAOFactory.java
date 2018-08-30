package com.nt.dao;

import com.nt.domain.Programmers_Projects;

public class Programmers_ProjectsDAOFactory {
	
	public  static  Programmers_ProjectsDAO  getInstance(){
		return new  Programmers_ProjectsDAOImpl();
	}

}
