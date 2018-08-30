package com.nt.test;

import com.nt.dao.TransferDAO;
import com.nt.dao.TransferDAOFactory;
import com.nt.utility.MySqlHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class TransferEmployeeTest {
	public static void main(String[] args) {
		TransferDAO dao=null;
		//get DAO
		dao=TransferDAOFactory.getInstance();
		dao.transferEmloyee(1111);
		
		//close Objects
		OracleHibernateUtil.closeSession();
		OracleHibernateUtil.closeSessionFactory();
		MySqlHibernateUtil.closeSession();
		MySqlHibernateUtil.closeSessionFactory();
	}//main
}//class
