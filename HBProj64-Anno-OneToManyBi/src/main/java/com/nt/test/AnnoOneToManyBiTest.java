package com.nt.test;


import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class AnnoOneToManyBiTest {

	public static void main(String[] args) {
		 //get DAO
		OneToManyDAO dao=null;
		dao=OneToManyDAOFactory.getInstance();
		//invoke methods
		dao.saveDataUsingCountry();
		dao.saveDataUsingState();
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
