package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.MySqlHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class TransferDAOImpl implements TransferDAO {

	@Override
	public void transferEmloyee(int empId) {
		Session oracleSession=null;
		Session mysqlSession=null;
		EmpDetails details=null;
		Transaction tx=null;
		 //get Session objs
		oracleSession=OracleHibernateUtil.getSession();
		mysqlSession=MySqlHibernateUtil.getSession();
		//Load obj from MySql
		details=mysqlSession.get(EmpDetails.class,empId);
		//save obj to Oracle
		 try{
			tx=oracleSession.beginTransaction();
			  oracleSession.save(details);
			tx.commit();
			System.out.println("Object/record is trnasfered");
		 }//try
		 catch(Exception e){
			 tx.rollback();
			 System.out.println("Object/record is not trnasfered");
		 }//catch(-)
	}//method
}//class
