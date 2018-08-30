package com.nt.test;


import com.nt.dao.OneToOneDAO;
import com.nt.dao.OneToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class AnnoOneToOneTest {

	public static void main(String[] args) {
		 //get DAO
		OneToOneDAO dao=null;
		dao=OneToOneDAOFactory.getInstance();
		//invoke methods
		dao.saveDataUsingFaceBookAccount();
		dao.saveDataUsingUberAccount();

		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
