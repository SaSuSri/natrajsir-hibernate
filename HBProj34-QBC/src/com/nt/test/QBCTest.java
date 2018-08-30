package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class QBCTest {

	public static void main(String[] args) {
		Session ses=null;
		Criteria criteria=null;
		//	List<EmpDetails> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		//write QBC logic
		/*   //prepare  Criteria object
		  criteria=ses.createCriteria(EmpDetails.class);
		  //execute logics
		  list=criteria.list();
		  //process the Results
		  for(EmpDetails ed:list){
			  System.out.println(ed);
		  }//for
*/		  
		/*//QBC logic with condition
		 criteria=ses.createCriteria(EmpDetails.class);
		 //prepare and add condition 
		 Criterion cond=Restrictions.between("no",1000,1300);
		 criteria.add(cond);
		 //execute QBC logic & process results
		 List<EmpDetails> list=criteria.list();
		 for(EmpDetails ed:list){
			 System.out.println(ed);
		 }*/
		 
	/*	//QBC logic with multiple conditions
		 criteria=ses.createCriteria(EmpDetails.class);
		 //prepare conditions
		 Criterion cond1=Restrictions.ge("no",1000);
		 Criterion cond2=Restrictions.le("no",1300);
		 Criterion cond3=Restrictions.ilike("mail","%gmail.com");
		 //prepare and condition
		 Criterion andCond=Restrictions.and(cond1,cond2);
		 //prepre or condition
		 Criterion orCond=Restrictions.or(andCond, cond3);
		 //Add final condition to Criteria object
		 criteria.add(orCond);
		 //execute QBC logic
		 List<EmpDetails> list=criteria.list();
		 //process the results
		 for(EmpDetails ed:list){
			 System.out.println(ed);
		 }
		 */
		
	/*	//prepare QBc logic with conditions and Order clauses
		 criteria=ses.createCriteria(EmpDetails.class);
	   //prepare condition
		 Criterion cond=Restrictions.in("lname",new String[]{"rao","chari"});
		 //add condition
		 criteria.add(cond);
		 //prepare Order
		 Order order=Order.desc("lname");
		 //add Order
		 criteria.addOrder(order);
		 //execute QBC logic
		 List<EmpDetails> list=criteria.list();
		 for(EmpDetails ed:list){
			 System.out.println(ed);
		 }
		 */
	
		//prepare QBC logic with SQL condition based Criterion objs
		criteria=ses.createCriteria(EmpDetails.class);
		//prepare cond
		Criterion cond=Restrictions.sqlRestriction(" email like '%x.com'");
		//add cond
		criteria.add(cond);
		//execute QBC logic
		List<EmpDetails> list=criteria.list();
		//process the results
		for(EmpDetails ed:list){
			System.out.println(ed);
		}
		 
		
		 
		 
		 
		
		
		 
		
		  //close Hibernate objects
		  HibernateUtil.closeSession();
		  HibernateUtil.closeSessionFactory();
	}//main
}//class
