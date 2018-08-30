package com.nt.test;

import com.nt.dao.BankAccountDAO;
import com.nt.dao.BankAccountDAOFactory;
import com.nt.utility.HibernateUtil;

public class CustomGeneratorTest {

	public static void main(String[] args) {
		BankAccountDAO dao=null;
		String iciciBankAccountNumber=null;
		//get DAO
		dao=BankAccountDAOFactory.getInstance();
		//oopen Account
		iciciBankAccountNumber=dao.openAccount("raja",100000);
		System.out.println("Account number is"+iciciBankAccountNumber);
		
		//close objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
