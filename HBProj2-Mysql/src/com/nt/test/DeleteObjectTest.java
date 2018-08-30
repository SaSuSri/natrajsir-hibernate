package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class DeleteObjectTest {
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
	   //create Session
	   ses=factory.openSession();
	   
	 /*  //Delete Object (Approach1: Delete object directly)
	     details=new EmpDetails();
	     details.setNo(1010);
	     try{
	    	 tx=ses.beginTransaction();
	    	   ses.delete(details);
	    	 tx.commit();
	    	 System.out.println("Object deleted");
	     }//try
	     catch(Exception e){
	    	 tx.rollback();
	     }
	*/
	    //Delete object (Approach2: Load and delete object)
     details=ses.get(EmpDetails.class, 1020);
     if(details!=null){
     try{
    	 tx=ses.beginTransaction();
    	   ses.delete(details);
    	  tx.commit();
    	  System.out.println("Object deleted");
     }//try
     catch(Exception e){
    	 tx.rollback();
     }
     }
     else{
    	 System.out.println("object not found");
     }
	    
	    
	    //close objs
	    ses.close();
	    factory.close(); 
	    }//main
 }//class
