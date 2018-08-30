package com.nt.dao;

import java.math.BigDecimal;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.utility.HibernateUtil;

public class BankDAOImpl implements BankDAO {
 private String WITHDRAW_QUERY="UPDATE Account set balance=balance-:amt  where acno=:srcacid";
 private String DEPOSITE_QUERY="UPDATE Account set balance=balance+:amt  where acno=:destacid";
 
	@Override
	public boolean transferMoney(int srcAcno, int destAcno, float amt) {
		 Session ses=null;
		 Transaction tx=null;
		 Query query1=null,query2=null;
		 int result1=0,result2=0;
		  //get Session
		 ses=HibernateUtil.getSession();
		 //for deposite operation
		 query1=ses.createQuery(DEPOSITE_QUERY);
		 query1.setBigDecimal("amt",new BigDecimal(amt));
		 query1.setInteger("destacid",destAcno);
	       result1=query1.executeUpdate();
		//for withdraw operation
		 query2=ses.createQuery(WITHDRAW_QUERY);
		 query2.setBigDecimal("amt",new BigDecimal(amt));
		 query2.setInteger("srcacid",srcAcno);
	       result2=query2.executeUpdate();
		 //begin Transaction
	     try{
 	       tx=ses.beginTransaction();
 	         if(result1!=0 && result2!=0){
         	       tx.commit();
         	       return true;
 	         }
 	         else{
 	        	 tx.rollback();
 	        	 return false;
 	         }
	     }//try
	     catch(Exception e){
	    	 tx.rollback();
	    	 return false;
	     }
	}//method
}//class
