package com.nt.test;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;
import com.nt.util.HibernateUtil;

public class SaveObjectTest {
  public static void main(String[] args) {
	  Session ses=null;
	  EmpDetails details=null;
	   //get Session
	  ses=HibernateUtil.getSession();
	  //prepare Domain class obj
	  details=new EmpDetails();
	  //details.setNo(1010);
	  details.setFname("raja");
	  details.setLname("rao");
	  details.setMail("rao@x.com");
	  //save Object
	  Transaction tx=null;
	  try{
		  tx=ses.beginTransaction();
		    String idVal=(String) ses.save(details);
		    System.out.println("Generated id value"+idVal);
		  tx.commit();
	  }//try
	  catch(Exception e){
		  tx.rollback();
		  e.printStackTrace();
	  }
	  //close objs
	  HibernateUtil.closeSession();
	  HibernateUtil.closeSessionFactory();
     }//main
 }//class
