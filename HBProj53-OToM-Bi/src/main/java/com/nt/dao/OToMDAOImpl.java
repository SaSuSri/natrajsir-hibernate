package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.PhoneNumber;
import com.nt.domain.User;
import com.nt.utility.HibernateUtil;

public class OToMDAOImpl implements OToMDAO {
 
	@Override
	public void SaveDataUsingParents() {
		Session ses=null;
		User user=null;
		PhoneNumber ph1=null,ph2=null;
		Set<PhoneNumber> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		
		//parent obj
		 user=new User();
		 user.setUserId(1001);
		 user.setFirstName("raja");
		//child objs
		 ph1=new PhoneNumber();
		ph1.setPhone(999999);
		ph1.setNumberType("office");

		 ph2=new PhoneNumber();
		ph2.setPhone(88888);
		ph2.setNumberType("home");
		//set childs to parent 
		childs=new HashSet<PhoneNumber>();
		childs.add(ph1); childs.add(ph2);
		user.setPhones(childs);
		//set parent to childs
		ph1.setParent(user);
		ph2.setParent(user);
		//save objs (parent to child)
		Transaction tx=null;
		try{
		 tx=ses.beginTransaction();
		   ses.save(user);
		 tx.commit();
		 System.out.println("data is saved using parents");
		  }//try
		  catch(Exception e){
		    tx.rollback();
		    }
	}//method
	
	@Override
	public void SaveDataUsingChilds() {
		Session ses=null;
		User user=null;
		PhoneNumber ph1=null,ph2=null;
		Set<PhoneNumber> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		
		//parent obj
		 user=new User();
		 user.setUserId(1002);
		 user.setFirstName("ramesh");
		//child objs
		 ph1=new PhoneNumber();
		ph1.setPhone(54545444);
		ph1.setNumberType("office");

		 ph2=new PhoneNumber();
		ph2.setPhone(545466755);
		ph2.setNumberType("home");
		//set childs to parent 
		childs=new HashSet<PhoneNumber>();
		childs.add(ph1); childs.add(ph2);
		user.setPhones(childs);
		//set parent to childs
		ph1.setParent(user);
		ph2.setParent(user);
		//save objs (parent to child)
		Transaction tx=null;
		try{
		 tx=ses.beginTransaction();
		   ses.save(ph1); ses.save(ph2);
		 tx.commit();
		 System.out.println("data is saved using childs");
		  }//try
		  catch(Exception e){
		    tx.rollback();
		    }
	}//method
	
	@Override
	public void loadUsingParents() {
		Session ses=null;
		Query query=null;
		List<User> list=null;
		Set<PhoneNumber> childs=null;
	  //get Session
		ses=HibernateUtil.getSession();
	    //prpeare query
		query=ses.createQuery("from User");
		//execute Query
		list=query.list();
		//process List
		for(User user:list){
			System.out.println("parent:--->"+user);
			//get All childs of a parent
		   childs=user.getPhones();
		   for(PhoneNumber ph:childs){
			   System.out.println("child:--->"+ph);
		   }//for
		}//for
	}//method
	
	@Override
	public void loadDataUsingChilds() {
		Session ses=null;
		Query query=null;
		List<PhoneNumber> list=null;
		User user=null;
	  //get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from PhoneNumber");
		//execute Query
		list=query.list();
		//process  results
		for(PhoneNumber ph:list){
			System.out.println("Child:--->"+ph);
			//get Associated parent
			user=ph.getParent();
			System.out.println("Parent:--->"+user);
		}//for
	}//method
}//class
