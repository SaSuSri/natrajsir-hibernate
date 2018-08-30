package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.util.HibernateUtil;

public class UpdateVsMergeTest {
	
	public static void main(String[] args) {
		Session ses1=null,ses2=null;
		EmpDetails details1=null,details2=null;
		Transaction tx=null;
		//get Session1
		ses1=HibernateUtil.getSession();
		//load object
		details1=ses1.get(EmpDetails.class,1001);
		System.out.println(details1);
		HibernateUtil.closeSession();
		details1.setMail("xyz@123.com"); //Detached state object
		//get Session2
		ses2=HibernateUtil.getSession();
		details2=ses2.get(EmpDetails.class,1001);
		 try{
			 tx=ses2.beginTransaction();
			   //ses2.update(details1);
			   //ses2.saveOrUpdate(details1);
			 ses2.merge(details1);
			   tx.commit();
		 }//try
		 catch(Exception e){
			 tx.rollback();
			 e.printStackTrace();
		 }
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	 }//main
}///class
