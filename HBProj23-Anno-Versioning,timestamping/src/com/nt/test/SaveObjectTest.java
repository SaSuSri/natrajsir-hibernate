package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		Student stud=null;
		Transaction tx=null;
		int idValue=0;
		//Get Session
		ses=HibernateUtil.getSession();
		//prepare domain class obj
		stud=new Student();
		stud.setSname("rani"); stud.setSadd("hyd");
		try{
			tx=ses.beginTransaction();
			 idValue=(Integer)ses.save(stud);
			 System.out.println("Generated id value:::"+idValue);
			 tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
		
	/*	//Load object
		stud=ses.get(Student.class,1);
		if(stud!=null){
			tx=ses.beginTransaction();
			try{
				//modify object
				stud.setSadd("delhi");
				tx.commit();
				System.out.println("object is updated");
			}
			catch(Exception e){
				tx.rollback();
			}
		}*/
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
