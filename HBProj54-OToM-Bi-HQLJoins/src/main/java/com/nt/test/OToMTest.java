package com.nt.test;

import com.nt.dao.OToMDAO;
import com.nt.dao.OToMDAOFactory;
import com.nt.utility.HibernateUtil;

public class OToMTest {
	public static void main(String[] args) {
		OToMDAO dao=null;
		//get DAO
		dao=OToMDAOFactory.getInstance();
		//save objs
		//dao.loadDataUisngParentsAndJoins();
		//dao.loadDataUisngChildsAndJoins();
	      //dao.loadDataUsingParentsAndFetchJoins();
		dao.loadDataUsingParentAndQBC();
		
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
