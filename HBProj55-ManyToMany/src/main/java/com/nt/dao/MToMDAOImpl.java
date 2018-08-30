package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Programmer;
import com.nt.domain.Project;
import com.nt.utility.HibernateUtil;

public class MToMDAOImpl implements MToMDAO {

	public void saveDataUsingParents() {
		Session ses = null;
		Programmer prgmr1 = null, prgmr2 = null, prgmr3 = null;
		Project proj1 = null, proj2 = null;
		Transaction tx = null;
		// Get Session
		ses = HibernateUtil.getSession();
		// prepare parent objs
		prgmr1 = new Programmer();
		prgmr1.setPid(101);
		prgmr1.setPname("raja");
		prgmr1.setSalary(4000);
		prgmr2 = new Programmer();
		prgmr2.setPid(102);
		prgmr2.setPname("ravi");
		prgmr2.setSalary(7000);
		prgmr3 = new Programmer();
		prgmr3.setPid(103);
		prgmr3.setPname("karan");
		prgmr3.setSalary(8000);
		// prepare child objs
		proj1 = new Project();
		proj1.setProid(1001);
		proj1.setProname("proj1");

		proj2 = new Project();
		proj2.setProid(1002);
		proj2.setProname("Proj2");
		// map childs to parents
		prgmr1.getProjects().add(proj1);
		prgmr1.getProjects().add(proj2);

		prgmr2.getProjects().add(proj1);

		prgmr3.getProjects().add(proj1);
		prgmr3.getProjects().add(proj2);
		// map parent to childs
		proj1.getProgrammers().add(prgmr1);
		proj1.getProgrammers().add(prgmr2);
		proj1.getProgrammers().add(prgmr3);

		proj2.getProgrammers().add(prgmr1);
		proj2.getProgrammers().add(prgmr3);
		// save objs (parent to childs)
		try {
			tx = ses.beginTransaction();
			ses.save(prgmr1);
			ses.save(prgmr2);
			ses.save(prgmr3);
			tx.commit();
		} // try
		catch (Exception e) {
			tx.rollback();
		}
	}// saveDataUsingParent

	public void saveDataUsingChilds() {
		Session ses = null;
		Programmer prgmr1 = null, prgmr2 = null, prgmr3 = null;
		Project proj1 = null, proj2 = null;
		Transaction tx = null;
		// Get Session
		ses = HibernateUtil.getSession();
		// prepare parent objs
		prgmr1 = new Programmer();
		prgmr1.setPid(104);
		prgmr1.setPname("jani");
		prgmr1.setSalary(4000);
		prgmr2 = new Programmer();
		prgmr2.setPid(105);
		prgmr2.setPname("sameer");
		prgmr2.setSalary(7000);
		prgmr3 = new Programmer();
		prgmr3.setPid(106);
		prgmr3.setPname("albert");
		prgmr3.setSalary(8000);
		// prepare child objs
		proj1 = new Project();
		proj1.setProid(1003);
		proj1.setProname("proj3");

		proj2 = new Project();
		proj2.setProid(1004);
		proj2.setProname("Proj4");
		// map childs to parents
		prgmr1.getProjects().add(proj1);
		prgmr1.getProjects().add(proj2);

		prgmr2.getProjects().add(proj1);

		prgmr3.getProjects().add(proj1);
		prgmr3.getProjects().add(proj2);
		// map parent to childs
		proj1.getProgrammers().add(prgmr1);
		proj1.getProgrammers().add(prgmr2);
		proj1.getProgrammers().add(prgmr3);

		proj2.getProgrammers().add(prgmr1);
		proj2.getProgrammers().add(prgmr3);
		// save objs (parent to childs)
		try {
			tx = ses.beginTransaction();
			ses.save(proj1);
			ses.save(proj2);
			tx.commit();
		} // try
		catch (Exception e) {
			tx.rollback();
		}
	}//method
	
	public void addNewParentToExistringChild() {
		Session ses = null;
		Transaction tx = null;
		Project proj1=null;
		Programmer new_prgmr=null;
		Set<Programmer>parents=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load existing child
		proj1=ses.get(Project.class,1001);
		//create new Parent 
		new_prgmr=new Programmer();
		new_prgmr.setPid(110); new_prgmr.setPname("chota bheam"); new_prgmr.setSalary(8000);
		//get all parents of Loaded child
		parents=proj1.getProgrammers();
		try{
			tx=ses.beginTransaction();
			//add new parent to existing parents of a child
			  parents.add(new_prgmr);
			  tx.commit();
			  System.out.println("Adding new Parent to existing childs");
		}//try
		catch(Exception e){
		  tx.rollback();
		}
	}//method
	
	public void changeExistingProgrammerToAnotherExistingProject() {
		Session ses = null;
		Transaction tx = null;
		Project proj=null,proj1=null;
		Programmer prgmr=null;
		Set<Programmer>prgmrs=null,prgmrs1=null;
		//get Session
				ses=HibernateUtil.getSession();
         //load existing Programmer (parent)
		prgmr=ses.get(Programmer.class,110);
		//load  Project where programmer is current working
           proj=ses.get(Project.class,1001);
         //get All programmers of above project
        prgmrs=proj.getProgrammers();
        //load project where programmer wants to move
        proj1=ses.get(Project.class, 1003);
      //load all programmers of above project
        prgmrs1=proj1.getProgrammers();
        //add programmer 1003 project and remove from 1001
        try{
        	tx=ses.beginTransaction();
        	prgmrs1.add(prgmr);  
        	prgmrs.remove(prgmr);
        	tx.commit();
        	System.out.println("programmer is moved from 1 project to another project");
        }//try
        catch(Exception e){
        	e.printStackTrace();
        	tx.rollback();
        }
	}//method
	
	public void loadObjectsUsingParents() {
		Session ses = null;
		List<Programmer> list=null;
		Set<Project> projs=null;
		Query query=null;
		//get Session
				ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from Programmer");
		//excute Query
		list=query.list();
		for(Programmer prgmr:list){
			System.out.println("parent--->"+prgmr);
			//get childs of each parent
			projs=prgmr.getProjects();
			for(Project proj:projs){
				System.out.println("child---->"+proj);
			}//for
		}//for
	}//method
	
}// class
