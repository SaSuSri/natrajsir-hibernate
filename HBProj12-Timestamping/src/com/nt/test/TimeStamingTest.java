package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.util.HibernateUtil;

public class TimeStamingTest {
  public static void main(String[] args) {
	  Session ses=null;
	  //Get Session
	  ses=HibernateUtil.getSession();
/*	  //save object
	  EmpDetails details=new EmpDetails();
	  details.setNo(1010);
	  details.setFname("raja");
	  details.setLname("rao");
	  details.setMail("rao@x.com");
	  Transaction tx=null;
	  try{
		   tx=ses.beginTransaction();
		  ses.save(details);
		  tx.commit();
	  }//try
	  catch(Exception e){
		 tx.rollback();
	  }
	  System.out.println("object is saved at::"+details.getLastUpdated());
	*/
	  //Load object
	  EmpDetails details=(EmpDetails)ses.get(EmpDetails.class,1010);
	  if(details!=null){
		  Transaction tx=null;
		  try{
			  tx=ses.beginTransaction();
			   details.setMail("111@123.com");
			   tx.commit();
		  }//try
		  catch(Exception e){
			  tx.rollback();
		  }
		  System.out.println("Objet is lastly updated at"+details.getLastUpdated());
	    }//if
	  
	  
	    
	    //close objs
	  HibernateUtil.closeSession();
	  HibernateUtil.closeSessionFactory();
	    }//main
 }//class
