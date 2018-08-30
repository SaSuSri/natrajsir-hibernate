package com.nt.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.LibraryMembership;
import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class OToODAOImpl implements OToODAO {

	public void saveDataUsingStudent() {
		Session ses=null;
		Student  raja=null;
		LibraryMembership rajaLib=null;
		Transaction tx=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//prepare parent and child objs
		raja=new Student();
		raja.setName("maha raja");
		raja.setAddress("mysore");
		
		rajaLib=new LibraryMembership();
		rajaLib.setDoj(new Date(110,10,20));
		//map parent to child and child to parent
		raja.setLibraryDetails(rajaLib);
		rajaLib.setStudentDetails(raja);
		try{
			tx=ses.beginTransaction();
			  ses.save(raja); 
			 tx.commit();
			 System.out.println("Objects are saved");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	public void saveDataUsingLibraryMembership() {
		Session ses=null;
		Student  ravi=null;
		LibraryMembership raviLib=null;
		Transaction tx=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//prepare parent and child objs
		ravi=new Student();
		ravi.setName("ravi kiran");
		ravi.setAddress("ameerpet");
		
		raviLib=new LibraryMembership();
		raviLib.setDoj(new Date(112,10,20));
		//map parent to child and child to parent
		ravi.setLibraryDetails(raviLib);
		raviLib.setStudentDetails(ravi);
		try{
			tx=ses.beginTransaction();
			  ses.save(raviLib); 
			 tx.commit();
			 System.out.println("Objects are saved");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	public void loadDataUsingStudent() {
		Session ses=null;
		List<Student> list=null;
		LibraryMembership lib=null;
		Query query=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//load all parents
		query=ses.createQuery("from Student");
		list=query.list();
		//display data
		for(Student st:list){
			System.out.println("parent-->"+st);
			//get child of each parent
			lib=st.getLibraryDetails();
			System.out.println("Child ---->"+lib);
		}//for
	}//for
	
	public void loadDataUsingLibraryMembership() {
		Session ses=null;
		Query query=null;
		List<LibraryMembership> list=null;
		Student stud=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//load all childs
		query=ses.createQuery("from LibraryMembership");
		 list=query.list();
		 //display data
		 for(LibraryMembership lib:list){
			 System.out.println("child--->"+lib);
			 stud=lib.getStudentDetails();
			 System.out.println("Parent--->"+stud);
		 }//for
	}//method
	
	public void delteDataUsingStudent() {
		Session ses=null;
		Student stud=null;
		Transaction tx=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//load Parent obj
		stud=ses.get(Student.class,1);
		//delete parent obj
		try{
			tx=ses.beginTransaction();
			   ses.delete(stud);
			tx.commit();
			System.out.println("Object is deleted");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	public void delteDataUsingLibraryMembership() {
		Session ses=null;
		LibraryMembership lib=null;
		Transaction tx=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//Load child object
		lib=ses.get(LibraryMembership.class,3);
		//delete child obj
		try{
			tx=ses.beginTransaction();
			  ses.delete(lib);
			tx.commit();
			System.out.println("object deleted");
		}//try
		catch(Exception e){
			tx.rollback();
		}//catch
	}//method
	
	public void deleteLibraryMembershipOfAStudent() {
		Session ses=null;
		Transaction tx=null;
		Query query=null;
		int result=0;
		//Get Session
		ses=HibernateUtil.getSession();
		query=ses.createQuery("delete from LibraryMembership where lid=:id");
		query.setParameter("id",2);
		//execute Query
	    try{
	    	tx=ses.beginTransaction();
	          result=query.executeUpdate();
	        tx.commit();
	        System.out.println("No.of records that are effected:"+result);
	    }//try
	    catch(Exception e){
           tx.rollback();
	    }
	}//method
	
}//class
