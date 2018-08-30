package com.nt.test;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class ReloadingObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		EmpDetails details=null;
		//create SEssion object
				ses=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml")
						          .buildSessionFactory().openSession();
			//load object
			details=(EmpDetails)ses.get(EmpDetails.class,1001);
			System.out.println(details);
			try{
			Thread.sleep(40000);  //modify record at Db side (1001)
			}
			catch(Exception e){}
	        ses.refresh(details);
	        System.out.println(details);
	        
			 
			
			
				
				//close Session
			ses.close();

	}

}
