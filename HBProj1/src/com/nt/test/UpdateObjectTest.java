package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class UpdateObjectTest {
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
	   
	/*   //Update object using ses.update(-) method (Approach1)
	     details=new EmpDetails();
	     details.setNo(1010);
	     details.setFname("king1");
	     //details.setLname("rao");
	     //details.setMail("king@kingdom.com");
	     try{
	    	 tx=ses.beginTransaction();
	    	   ses.update(details);
	    	 tx.commit();
	    	 System.out.println("Object is updated");
	     }//try
	     catch(Exception e){
	    	 tx.rollback();
	     }*/
	   
	   //Approach2 (Load obj and update the object)
	   details=ses.get(EmpDetails.class, 1010);
	   if(details!=null){
		   try{
			   tx=ses.beginTransaction();
			     details.setMail("xxx2@yy.com");
			     //ses.update(details); //optional
			   tx.commit();
			   System.out.println("object updated");
		   }//try
		   catch(Exception e){
			   tx.rollback();
		   }
	   }//if
	   else{
		   System.out.println("record not found");
	   }
	     
	   


	    
	    
	    //close objs
	   // ses.close();
	    factory.close(); 
	    }//main
 }//class
