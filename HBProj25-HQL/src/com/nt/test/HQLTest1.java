package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class HQLTest1 {

	public static void main(String[] args) {
	   Session ses=null;
	   Query query=null;
	   List<EmpDetails> list=null;
	   List<Object[]> list1=null;
	   List<String>  list2=null;
		//get Session
	   ses=HibernateUtil.getSession();
	 /*  //get Access to Named HQL Query
	   query=ses.getNamedQuery("GET_EMPDETALS_BY_EID_RANGE");
	   //set param values
	   query.setInteger("min",1000);
	   query.setInteger("max",1100);
	   //execute HQL
	   list=query.list();
	   for(EmpDetails ed:list){
		   System.out.println(ed);
	   }*/
	   
	   query=ses.createQuery(" select no,mail from EmpDetails");
	   Iterator<Object[]> it=query.iterate();
	   while(it.hasNext()){
		   Object row[]=it.next();
		   for(Object val:row){
			   System.out.print(val+" ");
		   }//for
		   System.out.println();
	   }//while
	   
	   //close objs
	   HibernateUtil.closeSession();
	   HibernateUtil.closeSessionFactory();
	}
}
