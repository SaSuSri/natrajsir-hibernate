package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;
import com.nt.util.HibernateUtil;

public class ThreeStatesTest {
  public static void main(String[] args) {
	  Session ses=null;
	  EmpDetails details=null;
	  Transaction tx=null;
	  //get Session
	  ses=HibernateUtil.getSession();
	  //create Trasient state object
	  details=new EmpDetails();  //Transient state
	  details.setNo(1212);
	  details.setFname("raja");
	  details.setLname("rao");
	  details.setMail("rao@x.com");
	  //save object
	   try{
		   tx=ses.beginTransaction();
		    ses.save(details);  //persistnece state
		    details.setMail("xxx@123.com");
		   tx.commit();
	   }//try
	   catch(Exception e){
		   tx.rollback();
	   }
	   
	   //close objs
	   HibernateUtil.closeSession();  // Detached statement obj (details)
	   details.setMail("yyy@123.com");
	   HibernateUtil.closeSessionFactory();
 	    }//main
 }//class
