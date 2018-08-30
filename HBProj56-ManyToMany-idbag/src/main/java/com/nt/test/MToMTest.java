package com.nt.test;

import com.nt.dao.MToMDAO;
import com.nt.dao.MToMDAOFactory;
import com.nt.utility.HibernateUtil;

public class MToMTest {

	public static void main(String[] args) {
		MToMDAO dao=null;
		//get DAO
		dao=MToMDAOFactory.getInstance();
		//save objs
		dao.saveDataUsingParents();
		dao.saveDataUsingChilds();
		

		 
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
