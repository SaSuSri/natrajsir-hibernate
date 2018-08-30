package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.domain.PhoneNumber;
import com.nt.domain.User;
import com.nt.utility.HibernateUtil;

public class OToMDAOImpl implements OToMDAO {
	
	@Override
	public void loadDataUisngParentsAndJoins() {
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
	  //get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("select u.userId,u.firstName,ph.phone,ph.numberType  from User u full join u.phones ph");
		//execute Query
		list=query.list();
		//process the Result
		for(Object row[]:list){
		   for(Object val:row){
			   System.out.print(val+"   ");
		   }
		   System.out.println();
		}//for
	}//method
	
	@Override
	public void loadDataUisngChildsAndJoins() {
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
	  //get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("select ph.phone,ph.numberType,u.userId,u.firstName  from PhoneNumber ph full join ph.parent u");
		//execute Query
		list=query.list();
		//process the Result
		for(Object row[]:list){
		   for(Object val:row){
			   System.out.print(val+"   ");
		   }
		   System.out.println();
		}//for
	}
	
	@Override
	public void loadDataUsingParentsAndFetchJoins() {
		Session ses=null;
		Query query=null;
		List<User> list=null;
		Set<PhoneNumber> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("select  u from User u inner join  fetch u.phones ph");
		
		//execute query
		list=query.list();
		for(User user:list){
			System.out.println("parent--->"+user);
			//get childs
			childs=user.getPhones();
			if(childs!=null){
			for(PhoneNumber ph:childs){
				System.out.println("child--->"+ph);
		    	}
			}//if
		}//if
	}//method
	@Override
	public void loadDataUsingParentAndQBC() {
		Session ses=null;
		Criteria criteria=null;
		List<User> list=null;
		Set<PhoneNumber> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Criteria obj(QBC)
		criteria=ses.createCriteria(User.class);
		 //use this FetchMode.JOIN to solve 1+n select problem 
		criteria.setFetchMode("phones",FetchMode.SELECT);
		 list=criteria.list();
		 //proces results
		 for(User user:list){
			 System.out.println("parent--->"+user);
			 childs=user.getPhones();
			 for(PhoneNumber ph:childs){
				 System.out.println("child--->"+ph);
			 }//for
		 }//for
	}//method
		
}//class
