package com.nt.test;

import com.nt.dao.BankDAO;
import com.nt.dao.BankDAOFactory;
import com.nt.utility.HibernateUtil;

public class TxMgmtTest {

	public static void main(String[] args) {
		BankDAO dao=null;
		//get DAO
	   dao=BankDAOFactory.getInstance();
	   if(dao.transferMoney(101, 102,2000))
		     System.out.println("Money transfered");
	   else
		   System.out.println("Money not transfered");
	   //close objs
	   HibernateUtil.closeSession();
	   HibernateUtil.closeSessionFactory();
	}//main
}//class
