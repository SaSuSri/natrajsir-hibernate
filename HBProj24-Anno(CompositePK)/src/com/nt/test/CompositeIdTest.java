package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.StudentGame;
import com.nt.domain.StudentGamePK;
import com.nt.utility.HibernateUtil;

public class CompositeIdTest {

	public static void main(String[] args) {
		Session ses=null;
		StudentGamePK id=null;
		StudentGame studGame=null;
	   //get Session
		ses=HibernateUtil.getSession();
		//prepare Domain class obj
		id=new StudentGamePK();
		id.setStno(11); id.setGameNo(1001);
		
		studGame=new StudentGame();
		studGame.setId(id); studGame.setSname("Raja");
		studGame.setGameName("cricket");
		//save object
		Transaction tx=null;
		try{
			tx=ses.beginTransaction();
			  ses.save(studGame);
			tx.commit();
			System.out.println("object is saved");
		}//try
		catch(Exception e){
			tx.rollback();
		}
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
