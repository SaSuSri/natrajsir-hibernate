package com.nt.test;

import com.nt.dao.OToODAO;
import com.nt.dao.OToODAOFactory;
import com.nt.utility.HibernateUtil;

public class OToOTest {

	public static void main(String[] args) {
		OToODAO dao=null;
		//get DAO
		dao=OToODAOFactory.getInstance();
		//invoke methods
		//dao.saveDataUsingStudent();
		//dao.saveDataUsingLibraryMembership();
		//dao.loadDataUsingStudent();
		//dao.loadDataUsingLibraryMembership();
		//dao.delteDataUsingStudent();
		//dao.delteDataUsingLibraryMembership();
		dao.deleteLibraryMembershipOfAStudent();
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
