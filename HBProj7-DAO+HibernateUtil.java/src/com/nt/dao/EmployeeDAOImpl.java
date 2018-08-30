package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void insertEmployee(int no, String fname, String lname, String email) {
		 Session session=null;
		 EmpDetails details=null;
		 Transaction tx=null;
		//get Session
		session=HibernateUtil.getSession();
	   //create Domain class obj
         details=new EmpDetails();
         details.setNo(no);
         details.setFname(fname);
         details.setLname(lname);
         details.setMail(email);
         //save object
         try{
         tx=session.beginTransaction();
           session.save(details);
           System.out.println("Object saved");
           tx.commit();
         }//try
         catch(Exception e){
        	 tx.rollback();
        	 System.out.println("Object is not saved");
         }
	}//method

	@Override
	public EmpDetails getEmployeeByNo(int no) {
		 Session session=null;
		 EmpDetails details=null;
		 //get Session
		 session=HibernateUtil.getSession();
		 //Load object
		 details=session.get(EmpDetails.class,no);
		 	return details;
	}
	@Override
	public void changeEmailIdByNo(int no, String newEmail) {
		Session session=null;
		 EmpDetails details=null;
		 Transaction tx=null;
		 //get Session
		 session=HibernateUtil.getSession();
		 //load obj
		 details=getEmployeeByNo(no);
		 try{
			 tx=session.beginTransaction();
			  details.setMail(newEmail);
			  tx.commit();
			  System.out.println("Object is modified");
		   }//try
		 catch(Exception e){
			tx.rollback();
			System.out.println("Object is not modified");
		 }
	}//method
	
}//class
