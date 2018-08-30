package com.nt.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Patient {
	@Id
	@GenericGenerator(name="gen1",strategy="sequence" ,parameters=@Parameter(name="sequence_name",value="pat_seq"))
	@GeneratedValue(generator="gen1")
	private int patId;
	private String name;
	private int age;
	@ManyToMany(targetEntity=Doctor.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="doctors_patients",
	                    joinColumns=@JoinColumn(name="patient_id",referencedColumnName="patId"),
	                    inverseJoinColumns=@JoinColumn(name="doctor_id",referencedColumnName="docId")
	                       )
	private Set<Doctor> doctors=new HashSet<Doctor>();
	public int getPatId() {
		return patId;
	}
	public void setPatId(int patId) {
		this.patId = patId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Set<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}
	@Override
	public String toString() {
		return "Patient [patId=" + patId + ", name=" + name + ", age=" + age + "]";
	}
}
