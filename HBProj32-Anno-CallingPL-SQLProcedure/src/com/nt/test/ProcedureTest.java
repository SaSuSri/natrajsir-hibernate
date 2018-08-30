package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class ProcedureTest {

	public static void main(String[] args) {
		Session ses=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//get Access to Named Native SQL Query and execute ti
		Query query=ses.getNamedQuery("CALL_PROCEDURE");
		 query.setString("initChars","s%");
		 List<Student> list=query.list();
		 for(Student st:list){
			 System.out.println(st);
		 }
		 
		 
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
