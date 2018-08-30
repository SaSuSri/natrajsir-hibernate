package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.College;
import com.nt.domain.University;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO{
	
	public void saveDataUsingUniversity() {
		Session ses=null;
		University university=null;
		College college1=null,college2=null;
		List<College> childs=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare parent ,child objs
		university=new University();
		university.setName("JNTUH");
		university.setRegion("Telgana");
		
		college1=new College();
		college1.setName("CBIET");
		college1.setLocation("GandiPet-hyd");
		
		college2=new College();
		college2.setName("MREC");
		college2.setLocation("kompally-hyd");
		
		childs=new ArrayList<College>();
		childs.add(college1);
		childs.add(college2);
		//set childs to parent
		university.setColleges(childs);
		try{
			tx=ses.beginTransaction();
			  ses.save(university);
			tx.commit();
			System.out.println("Parent objs and associated child objs are saved");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
}//class
