package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.ChequePayment;
import com.nt.domain.CreditCardPayment;
import com.nt.utility.HibernateUtil;

public class InhMappingInsertTest {

	public static void main(String[] args) {
		Session ses=null;
		CreditCardPayment ccPayment=null;
		ChequePayment chPayment=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//save objects
     //using sub class1 
	ccPayment=new CreditCardPayment();
     ccPayment.setAmount(2000);
     ccPayment.setCcType("VISA");
     //using sub class2 
	chPayment=new ChequePayment();
    chPayment.setAmount(2000);
    chPayment.setChequeType("Self");
    try{
    	tx=ses.beginTransaction();
    	  ses.save(ccPayment);
    	  ses.save(chPayment);
    	tx.commit();
    	System.out.println("Objects are saved....");
    }//try
    catch(Exception e){
    	tx.rollback();
    }
    //close objs
    HibernateUtil.closeSession();
    HibernateUtil.closeSessionFactory();
	}//main
}//class
