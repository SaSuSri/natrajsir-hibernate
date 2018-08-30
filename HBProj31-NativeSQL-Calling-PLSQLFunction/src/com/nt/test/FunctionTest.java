package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class FunctionTest {

	public static void main(String[] args) {
		Session ses=null;
		//get Session
		ses=HibernateUtil.getSession();
		
		 Query query=ses.getNamedQuery("CALL_FX");
		    query.setInteger(0,1000);
		    query.setInteger(1,2000);
		    query.setFirstResult(1);
		    query.setMaxResults(2);
		    List<EmpDetails> list=query.list();  
		     for(EmpDetails ed:list){                  
		        System.out.println(ed);
		       }
      //close objs
		     HibernateUtil.closeSession();
		     HibernateUtil.closeSessionFactory();
	}//main
}//class
