package com.nt.test;

import java.sql.SQLException;

import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class Level2CacheTest {

	public static void main(String[] args) {
		Session ses1=null;
		Session ses2=null;
		EmpDetails ed1=null,ed2=null,ed3=null,ed4=null,ed5=null,ed6=null,ed7=null;
		SessionFactory factory=null;
		
		//create SessionFactory
		factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
	   
		// get Sessions
		ses1=factory.openSession();
		ses2=factory.openSession();
		
		//load obj  (loads from DB and puts in L1 cache(ses1) and L2 cache)
		ed1=ses1.get(EmpDetails.class, 334);
		System.out.println(ed1);
		
		//load obj  (loads from L1 cache(ses1))
		ed2=ses1.get(EmpDetails.class, 334);
		System.out.println(ed2);
		
		//load obj(loads from L2 cache and keeps in L1 cache of ses2)
		ed3=ses2.get(EmpDetails.class,334);
		System.out.println(ed3);
		
		//load obj(loads from  L1 cache of ses2)
		ed4=ses2.get(EmpDetails.class,334);
		System.out.println(ed4);
		
		//remove object from L1 cache(ses1) 
		ses1.evict(ed1);
		
		//remove object from L1 cache(ses1)
		ses2.clear();
		
		//load obj  (loads from L2 cache and keeps L1 cache(ses1))
		ed5=ses1.get(EmpDetails.class, 334);
		System.out.println(ed5);
		
		//remove from L1 cache(ses1)
		ses1.evict(ed5);
		//remove from SessionFactory (L2 cache)
         Cache cache=factory.getCache(); //from HB 5.x
         cache.evictAllRegions();
         //load obj(gets form DB and keeps L2 cache and L1 cache(ses1) 
 		ed6=ses1.get(EmpDetails.class, 334);
 		System.out.println(ed6);
 		ses1.evict(ed6); //Removes from L1 cache
 		try{
 		 Thread.sleep(35000);
 		}catch(Exception se){
 			se.printStackTrace();
 		}
 		  //load obj(gets form DB and keeps L2 cache and L1 cache(ses1) 
 		ed7=ses1.get(EmpDetails.class, 334);
 		System.out.println(ed7);
 		
 		//close  objs
 		ses1.close();
 		ses2.close();
 		factory.close();
	}//main
}//class
