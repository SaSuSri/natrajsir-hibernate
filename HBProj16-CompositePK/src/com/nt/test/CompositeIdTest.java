package com.nt.test;

import com.nt.dao.Programmers_ProjectsDAO;
import com.nt.dao.Programmers_ProjectsDAOFactory;
import com.nt.utility.HibernateUtil;

public class CompositeIdTest {

	public static void main(String[] args) {
		Programmers_ProjectsDAO dao=null;
		//get DAO
		dao=Programmers_ProjectsDAOFactory.getInstance();
		 //dao.saveData();
		  //load data
		System.out.println(dao.loadData());
       //close Objects
		 HibernateUtil.closeSession();
		 HibernateUtil.closeSessionFactory();
	}//main
}//class
