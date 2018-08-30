package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class LoadObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		EmpDetails details=null;
		//Activate Hbiernate F/w
		cfg=new Configuration();
		//Load both  cfg,mapping files
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//build SessionFactory
		factory=cfg.buildSessionFactory();
		//build Session 
		ses=factory.openSession();
		
		//Load obj/slect record (ses.get(-,-) method)
		details=ses.get(EmpDetails.class,101);
		if(details!=null)
			System.out.println(details.getNo()+
					                            "  "+ details.getFname()+
					                               "  "+details.getMail());
		else
			System.out.println("Obect/record not found"); 

	
		//close objs
		ses.close();
		factory.close();
	}

}
