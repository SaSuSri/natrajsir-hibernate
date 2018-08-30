package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.cid.Programmer_ProjectId;
import com.nt.domain.Programmers_Projects;
import com.nt.utility.HibernateUtil;

public class Programmers_ProjectsDAOImpl implements Programmers_ProjectsDAO {

	@Override
	public void saveData() {
		Session session=null;
		Programmer_ProjectId id=null,genIdVal=null;
		Programmers_Projects domain=null;
		Transaction tx=null;
		//get Session
		session=HibernateUtil.getSession();
		 //Id obj
		 id=new Programmer_ProjectId();
		 id.setProj_id(1001); id.setPrgmr_id(101);
		//prepare Domain Object
		 domain=new Programmers_Projects();
		 domain.setId(id);
		 domain.setPrgmr_name("raja");
		 domain.setProj_name("proj1");
		 //save object
		 try{
			 tx=session.beginTransaction();
			   genIdVal=(Programmer_ProjectId) session.save(domain);
			   System.out.println("Generated Id value"+genIdVal);
			 tx.commit();
		 }//try
		 catch(Exception e){
			 tx.rollback();
		 }
		 System.out.println("Object is saved");
	}//saveData()
	
	@Override
	public Programmers_Projects loadData() {
		Session session=null;
		Programmer_ProjectId id=null;
		Programmers_Projects domain=null;
	     //get Session
		session=HibernateUtil.getSession();
		 //prepre Id class object
		id=new Programmer_ProjectId();
		id.setProj_id(1001); id.setPrgmr_id(101);
		//load object.
		domain=session.get(Programmers_Projects.class,id);
	  return domain;
	}//method
}//class
