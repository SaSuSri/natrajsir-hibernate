package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class AnnoNamedHQLTest {

	public static void main(String[] args) {
		Session ses=null;
		Student stud=null;
		Transaction tx=null;
		int idValue=0;
		//Get Session
		ses=HibernateUtil.getSession();
		//get access to NamedQuery
		Query query1=ses.getNamedQuery("GET_STUDENTS_BY_RANGE");
		 query1.setInteger("min",300);
		 query1.setInteger("max",500);
		 List<Student> list=query1.list();
		  for(Student st:list){
		       System.out.println(st);
		   }
		//get access to NamedQuery
		  Query query2=ses.getNamedQuery("UPDATE_ADDRS");
		  query2.setString("newAddrs","hyd");
		  query2.setString("oldAddrs","delhi");
		  try{
		   tx=ses.beginTransaction();
		     int cnt=query2.executeUpdate();
		     System.out.println("no.of records effected"+cnt);
		    tx.commit();
		    }
		   catch(Exception e){
		    tx.rollback();
		    }
	
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
