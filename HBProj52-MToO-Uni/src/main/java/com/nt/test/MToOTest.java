package com.nt.test;

import com.nt.dao.MToODAO;
import com.nt.dao.MToODAOFactory;
import com.nt.utility.HibernateUtil;

public class MToOTest {

	public static void main(String[] args) {
		MToODAO dao=null;
		//get DAO
		dao=MToODAOFactory.getInstance();
		//use DAO
		//dao.saveDataUsingChilds();
		//dao.loadDataUsingChilds();
		//dao.deleteDataUsingChilds();
		//dao.deleteOneChildOfAParent();
		//dao.addNewChildToExistingParent();
		//dao.addExistingChildToNewDepartment();
		//dao.deleteAllChildsOfAParent();
		
       //close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

