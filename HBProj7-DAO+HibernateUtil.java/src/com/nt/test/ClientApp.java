package com.nt.test;

import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOFactory;
import com.nt.domain.EmpDetails;
import com.nt.util.HibernateUtil;

public class ClientApp {
	public static void main(String[] args) {
		EmployeeDAO dao=null;
		EmpDetails details=null;
		//get DAO
		dao=EmployeeDAOFactory.getInstance();
		//save object
		 //dao.insertEmployee(1050,"Raja","rao","rao@gmail.com");
		 //load object
		System.out.println("1050 emp details"+dao.getEmployeeByNo(1050));
		//update object
		dao.changeEmailIdByNo(1050, "ravana@lanka.com");
		 //load object
		System.out.println("1050 emp details"+dao.getEmployeeByNo(1050));
		
		 //close objs
		 HibernateUtil.closeSession();
		 HibernateUtil.closeSessionFactory();
	}//main
}//class
