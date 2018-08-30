package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Customer;
import com.nt.domain.Employee;
import com.nt.domain.Person;
import com.nt.utility.HibernateUtil;

public class InhMappingInsertTest {

	public static void main(String[] args) {
		Session ses=null;
		Person person=null;
		Employee emp=null;
		Customer cust=null;
		Transaction tx=null;
		// Get Session
		ses=HibernateUtil.getSession();
		//save objects
		//Using Person 
		person =new Person();
		person.setId(1001);
		person.setName("raja");
		person.setCompany("HCL");
		//Using Employee
		emp=new Employee();
		emp.setId(1002);
		emp.setName("ramesh");
		emp.setCompany("HCL");
		emp.setDepartment(9001);
		emp.setSalary(9000);
		//Using Customer
		cust=new Customer();
		cust.setId(8901);
		cust.setName("ramesh");
		cust.setCompany("Wipro");
		cust.setAddress("hyd");
		try{
			tx=ses.beginTransaction();
			  ses.save(person);
			  ses.save(emp);
			  ses.save(cust);
			tx.commit();
			System.out.println("Objects are saved");
		}//try
		catch(Exception e){
			tx.rollback();
		}
		//close objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
