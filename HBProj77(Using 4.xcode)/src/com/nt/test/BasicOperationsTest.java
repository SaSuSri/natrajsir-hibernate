package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class BasicOperationsTest {

	public static void main(String[] args) {
		Session ses=null;
		Student st=null;
		//get Session
		ses=HibernateUtil.getSession();
		/*//create Domain class obj
		st=new Student();
		st.setSno(1002); st.setSname("raja");
		st.setAddress("hyd");
		Transaction tx=null;
		try{
		 tx=ses.beginTransaction();
		   ses.save(st);
		  tx.commit();
		  System.out.println("Obj saved/record inserted");
		}//try
		catch(Exception e){
			tx.rollback();
		}*/
		//load obj/get obj
		st=(Student)ses.get(Student.class,1001);
		System.out.println(st);
      //close Session
		HibernateUtil.closeSession();
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
