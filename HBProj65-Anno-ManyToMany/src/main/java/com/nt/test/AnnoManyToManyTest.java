package com.nt.test;


import com.nt.dao.ManyToManyDAO;
import com.nt.dao.ManyToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class AnnoManyToManyTest {

	public static void main(String[] args) {
		 //get DAO
		ManyToManyDAO dao=null;
		dao=ManyToManyDAOFactory.getInstance();
		//invoke methods
		dao.saveDataUsingPatient();
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
