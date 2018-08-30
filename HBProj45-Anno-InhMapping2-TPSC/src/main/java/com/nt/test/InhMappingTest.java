package com.nt.test;

import com.nt.dao.InhDAO;
import com.nt.dao.InhDAOFactory;
import com.nt.utility.HibernateUtil;

public class InhMappingTest {

	public static void main(String[] args) {
		InhDAO dao = null;
		// get DAO
		dao = InhDAOFactory.getInstance();
		// save objects
		   //dao.saveData();
		dao.loadData();

		// close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}// main
}// class
