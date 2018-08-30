package com.nt.test;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.Statistics;

import com.nt.domain.EmpDetails;

public class HBStaticsClient {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		Session ses1 = factory.openSession();
		Session ses2 = factory.openSession();
		Session ses3 = factory.openSession();
		Transaction tx=null;


		EmpDetails eb = (EmpDetails) ses1.get(EmpDetails.class, new Integer(1100));
		System.out.println(eb);
		try{
			tx=ses1.beginTransaction();
			  ses1.delete(eb);
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
		}
		 ses2.close();
		// Get Session stats
		 Statistics stats= factory.getStatistics();
		 stats.setStatisticsEnabled(true);
		 
		 System.out.println("open sessions count: "+stats.getSessionOpenCount());
		 System.out.println("closed sessions count "+stats.getSessionCloseCount());
		 System.out.println("Tx count"+stats.getTransactionCount());
		 System.out.println("successful Tx count"+stats.getSuccessfulTransactionCount());
         System.out.println("session start time"+new Date(stats.getStartTime()));		 
         
         // Get Entity Stats
          EntityStatistics es=stats.getEntityStatistics("com.nt.domain.EmpDetails");
          
          System.out.println("delete count::"+es.getDeleteCount());
          System.out.println("insert count::"+es.getInsertCount());
          System.out.println("load count::"+es.getLoadCount());
          System.out.println("update count::"+es.getUpdateCount());
          
          
		ses1.close();
	   factory.close();
	}// main

}// class
