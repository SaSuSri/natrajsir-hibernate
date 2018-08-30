package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class FilterTest {
	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
		Query query=null;
		List<EmpDetails> list=null;
		List<Object> list1=null;
		Criteria criteria=null;
		SQLQuery SQLquery=null;
		//get Session
		ses=HibernateUtil.getSession();
		//enable filter and set parameter values
		   filter=ses.enableFilter("EMPS_BY_RANGE");
		   filter.setParameter("min",1000);
		   filter.setParameter("max",2000);
		 //execute NativeSQL logics
		   SQLquery=ses.createSQLQuery("select * from Employee");
		   SQLquery.addEntity(EmpDetails.class);
		   list=SQLquery.list();
		   for(EmpDetails ed:list){
			   System.out.println(ed);
		   }
		   
		   
  /*      //execute QBC logics
		   criteria=ses.createCriteria(EmpDetails.class);
		   list=criteria.list();
		   for(EmpDetails ed:list){
			   System.out.println(ed);
		   }*/
		   
		   
/*		  //execute logics (HQL)
		 query=ses.createQuery("from EmpDetails");
		 list=query.list();
		 for(EmpDetails ed:list){
			 System.out.println(ed);
		 }
		 
		 //disable filter
		 ses.disableFilter("EMPS_BY_RANGE");
		 query=ses.createQuery("select count(*) from EmpDetails");
		 list1=query.list();
		 System.out.println("Records count:::"+list1.get(0));
*/		 
		 //close objs
		 HibernateUtil.closeSession();
		 HibernateUtil.closeSessionFactory();
		
	}

}
