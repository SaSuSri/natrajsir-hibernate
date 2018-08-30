package com.nt.test;

import com.nt.dao.TransferDAO;
import com.nt.dao.TransferDAOFactory;
import com.nt.utility.HibernateUtil;

public class HQLInsertTest {

	public static void main(String[] args) {
		TransferDAO dao=null;
		int count=0;
		//get DAO
		dao=TransferDAOFactory.getInstance();
		//Make Employees as NGOs
		count=dao.makeEmployeesAsNGOs(1000, 2000);
		System.out.println("No.of Employees Joined:::"+count);
		//close Objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

