package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class SelectOperationTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Query query=null;
		List<Student> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load objs
		query=ses.createQuery("from Student");
		list=query.list();
		//process list
		for(Student st:list){
		   System.out.println(st);	
		}//for
		
      //close Session
		HibernateUtil.closeSession();
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
