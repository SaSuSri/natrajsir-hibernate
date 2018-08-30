package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nt.bo.StudentBO;
import com.nt.util.HibernateUtil;

public class SRDAOImpl implements SRDAO {

	@Override
	public int insert(StudentBO bo) {
	   Session session=null;
	   Transaction tx=null;
	   int idVal=0;
		//get HB Session
	   session=HibernateUtil.getSession();
	   //save obj
	   try{
		  tx=session.beginTransaction();
		     idVal=(Integer)session.save(bo);
		   tx.commit();
		   return idVal;
	   }
	   catch(Exception se){
		   tx.rollback();
		   return 0;
	   }
	}//insert(-)
}//class
