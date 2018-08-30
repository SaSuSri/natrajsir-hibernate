package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class HQLTest {

	public static void main(String[] args) {
	   Session ses=null;
	   Query query=null;
	   List<EmpDetails> list=null;
	   List<Object[]> list1=null;
	   List<String>  list2=null;
		//get Session
	   ses=HibernateUtil.getSession();
	   //prepare HQL Query
	/*   query=ses.createQuery("select ed from EmpDetails ed");
	   //execute HQL 
	   list=query.list();
	  //process the Result
	   for(EmpDetails ed:list){
		   System.out.println(ed);
	   }*/
	   
/*	   //prepare HQL Select Query with positional params(?)
	   query=ses.createQuery(" from EmpDetails  where no>=? and no<=?");
	   //set param values 
	   query.setInteger(0,1000);
	   query.setInteger(1, 3000);
	   //execute HQL 
	   list=query.list();
	   //process ResultSet
	   for(EmpDetails ed:list){
		   System.out.println(ed);
	   }*/
	   
	   /*//prepare HQL select query with named params
	   query=ses.createQuery("from EmpDetails where  mail like :domain");
	   //set values to named params
	   query.setString("domain","%gmail.com");
	   //execute the Query
	   list=query.list();
	   //process the results
	   for(EmpDetails ed:list){
		   System.out.println(ed);
	   }*/
	   
	/* //prepare HQL select query with jpa style positional params
	   query=ses.createQuery("from EmpDetails where  mail like ?1");
	   //set values to named params
	   query.setString("1","%gmail.com");
	   //execute the Query
	   list=query.list();
	   //process the results
	   for(EmpDetails ed:list){
		   System.out.println(ed);
	   }*/
	   
	  /* //prepare HQL Query with both named positional params
	   query=ses.createQuery("from EmpDetails where lname in(?,?,:community)");
	   //set param values
	   query.setString(0,"rao");
	   query.setString(1,"chari");
	   query.setString("community","ravana");
	   //execute the Query
	   list=query.list();
	   //process the ResultSet
	   for(EmpDetails ed:list){
		   System.out.println(ed);
	   }*/
	   
	/*   //prepare HQL with sub queries
	    query=ses.createQuery("from EmpDetails where no=(select max(no) from EmpDetails)");
	    //execute HQL
	    list=query.list();
	    //process the result
	    for(EmpDetails ed:list){
	    	System.out.println(ed);
	    }*/
	   
	  /* //execute HQL using iterate() method
	    query=ses.createQuery("from EmpDetails");
	    Iterator<EmpDetails> it=query.iterate();
	   while(it.hasNext()){
	    	EmpDetails details=it.next();
	    	System.out.println(details);
	    }
	   */
	
	 /*  //prepare HQL Query (specific multiple col values)
	   query=
	 	   ses.createQuery("select no,mail from EmpDetails where mail like :domain");
	   //set param value
	   query.setString("domain","%gmail.com");
	   //execute HQL Query
	   list1=query.list();
	   //process the Result
	   for(Object[] row:list1){  //To iterate through List
		   for(Object val:row){  // To iterate through Object[]
			   System.out.print(val+" ");
		   }//for
		   System.out.println();
	   }//for
*/	   
	   //Getting Specific single col value
	   /*//prepare HQL Query
	   query=ses.createQuery("select mail from EmpDetails");
	   //execute HQL
	    list2=query.list();
	    //process result
	    for(String email:list2){
	    	System.out.println(email);
	    }//for
*/	   
	/*   //Executing HQL Aggragate function based select query
	   query=ses.createQuery("select count(*) from EmpDetails");
	   //execute HQL
	   List <Long> listCount=query.list();
	   long count=listCount.get(0);
	   System.out.println("Records count:"+count);*/
	   
	/*   //parepare HQL query(non-select Query)
	   query=ses.createQuery("delete from EmpDetails where mail like :domain");
	   //set param values
	   query.setString("domain","%gmail.com");
	   //execute HQL
	   Transaction tx=null;
	   try{
		   tx=ses.beginTransaction();
		     int result=query.executeUpdate();
		    tx.commit();
		    System.out.println("no.of records that are effected"+result);
	   }//try
	   catch(Exception e){
		   tx.rollback();
	   }*/
	   
	   //get Access to Named HQL Query
	   query=ses.getNamedQuery("GET_EMPDETALS_BY_EID_RANGE");
	   //set param values
	   query.setInteger("min",1100);
	   query.setInteger("max",1200);
	   //execute HQL
	   list=query.list();
	   for(EmpDetails ed:list){
		   System.out.println(ed);
	   }
	   
	   
	   
	   
	   //close objs
	   HibernateUtil.closeSession();
	   HibernateUtil.closeSessionFactory();
	}
}
