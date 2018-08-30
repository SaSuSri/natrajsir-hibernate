package com.nt.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Country;
import com.nt.domain.State;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	public void saveDataUsingCountry() {
		Session ses=null;
		Country country=null;
		State state1=null,state2=null;
		Set<State> childs=null;
		Transaction tx=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		 country=new Country();
		 country.setName("India");
		 country.setCapital("New Delhi");
		 country.setLanguage("Hindi");
		 
		 state1=new State();
		 state1.setCode("UP");
		 state1.setName("UttarPrdesh");
		 state1.setCapital("luknow");
		 
		 state2=new State();
		 state2.setCode("KR");
		 state2.setName("Kerala");
		 state2.setCapital("Tivendram");
		 //set chils to parent
		 childs=new HashSet<State>();
		 childs.add(state1); childs.add(state2);
		 country.setStates(childs);
		 //set parent to childs
		 state1.setCountry(country);
		 state2.setCountry(country);
		 //save objs (parent to child)
		 try{
			 tx=ses.beginTransaction();
			   ses.save(country);
			  tx.commit();
			  System.out.println("Objects are saved....");
		  }//try
		 catch(Exception e){
			 tx.rollback();
		 }//catch
	}//method

	public void saveDataUsingState() {
		Session ses=null;
		Country country=null;
		State state1=null,state2=null;
		Set<State> childs=null;
		Transaction tx=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		 country=new Country();
		 country.setName("pakistan");
		 country.setCapital("islamabad");
		 country.setLanguage("urdu");
		 
		 state1=new State();
		 state1.setCode("PN");
		 state1.setName("punjab");
		 state1.setCapital("lahore");
		 
		 state2=new State();
		 state2.setCode("BL");
		 state2.setName("Beluchistan");
		 state2.setCapital("ravalpindi");
		 //set chils to parent
		 childs=new HashSet<State>();
		 childs.add(state1); childs.add(state2);
		 country.setStates(childs);
		 //set parent to childs
		 state1.setCountry(country);
		 state2.setCountry(country);
		 //save objs ( child to parent)
		 try{
			 tx=ses.beginTransaction();
			    ses.save(state1);
			    ses.save(state2);
			  tx.commit();
			  System.out.println("Objects are saved....");
		  }//try
		 catch(Exception e){
			 tx.rollback();
		 }//catch

	}//method
}//class
