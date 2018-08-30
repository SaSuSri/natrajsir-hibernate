package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.DrawNumber;
import com.nt.utility.HibernateUtil;

public class LuckyDrawDAOImpl implements LuckyDrawDAO {

	@Override
	public int generateDrawNumber(String drawee_name) {
		DrawNumber  dn=null;
		Session session=null;
		Transaction tx=null;
		int idValue=0;
	   //prepare domain class obj
		dn=new DrawNumber();
		dn.setDrawee_name(drawee_name);
		//get Session
		session=HibernateUtil.getSession();
		 try{
			 tx=session.beginTransaction();
			 idValue=(Integer)session.save(dn);
			 System.out.println("Generated idValue:::"+idValue);
			 tx.commit();
			 return idValue;
		 }//try
		 catch(Exception e){
           tx.rollback();
           return 0;
		 }
	}//method
}//clas
