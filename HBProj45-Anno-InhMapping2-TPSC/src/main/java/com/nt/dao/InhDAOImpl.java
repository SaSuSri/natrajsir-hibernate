package com.nt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.ChequePayment;
import com.nt.domain.CreditCardPayment;
import com.nt.domain.Payment;
import com.nt.utility.HibernateUtil;

public class InhDAOImpl implements InhDAO {

	@Override
	public void saveData() {
		Session ses = null;
		CreditCardPayment ccPayment = null;
		ChequePayment chPayment = null;
		Transaction tx = null;
		// get Session
		ses = HibernateUtil.getSession();
		// save objects
		// using sub class1
		ccPayment = new CreditCardPayment();
		ccPayment.setAmount(2000);
		ccPayment.setCcType("VISA");
		// using sub class2
		chPayment = new ChequePayment();
		chPayment.setAmount(2000);
		chPayment.setChequeType("Self");
		try {
			tx = ses.beginTransaction();
			ses.save(ccPayment);
			ses.save(chPayment);
			tx.commit();
			System.out.println("Objects are saved....");
		} // try
		catch (Exception e) {
			tx.rollback();
		}
	}// method

	@Override
	public void loadData() {
		Session ses = null;
		List<Payment> list1 = null;
		List<CreditCardPayment> list2 = null;
		List<ChequePayment> list3 = null;
		Query query = null;
		// get Session
		ses = HibernateUtil.getSession();
		// Load objs using HQL
		// using Payment
		query = ses.createQuery("from Payment");
		list1 = query.list();
		for (Payment payment : list1) {
			System.out.println(payment);
		}
		System.out.println("..................................");
		
		query = ses.createQuery("from CreditCardPayment");
		list2 = query.list();
		for (CreditCardPayment payment : list2) {
			System.out.println(payment);
		}
		System.out.println("..................................");
	
		query = ses.createQuery("from ChequePayment");
		list3 = query.list();
		for (ChequePayment payment : list3) {
			System.out.println(payment);
		}
		System.out.println("..................................");
	}//method

}//class
