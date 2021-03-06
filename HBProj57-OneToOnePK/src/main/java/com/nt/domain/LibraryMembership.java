package com.nt.domain;

import java.util.Date;

public class LibraryMembership {
	private int lid;
	private Date doj;
	private Student studentDetails;
	
	public LibraryMembership() {
	  System.out.println("LibraryMembership:0-param constructor");
	}
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Student getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(Student studentDetails) {
		this.studentDetails = studentDetails;
	}
	@Override
	public String toString() {
		return "LibraryMembership [lid=" + lid + ", doj=" + doj + "]";
	}
}
