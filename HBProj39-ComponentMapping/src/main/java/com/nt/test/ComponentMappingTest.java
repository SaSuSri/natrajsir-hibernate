package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.JobType;
import com.nt.domain.Person;
import com.nt.utility.HibernateUtil;

public class ComponentMappingTest {
	public static void main(String[] args) {
		Session ses=null;
		JobType job1=null;
		 Person person=null;
		 Transaction tx=null;
		// get Session
		ses=HibernateUtil.getSession();
	   //save object
		 job1=new JobType();
		 job1.setJob("clerk");
		 job1.setDepartment(1001);
		 job1.setSalary(9000);
		 person=new Person();
		 person.setPid(101);
		 person.setPname("raja");
		 person.setPjob(job1);
		 try{
		   tx=ses.beginTransaction();
		    ses.save(person);
		   tx.commit();
		   System.out.println("Object is saved ...");
		 }//try
		 catch(Exception e){
			tx.rollback();
		 }

		 //close hibernate objects
		 HibernateUtil.closeSession();
		 HibernateUtil.closeSessionFactory();
	}//main
}//class
