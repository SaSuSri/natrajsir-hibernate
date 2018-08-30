package com.nt.test;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class ClientApp1 {

	public static void main(String[] args) {
		Session ses=null;
		Student st=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load object
		st=(Student)ses.get(Student.class,101,LockMode.UPGRADE_NOWAIT);
		try{
		  tx=ses.beginTransaction();
		     st.setAddress("hyd21");
		    ses.update(st);
		    System.out.println("Client1 is Sleep state ....");
		    Thread.sleep(30000);
		    System.out.println("Client1 got back normal state");
		  tx.commit();
		   
		}//try
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
		

		
      //close Session
		HibernateUtil.closeSession();
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
