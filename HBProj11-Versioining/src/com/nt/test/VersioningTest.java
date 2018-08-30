package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;
import com.nt.util.HibernateUtil;

public class VersioningTest {
  public static void main(String[] args) {
	  Transaction tx=null;
	  EmpDetails details=null;
	  //get Session obj
	  Session ses=HibernateUtil.getSession();
	   //Save object
	/*   details=new EmpDetails();
	   details.setNo(1001);details.setFname("raja");
	   details.setLname("rao"); details.setMail("rao@x.com");
	  try{
	    tx=ses.beginTransaction();
	      ses.save(details);
	    tx.commit();
	  }
	  catch(Exception e){
		  tx.rollback();
	  }
	  System.out.println("Version ::"+details.getVer());*/
	  
	  //Load the obj
	  details=ses.get(EmpDetails.class,1001);
	  if(details!=null){
		  try{
			  tx=ses.beginTransaction();
			  details.setMail("raja2@1345.com");  //object modification
			  tx.commit();
		  }//try
		  catch(Exception e){
			  tx.rollback();
		  }
		  System.out.println("Object version:::"+details.getVer());
	  }//if
	    
	  //close objs
	  HibernateUtil.closeSession();
	  HibernateUtil.closeSessionFactory();
	  
	     }//main
 }//class
