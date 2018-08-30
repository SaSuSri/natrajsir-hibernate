package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class SaveOrUpdateObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		EmpDetails details=null;
		EmpDetails details1=null;
		//create SEssion object
		ses=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml")
				          .buildSessionFactory().openSession();
/*		// save or update object using ses.saveOrUpdate(-)
		 details=new EmpDetails();
		 details.setNo(1005);
		 details.setFname("raja1");
		 details.setLname("rao2");
		 details.setMail("rao2@x.com");
		 try{
			 tx=ses.beginTransaction();
			   ses.saveOrUpdate(details);
			 tx.commit();
			 System.out.println("Object is saved or updated");
		 }//try
		 catch(Exception e){
			tx.rollback();
		 }
*/
		// save or update object using ses.merge(-)
		 details=new EmpDetails();
		 details.setNo(1021);
		 details.setFname("raja1");
		 details.setLname("rao2");
		 details.setMail("rao2@x.com");
		 try{
			 tx=ses.beginTransaction();
			  details1=(EmpDetails)ses.merge(details);
			 tx.commit();
			 System.out.println("Object is saved or updated");
			 System.out.println("details1"+details1);
		 }//try
		 catch(Exception e){
			tx.rollback();
		 }
		
		//close Session
		 ses.close();
	}//main
}//class
