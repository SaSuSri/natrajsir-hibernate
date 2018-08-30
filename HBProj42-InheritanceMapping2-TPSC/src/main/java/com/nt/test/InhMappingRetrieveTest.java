package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.domain.Customer;
import com.nt.domain.Employee;
import com.nt.domain.Person;
import com.nt.utility.HibernateUtil;

public class InhMappingRetrieveTest {

	public static void main(String[] args) {
		Session ses=null;
		List<Person> list1=null;
		List<Employee> list2=null;
		List<Customer> list3=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		//using Person
		query=ses.createQuery("from Person");
		list1=query.list();
		for(Person per:list1){
			System.out.println(per);
		}
		System.out.println("............................................");
		query=ses.createQuery("from Employee");
		list2=query.list();
		for(Employee emp:list2){
			System.out.println(emp);
		}
		System.out.println("............................................");
		query=ses.createQuery("from Customer");
		list3=query.list();
		for(Customer cust:list3){
			System.out.println(cust);
		}
		
		//close objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
