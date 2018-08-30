package com.nt.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class AnnoFilterTest {

	public static void main(String[] args) {
		Session ses=null;
		//Get Session
		ses=HibernateUtil.getSession();
		
		//enable filter
		Filter filter=ses.enableFilter("FILTER_STUDS_BY_RANGE");
		filter.setParameter("min",300);
		filter.setParameter("max",400);
		//execute HQL logics
		Query query=ses.createQuery("from Student");
		List <Student> list=query.list();
		for(Student st:list){
			System.out.println(st);
		}
		//Disable filter
		ses.disableFilter("FILTER_STUDS_BY_RANGE");
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
