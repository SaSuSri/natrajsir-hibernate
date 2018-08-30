package com.nt.test;

import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class AnnoOneToManyTest {

	public static void main(String[] args) {
		 //get DAO
		OneToManyDAO dao=null;
		dao=OneToManyDAOFactory.getInstance();
		//invoke methods
		//dao.saveDataUsingUniversity();
		//dao.loadDataUsingUniversity();
		//dao.loadDataUsingUniversityWithQBC();
		//dao.deleteDataUsingUniversity();
		dao.deleteCollegesOfUniversity();
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
