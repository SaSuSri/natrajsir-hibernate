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

		childs=new HashSet<PhoneNumber>();
		childs.add(ph1); childs.add(ph2);
		//set childs to parent
		user.setPhones(childs);

		//save objs (parent to child)
		Transaction tx=null;
		try{
		 tx=ses.beginTransaction();
		   ses.persist(user);
		 tx.commit();
		 System.out.println("Objects are saved....");
		  }//try
		  catch(Exception e){
		    tx.rollback();
		    }
	}//method

	@Override
	public void loadDataUsingParent() {
		Session ses=null;
		Query query=null;
		List<User> list=null;
		Set<PhoneNumber> childs=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		//create Query obj
		query=ses.createQuery("from User");
		//execute Query
		list=query.list();
		//process the Results
		for(User user:list){
			System.out.println("parent---->"+user);
			//get all childs of each parent
			childs=user.getPhones();
			System.out.println(childs.size());
			for(PhoneNumber ph:childs){
				//System.out.println("child--->"+ph);
			}//for
		
			}//for
	}//method
	
	@Override
	public void deleteDataUsingParent() {
		Session ses=null;
		User user=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load parent obj
		user=(User)ses.get(User.class,1001);
		//delete parent obj with associated child objs
		
		try{
			tx=ses.beginTransaction();
			 ses.delete(user);
			tx.commit();
			System.out.println("parent obj and associated child objs are deleted");
		}//try
		catch(Exception e){
			tx.rollback();
		}
		
	}//method
	
	@Override
	public void deleteOneChildFromCollectionOfChildsInAParent() {
		Session ses=null;
		User user=null;
		Set<PhoneNumber> childs=null;
		PhoneNumber ph=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load parent
		user=(User)ses.get(User.class,1001);
		//get Childs from a Parent
		childs=user.getPhones();
		//Load child obj from DB that u want to delete
		ph=(PhoneNumber)ses.get(PhoneNumber.class,(long)999999);
		//delete child from collection of childs
		try{
			tx=ses.beginTransaction();
			    childs.remove(ph);
			 tx.commit();
			 System.out.println("Removing child obj from collection of childs");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	@Override
	public void addingNewChildToExistingParent() {
		Session ses=null;
		User user=null;
		Set<PhoneNumber> childs=null;
		Transaction tx=null;
		PhoneNumber ph3=null;
	   //get Session
		ses=HibernateUtil.getSession();
		//Load parent object(Existing)
		user=(User)ses.get(User.class,1001);
		//get Existing childs of a parent
		childs=user.getPhones();
		//create new Child
		ph3=new PhoneNumber();
		ph3.setPhone(77777777);
		ph3.setNumberType("personal");
		try{
			tx=ses.beginTransaction();
			  childs.add(ph3);
			tx.commit();
			System.out.println("new PhoneNumber is added to existing phoneNumbers");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	@Override
	public void deleteAllChildsOfAParent() {
		Session ses=null;
		User user=null;
		Set<PhoneNumber> childs=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load parent
		user=ses.get(User.class,1001);
		//get All childs
		childs=user.getPhones();
		try{
		 tx=ses.beginTransaction();
		   childs.removeAll(childs);
		  tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
		System.out.println("All childs of a Parent are deleted");
	}//method
	
}//class
