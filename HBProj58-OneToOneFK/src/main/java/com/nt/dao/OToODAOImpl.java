package com.nt.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.License;
import com.nt.domain.Person;
import com.nt.utility.HibernateUtil;

public class OToODAOImpl implements OToODAO {

	public void saveDataUsingLicense() {
		Session ses=null;
		Person person=null,person1=null;
		License license=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//create parent ,child objs
		person=new Person();
		person.setFirstName("raja");
		person.setLastName("rao");
		person.setAge((byte)23);
		
		person1=new Person();
		person1.setFirstName("ramesh");
		person1.setLastName("chari");
		person1.setAge((byte)12);
		
		 license=new License();
		 license.setType("two-wheeler");
		 license.setValidFrom(new Date());
		 license.setValidTo(new Date(140,10,20));
		 //map parent to child
		 license.setLicenseHolder(person);
		 //save objs
		 try{
			 tx=ses.beginTransaction();
			  ses.save(license);
			  ses.save(person1);
			  tx.commit();
			  System.out.println("Objects are saved");
		 }//try
		 catch(Exception e){
			 tx.rollback();
		 }
	}//method
	
	public void loadDataUsingLicense() {
		Session ses=null;
		List<License> list=null;
		Person person=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		//execute Query
		query=ses.createQuery("from License");
		list=query.list();
		for(License lic:list){
			System.out.println("child---->"+lic);
			person=lic.getLicenseHolder();
			System.out.println("parent---->"+person);
		}//for
	}//method
	
	public void deleteDataUsingLicense() {
		Session ses=null;
		License lic=null;
		Query query=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load License
		lic=ses.get(License.class,1000);
		try{
			tx=ses.beginTransaction();
			  ses.delete(lic);
            tx.commit();			
            System.out.println("Object is deleted");
		}
		catch(Exception e ){
			tx.rollback();
		}
	}//method
		
}//class
