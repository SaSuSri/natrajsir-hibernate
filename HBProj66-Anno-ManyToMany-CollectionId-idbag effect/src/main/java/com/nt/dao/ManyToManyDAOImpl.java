package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Doctor;
import com.nt.domain.Patient;
import com.nt.utility.HibernateUtil;

public class ManyToManyDAOImpl implements ManyToManyDAO {

	public void saveDataUsingPatient() {
		Session ses = null;
		Doctor doc1 = null, doc2 = null;
		Patient pat1 = null, pat2 = null, pat3 = null;
		Transaction tx = null;
		// get Session
		ses = HibernateUtil.getSession();
		// prepare parent ,child objecs
		doc1 = new Doctor();
		doc1.setName("Kiran");
		doc1.setSpecialization("Physican");

		doc2 = new Doctor();
		doc2.setName("Ramakrishna");
		doc2.setSpecialization("Dentist");

		pat1 = new Patient();
		pat1.setName("mukesh");
		pat1.setAge(30);

		pat2 = new Patient();
		pat2.setName("rani");
		pat2.setAge(16);

		pat3 = new Patient();
		pat3.setName("jani");
		pat3.setAge(60);

		// map doctors to patients
		pat1.getDoctors().add(doc1);
		pat1.getDoctors().add(doc2);

		pat2.getDoctors().add(doc2);

		pat3.getDoctors().add(doc1);
		pat3.getDoctors().add(doc2);

		// map patients to doctors
		doc1.getPatients().add(pat1);
		doc1.getPatients().add(pat3);

		doc2.getPatients().add(pat1);
		doc2.getPatients().add(pat2);
		doc2.getPatients().add(pat3);

		// save objs
		try {
			tx = ses.beginTransaction();
			ses.save(pat1);
			ses.save(pat2);
			ses.save(pat3);
			tx.commit();
			System.out.println("Objects are saved");
		} // try
		catch (Exception e) {
			tx.rollback();
		}
	}// method
}// class
