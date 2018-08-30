package com.nt.test;


import com.nt.dao.OneToOneDAO;
import com.nt.dao.OneToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class AnnoOneToOneFKTest {

	public static void main(String[] args) {
		 //get DAO
		OneToOneDAO dao=null;
		dao=OneToOneDAOFactory.getInstance();
		//invoke methods
		dao.saveDataUsingPassport();
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
