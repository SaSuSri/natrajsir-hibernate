package com.nt.test;


import com.nt.dao.M2ODAO;
import com.nt.dao.M2ODAOFactory;
import com.nt.utility.HibernateUtil;

public class AnnoManyToOneTest {

	public static void main(String[] args) {
		 //get DAO
		M2ODAO dao=null;
		dao=M2ODAOFactory.getInstance();
		//invoke methods
		dao.saveDataUsingCarModel();
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
