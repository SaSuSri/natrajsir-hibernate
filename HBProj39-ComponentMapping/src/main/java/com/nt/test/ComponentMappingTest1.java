package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.domain.JobType;
import com.nt.domain.Person;
import com.nt.utility.HibernateUtil;

public class ComponentMappingTest1{
	public static void main(String[] args) {
		Session ses=null;
		JobType job1=null;
		 Person person=null;
		 Query query=null;
		 List<Person> list=null;
		// get Session
		ses=HibernateUtil.getSession();
		//Load objs
		query=ses.createQuery("from Person where pjob.department=:dept");
		query.setParameter("dept",1001);
		list=query.list();
		for(Person per:list){
			System.out.println("Person info::"+per.getPid()+"  "+per.getPname());
			 job1=per.getPjob();
			System.out.println("Job Details::"+job1.getJob()+"  "+job1.getDepartment()+"  "+job1.getSalary());
		}
		 //close hibernate objects
		 HibernateUtil.closeSession();
		 HibernateUtil.closeSessionFactory();
	}//main
}//class
