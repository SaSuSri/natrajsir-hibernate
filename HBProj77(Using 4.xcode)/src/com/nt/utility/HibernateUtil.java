package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory factory=null;
	private static ThreadLocal<Session>threadLocal=
		                         new ThreadLocal<Session>();	
	
	static{
		Configuration cfg=
		        new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder=
		                           new StandardServiceRegistryBuilder();
		ServiceRegistry registry=builder.applySettings(cfg.getProperties()).build();
		 factory=cfg.buildSessionFactory(registry);
	}
	
	public static Session getSession(){
		Session session=null;
		if(threadLocal.get()==null){
		  session=factory.openSession();
		  threadLocal.set(session);
		}
		else{
			session=threadLocal.get();
		}
		return session;
		
	}//method
	
	public static void closeSession(){
		if(threadLocal.get()!=null){
			threadLocal.get().close();
			threadLocal.remove();
		}
	}//method
	
	public static void closeSessionFactory(){
		factory.close();
	}
	

}
