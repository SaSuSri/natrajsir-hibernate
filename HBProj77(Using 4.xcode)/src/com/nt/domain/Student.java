package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="student_Tab")
public class Student{
@Id
@Column(name="stno")
 private int sno;
 @Column(name="stname")
 private String sname;
 @Column(name="stadd")
 //@Transient
 private String address;
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
 //toString
@Override
public String toString() {
	return "Student [sno=" + sno + ", sname=" + sname + ", address=" + address + "]";
}

 
}