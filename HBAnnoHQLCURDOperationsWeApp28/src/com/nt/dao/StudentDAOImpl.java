package com.nt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.bo.StudentBO;
import com.nt.utility.HibernateUtil;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public List<StudentBO> getAllStudents() {
		Session ses=null;
		Query query=null;
		List<StudentBO> listBO=null;
		//get Session
		ses=HibernateUtil.getSession();
		//get Access to Named HQL Query
		query=ses.getNamedQuery("GET_ALL_STUDENTS");
		//execute HQL
		listBO=query.list();
		return listBO;
	}//method
	
	@Override
	public StudentBO getStudentByNo(int no) {
		Session ses=null;
		StudentBO bo=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load object 
		bo=ses.load(StudentBO.class,no);
		return bo;
	}//getStudentByNo(-)
	
	@Override
	public int updateStudent(StudentBO bo) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		int result=0;
		//get Session
		ses=HibernateUtil.getSession();
		//update record
		//access named Query
		query=ses.getNamedQuery("UPDATE_STUDENT_BY_NO");
		//set param vlaues
		query.setString("newName",bo.getSname());
		query.setString("newAddrs",bo.getSadd());
		query.setInteger("no",bo.getSno());
		//execute the Query
		try{
			tx=ses.beginTransaction();
			  result=query.executeUpdate();
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}//method
}//class
