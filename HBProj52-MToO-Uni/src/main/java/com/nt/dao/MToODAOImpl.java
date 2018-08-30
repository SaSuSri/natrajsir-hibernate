package com.nt.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Department;
import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class MToODAOImpl implements MToODAO {

	@Override
	public void saveDataUsingChilds() {
		  Session ses=null;
		  Department dept=null;
		  EmpDetails emp1=null,emp2=null;
		  Transaction tx=null;
		//get Session
		  ses=HibernateUtil.getSession();
		  //prepare parent,child objs
		   //parent object
		  dept=new Department();
		  dept.setDeptNo(1001); 
		  dept.setDeptName("Accounts");
		  dept.setDeptHead("SMITH");
		  //child objs
		  emp1=new EmpDetails();
		  emp1.setEno(101);
		  emp1.setEname("raja");
		  emp1.setSalary(9000);
		  
		  emp2=new EmpDetails();
		  emp2.setEno(102);
		  emp2.setEname("ravi");
		  emp2.setSalary(8000);
		  //Assign parent obj to child objs (Many to one)
		  emp1.setDept(dept); emp2.setDept(dept);
		  try{
			  tx=ses.beginTransaction();
			   ses.save(emp1); ses.save(emp2);
			  tx.commit();
			  System.out.println("Child objs are saved...");
		  }//try
		  catch(Exception e){
			  tx.rollback();
		  }
	}//method

	@Override
	public void loadDataUsingChilds() {
		 Session ses=null;
		 Query query=null;
		 List<EmpDetails> list=null;
		 Department dept=null;
		//get Session
		 ses=HibernateUtil.getSession();
		 //load child objs
		 query=ses.createQuery("from EmpDetails");
		 list=query.list();
		 //process the results
		 for(EmpDetails ed:list){
			 System.out.println("child---->"+ed);
			 //get Associated parent
			 dept=ed.getDept();
			 System.out.println("parent--->"+dept);
		 }//for
	}//method
	
	@Override
	public void deleteDataUsingChilds() {
		Session ses=null;
		Transaction tx=null;
		Query query=null;
		List<EmpDetails> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load  child objs
		query=ses.createQuery("from EmpDetails");
		list=query.list();
		//delete child objs
		
		try{
		 tx=ses.beginTransaction();
		  for(EmpDetails ed:list){
		     ses.delete(ed);
		  }
		  tx.commit();
		 System.out.println("Delete child objs and its associated parent objs");
		}
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
  }//method
	
	@Override
	public void deleteOneChildOfAParent() {
		
	/*  Bad Code
	 	Session ses=null;
		Transaction tx=null;
		EmpDetails ed=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load the child obj
		ed=ses.get(EmpDetails.class,101);
		//delete the child obj
		try{
			tx=ses.beginTransaction();
			 ses.delete(ed);
			tx.commit();
			System.out.println("Deleting child obj with out deleting parent object");
		}//try
		catch(Exception e){
			tx.rollback();
		}*/
		//Good code
		Session ses=null;
		Transaction tx=null;
		Query query=null;
		int result=0;
		//get Session
		ses=HibernateUtil.getSession();
		//execute HQL delete Query
		query=ses.createQuery("delete from EmpDetails where salary=:bsal");
		query.setDouble("bsal",8000);
		try{
			tx=ses.beginTransaction();
			  result=query.executeUpdate();
			tx.commit();
			System.out.println("Deleteing only child even though cascade='all' ");
		}  //try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	@Override
	public void addNewChildToExistingParent() {
		Session ses=null;
		Transaction tx=null;
		Department dept=null;
		EmpDetails details=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load existing parent
        dept=ses.get(Department.class,1001);
        //create new child
        details=new EmpDetails();
        details.setEno(200);
        details.setEname("sameer");
        details.setSalary(9000);
        details.setDept(dept);
        try{
        	tx=ses.beginTransaction();
        	 ses.save(details);
        	tx.commit();
        	System.out.println("adding new child obj to Existing parent ");
        }//try
        catch(Exception e){
        	tx.rollback();
        }
	}//method
	
	@Override
	public void addExistingChildToNewDepartment() {
		 Session ses=null;
		 EmpDetails ed=null;
		 Department dept=null;
		 Transaction tx=null;
		// get Session
		 ses=HibernateUtil.getSession();
		//load existing child
		 ed=ses.get(EmpDetails.class,200);
		 //create new Parent 
		 dept=new Department();
		 dept.setDeptNo(890); dept.setDeptName("Sales"); dept.setDeptHead("JAMES");
		 //add new Dept to existing child
		 try{
			 tx=ses.beginTransaction();
			    ed.setDept(dept);
			 tx.commit();
			 System.out.println("Department is changed ");
		 }//try
		 catch(Exception se){
			 tx.rollback();
		 }
	}//method
	
	@Override
	public void deleteAllChildsOfAParent() {
		 Session ses=null;
		 Transaction tx=null;
		 Query query=null;
		 int result=0;
		// get Session
		 ses=HibernateUtil.getSession();
		 //create Query
		 query=ses.createQuery("delete from EmpDetails where dept.deptNo=:dno");
		 query.setInteger("dno",1001);
		 try{
			 tx=ses.beginTransaction();
			   result=query.executeUpdate();
			 tx.commit();
			 System.out.println(result+" no.of records are deleted");
		 }//try
		 catch(Exception e){
			 tx.rollback();
		 }
	}//method
	
}//class
