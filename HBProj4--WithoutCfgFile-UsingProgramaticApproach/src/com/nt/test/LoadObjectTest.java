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
		
		
		cfg.setProperty("connection.driver_class","oracle.jdbc.driver.OracleDriver");
		cfg.setProperty("hibernate.connection.url","jdbc:oracle:thin:@localhost:1521:xe");
		cfg.setProperty("hibernate.connection.username","system");
		cfg.setProperty("hibernate.connection.password","manager1");
		cfg.setProperty("hibernate.show_sql","true");
		
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//add mapping file
		//cfg.addFile("src/com/nt/cfgs/Employee.hbm.xml");
		//build SessionFactory
		factory=cfg.buildSessionFactory();
		//build Session 
		ses=factory.openSession();
		
		//Load obj/slect record (ses.get(-,-) method)
		details=ses.get(EmpDetails.class,1012);
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
