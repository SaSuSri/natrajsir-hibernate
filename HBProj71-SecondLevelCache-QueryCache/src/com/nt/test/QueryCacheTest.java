package com.nt.test;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class QueryCacheTest {

	public static void main(String[] args) {
		Session ses=null;
		SessionFactory factory=null;
		
		//create SessionFactory
		factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
	   
		// get Session
		ses=factory.openSession();
		//execute HQL
		Query query=ses.createQuery("from EmpDetails");
		query.setCacheable(true);
		query.setCacheMode(CacheMode.NORMAL);
		query.setCacheRegion("region1");
		List<EmpDetails> list=query.list();
		for(EmpDetails ed:list){
			System.out.println(ed);
		}
		System.out.println("-----------------------------");
		List<EmpDetails> list1=query.list();
		for(EmpDetails ed:list1){
			System.out.println(ed);
		}
		
 		
 		//close  objs
 		ses.close();
 		factory.close();
	}//main
}//class
