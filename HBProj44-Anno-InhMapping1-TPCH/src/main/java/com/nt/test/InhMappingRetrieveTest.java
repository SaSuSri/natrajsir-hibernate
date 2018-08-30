package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.ChequePayment;
import com.nt.domain.CreditCardPayment;
import com.nt.domain.Payment;
import com.nt.utility.HibernateUtil;

public class InhMappingRetrieveTest {

	public static void main(String[] args) {
		Session ses=null;
		List<Payment> list1=null;
		List<CreditCardPayment> list2=null;
		List<ChequePayment> list3=null;
	   Transaction tx=null;
	   Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load objs using HQL
		//using Payment
		query=ses.createQuery("from Payment");
		list1=query.list();
		for(Payment payment:list1){
			System.out.println(payment);
		}
		System.out.println("..................................");
		query=ses.createQuery("from ChequePayment");
		list3=query.list();
		for(ChequePayment payment:list3){
			System.out.println(payment);
		}
		System.out.println("..................................");
		query=ses.createQuery("from CreditCardPayment");
		list2=query.list();
		for(CreditCardPayment payment:list2){
			System.out.println(payment);
		}
		System.out.println("..................................");
    //close objs
    HibernateUtil.closeSession();
    HibernateUtil.closeSessionFactory();
	}//main
}//class
