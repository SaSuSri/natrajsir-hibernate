package com.nt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="person_aadhar")
public class Person {
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	private int aadharNo;
	private String pname;
	private int age;
	public int getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(int aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

/* create table Person_Aadhar(aadharNo number(8) primary key,pname varchar2(20),age number(3));
 create table Person_passport(passportNo number(8) primary key,pname varchar2(20),country varchar2(10),person_details number(8) references Person_Aadhar(aadharNo)) ;
*/