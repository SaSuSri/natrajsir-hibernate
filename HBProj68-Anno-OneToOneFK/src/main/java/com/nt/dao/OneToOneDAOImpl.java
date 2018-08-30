package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Passport;
import com.nt.domain.Person;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {
      
	public void saveDataUsingPassport() {
		Session ses=null;
		Transaction tx=null;
		Person person1=null,person2=null;
		Passport passport=null;
		 //get Session
		ses=HibernateUtil.getSession();
		//create objects
		
		 person1=new Person();
		person1.setPname("ravi");
		person1.setAge(20);
		
		 person2=new Person();
		person2.setPname("raja");
		person2.setAge(40);
		
		passport=new Passport();
		passport.setPname("raja");
		passport.setCountry("india");
		//map Person2 to Passport
		passport.setPersonDetails(person2);
		//save objects
		try{
			tx=ses.beginTransaction();
			  ses.save(passport);
			  ses.save(person1);
			  tx.commit();
		  System.out.println("chid to parent obj is saved");
		}catch(Exception e){
			tx.rollback();
		}
	}//method
}//class
