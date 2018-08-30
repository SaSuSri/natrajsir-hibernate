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
	   System.out.println("SessionFactory obj is created");
	   try{
	   Thread.sleep(40000);
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
	   //create Session
	   ses=factory.openSession();
	   //save object
	    details=new EmpDetails();
	    details.setNo(1025); details.setFname("raja");
	    details.setLname("rao"); details.setMail("raja6@rani.com");
	    
	 // Save obj using ses.save(-) method
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
	    }
	    
	    
	    //close objs
	    ses.close();
	    factory.close(); 
	    System.out.println("SessionFactory obj closed");
	    }//main
 }//class
