package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySqlHibernateUtil {
	private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	private static SessionFactory factory;
	static{
		factory=new Configuration().configure("com/nt/cfgs/mysql-hibernate.cfg.xml").buildSessionFactory();
	}
   public static  Session getSession(){
	    Session session=null;
	    if(threadLocal.get()==null){
	    	//get Session obj
	    	session=factory.openSession();
	    	threadLocal.set(session);
	    }
	    else{
	    	session=threadLocal.get();
	    }
	    return session;
   }//getSession()
   
   public static void closeSession(){
	   Session session=null;
	   if(threadLocal.get()!=null){
		   session=threadLocal.get();
		   session.close();
		   threadLocal.remove();
	   }
   }//closeSession()
   public static void closeSessionFactory(){
	    factory.close();
   }//method
   
}//class
