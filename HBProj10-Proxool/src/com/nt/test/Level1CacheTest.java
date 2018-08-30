package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class Level1CacheTest {

	public static void main(String[] args) {
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		//create SEssion object
		ses=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml")
				          .buildSessionFactory().openSession();
		 //Angel1
	/*	//Load obj  gets from DB and keeps L1 cache
		details=(EmpDetails)ses.get(EmpDetails.class,1001);
		System.out.println(details);
		System.out.println("........................................");
		//Load obj (gets from L1 cache)
		details=(EmpDetails)ses.get(EmpDetails.class,1001);
		System.out.println(details);
		System.out.println("........................................");
		//Remove obj from L1 cache
		ses.evict(details);
		//gets from DB and keeps L1 cache
		System.out.println("........................................");
		details=(EmpDetails)ses.get(EmpDetails.class,1001);
		System.out.println(details);
		//gets from L1 cache
		System.out.println("........................................");
		details=(EmpDetails)ses.get(EmpDetails.class,1001);
		System.out.println(details);
		//Removes all objs from L1 cache
		ses.clear();
		//gets from DB and keeps in L1 cache
		System.out.println("........................................");
		details=(EmpDetails)ses.get(EmpDetails.class,1001);
		System.out.println(details);
		*/
		
		//Angel2 
	 //Loads obj from DB and keeps in L1 cache
	details=ses.get(EmpDetails.class,1001);
	try{
		tx=ses.beginTransaction();
		  details.setLname("chari");
		  details.setMail("rani@chari.com");
	    tx.commit();	  
   		System.out.println("Object updated");
	}//try
	catch(Exception e){
		tx.rollback();
	}
		
		
		
		//close Session
		ses.close();
	}//main
}//class
