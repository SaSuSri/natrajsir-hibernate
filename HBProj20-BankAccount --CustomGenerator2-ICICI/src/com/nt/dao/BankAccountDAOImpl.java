package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Account;
import com.nt.utility.HibernateUtil;

public class BankAccountDAOImpl implements BankAccountDAO {

	@Override
	public String openAccount(String holderName, int initialAmount) {
		Account account=null;
		Session ses=null;
		Transaction tx=null;
	   //prepare Domain class obj
		account=new Account();
		account.setHolder(holderName);
		account.setBalance(initialAmount);
		//get Session 
		ses=HibernateUtil.getSession();
		//save object
		try{
			tx=ses.beginTransaction();
			  String idValue=(String)ses.save(account);
			 tx.commit();
			 return idValue;
		}//try
		catch(Exception e){
		  return "Could not open account";
		}
	}//method
}//class
