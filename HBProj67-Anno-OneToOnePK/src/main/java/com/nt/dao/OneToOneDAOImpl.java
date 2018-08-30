package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.FacebookAccount;
import com.nt.domain.UberAccount;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {
      
	public void saveDataUsingFaceBookAccount() {
		Session ses=null;
		FacebookAccount fbAccount=null;
		UberAccount uberAccount=null;
		Transaction tx=null;
		 //get Session
		ses=HibernateUtil.getSession();
		//create objects
		fbAccount=new FacebookAccount();
		fbAccount.setFbId("raja@gmail.com");
		fbAccount.setName("raja");
		fbAccount.setFollowers(40000);
		
		uberAccount=new UberAccount();
		uberAccount.setName("raja");
		uberAccount.setMobileNo(9999999);
		
		//map child to parent and parent to child
		uberAccount.setFacebookDetails(fbAccount);
		fbAccount.setUberDetails(uberAccount);
		//save objects
		try{
			tx=ses.beginTransaction();
			  ses.save(fbAccount);
			  tx.commit();
			  System.out.println("Parent to child obj saved");
		}catch(Exception e){
			tx.rollback();
		}

	}//method

	public void saveDataUsingUberAccount() {
		Session ses=null;
		FacebookAccount fbAccount=null;
		UberAccount uberAccount=null;
		Transaction tx=null;
		 //get Session
		ses=HibernateUtil.getSession();
		//create objects
		fbAccount=new FacebookAccount();
		fbAccount.setFbId("rani@gmail.com");
		fbAccount.setName("rani");
		fbAccount.setFollowers(100000);
		
		uberAccount=new UberAccount();
		uberAccount.setName("rani");
		uberAccount.setMobileNo(00000001);
		
		//map child to parent and parent to child
		uberAccount.setFacebookDetails(fbAccount);
		fbAccount.setUberDetails(uberAccount);
		//save objects
		try{
			tx=ses.beginTransaction();
			  ses.save(uberAccount);
			  tx.commit();
			  System.out.println("Child to Parent obj is saved");
		}catch(Exception e){
			tx.rollback();
		}
	}//method
}//class
