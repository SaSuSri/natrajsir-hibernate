package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.College;
import com.nt.domain.University;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO{
	
	public void saveDataUsingUniversity() {
		Session ses=null;
		University university=null;
		College college1=null,college2=null;
		Set<College> childs=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare parent ,child objs
		university=new University();
		university.setName("JNTUH");
		university.setRegion("Telgana");
		
		college1=new College();
		college1.setName("CBIET");
		college1.setLocation("GandiPet-hyd");
		
		college2=new College();
		college2.setName("MREC");
		college2.setLocation("kompally-hyd");
		
		childs=new HashSet<College>();
		childs.add(college1);
		childs.add(college2);
		//set childs to parent
		university.setColleges(childs);
		try{
			tx=ses.beginTransaction();
			  ses.save(university);
			tx.commit();
			System.out.println("Parent objs and associated child objs are saved");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	public void loadDataUsingUniversity() {
		Session ses=null;
		List<University> list=null;
		Set<College> childs=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from University");
		//execute Query
		list=query.list();
		//process list
		for(University university:list){
			System.out.println("Parent ---->"+university);
			childs=university.getColleges();
			for(College clg:childs){
				System.out.println("child ---->"+clg);
			}//for
		}//for
	}//method
	public void loadDataUsingUniversityWithQBC() {
		Session ses=null;
		List<University> list=null;
		Set<College> childs=null;
		Criteria criteria=null;
		//get Session
		ses=HibernateUtil.getSession();
		//create Criteria
		criteria=ses.createCriteria(University.class);
		//execute QBC
		list=criteria.list();
		//process list
		for(University university:list){
			System.out.println("Parent ---->"+university);
			childs=university.getColleges();
			for(College clg:childs){
				System.out.println("child ---->"+clg);
			}//for
		}//for
		
	}//method
	
	public void deleteDataUsingUniversity() {
		Session ses=null;
		University university=null;
		Set<College> childs=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load Parent object
		university=ses.get(University.class,1);
		//get all childs of a parent
		childs=university.getColleges();
		//delete parent
		try{
			tx=ses.beginTransaction();
			  ses.delete(university);
			 tx.commit();
			 System.out.println(" parent and associated childs objs are deleted");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	public void deleteCollegesOfUniversity() {
		Session ses=null;
		University university=null;
		Set<College> childs=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load Parent object
		university=ses.get(University.class,2);
		//get all childs of a parent
		childs=university.getColleges();
		//delete childs
		try{
			tx=ses.beginTransaction();
			  childs.removeAll(childs);
			 tx.commit();
			 System.out.println(" parent and associated childs objs are deleted");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}
	
}//class
