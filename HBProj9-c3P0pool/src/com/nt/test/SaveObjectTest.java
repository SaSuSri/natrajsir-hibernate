package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class SaveObjectTest {
  public static void main(String[] args) {
	  Configuration cfg=null;
	  SessionFactory factory=null;
	  Session ses=null;
	  EmpDetails details=null;
	  Transaction tx=null;
	   //Activate HIbernate Framework
	   cfg=new Configuration();
	   //read both HB cfg,mapping file info
	   cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
	   //create SessionFactory object
	   factory=cfg.buildSessionFactory();
	   System.out.println("SessionFactory object class name"+factory.getClass());
	   //create Session
	   ses=factory.openSession();
	   System.out.println("session object class name"+ses.getClass());

	   //save object
	    details=new EmpDetails();
	    details.setNo(1020); details.setFname("raja");
	    details.setLname("rao"); details.setMail("raja@rani.com");
	    
	  /* Save obj using ses.save(-) method
	      try{
	    	//begin Transaction
	    	tx=ses.beginTransaction();
	    	  int id=(Integer)ses.save(details);
	    	  System.out.println("Generated Identifer::"+id);
	    	tx.commit();
	    	System.out.println("object is saved");
	    }
	    catch(Exception e){
	    	tx.rollback();
	    }*/
	    
   // Save obj using ses.persist(-) method
	      try{
	    	//begin Transaction
	    	tx=ses.beginTransaction();
	    	  ses.persist(details);
	    	  System.out.println("1");
	    	tx.commit();
	    	System.out.println("2");
	    	System.out.println("Object is peristed");
	    }
	    catch(Exception e){
	    	tx.rollback();
	    }

	    
	    
	    //close objs
	   // ses.close();
	    factory.close(); 
	    }//main
 }//class
