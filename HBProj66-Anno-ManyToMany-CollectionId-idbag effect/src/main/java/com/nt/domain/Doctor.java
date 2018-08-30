package com.nt.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Doctor {
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	private int docId;
	private String name;
	private String specialization;
	@ManyToMany(targetEntity=Patient.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="doctors")
	private Set<Patient> patients=new HashSet<Patient>();
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Set<Patient> getPatients() {
		return patients;
	}
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}
	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", name=" + name + ", specialization=" + specialization + "]";
	}
}

/*SQL> create table Doctor(docId number(5) primary key,name varchar2(20),specialization varchar2(20));


SQL> create table patient(patId number(5) primary key,name varchar2(20),age  number(5));


SQL> create table Doctors_patients(doctor_id number(5) references Doctor(docId),patient_id number(5) references patient(patId),primary key(doctor_id,patient_id));

SQL> create sequence pat_seq start with 1000 increment by 1;
*/