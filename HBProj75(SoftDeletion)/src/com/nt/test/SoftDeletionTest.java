package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class SoftDeletionTest {

	public static void main(String[] args) {
		Session ses=null;
		Student st=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load obj 
		st=(Student)ses.get(Student.class,102);
		System.out.println(st);
		try{
		 tx=ses.beginTransaction();
		  ses.delete(st);
		 tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
		
	
      //close Session
		HibernateUtil.closeSession();
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
