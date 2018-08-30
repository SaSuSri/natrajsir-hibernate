package com.nt.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import com.nt.util.HibernateUtil;

public class ProcedureTestUsingReturningWorkCallaback {
	
   public static void main(String[] args) {
	   Session ses=null;
	   String result=null;
	   //get Session 
	   ses=HibernateUtil.getSession();
	   //call pl/sql Procedure of Oracle Db s/w ReturningWorkCallback(I)
	   result=ses.doReturningWork(new ReturningWork<String>() {
		   
		   @Override
		public String execute(Connection con) throws SQLException {
			CallableStatement cs=null;
			String result=null;
			   //create CallableStatement object
			 cs=con.prepareCall("{call P_AUTHENTICATE(?,?,?)}");
			 //register OUT params with  JDBC types
			 cs.registerOutParameter(3,Types.VARCHAR);
			 //set values to IN params
			 cs.setString(1,"jani"); 
			 cs.setString(2,"begum");
			 //execute PL/SQL procedure
			 cs.execute();
			 //gather result from OUT param
			 result=cs.getString(3);
           return result;			 
		}//execute(-)
	  }//inner class
   );//method call
	   System.out.println("Result:::"+result);
	   //close objs
	   HibernateUtil.closeSession();
	   HibernateUtil.closeSessionFactory();
  }//main
}//class
