package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class EmpDetails {
   //Bean properties
	@Id
	@Column(name="eid")
  private int no;
  @Column(name="firstname")	
  private String fname;
  @Column(name="lastname")
  private String lname;
  @Column(name="email")
  private String mail;
  
  public EmpDetails() {
	System.out.println("EmpDetails:0-param constructor");
}
  
  public int getNo() {
 	return no;
  }
  public void setNo(int no) {
 	this.no = no;
  }
  public String getFname() {
	return fname;
  }
  public void setFname(String fname) {
	this.fname = fname;
  }
  public String getLname() {
	return lname;
  }
   public void setLname(String lname) {
	this.lname = lname;
  }
  public String getMail() {
	return mail;
  }
  public void setMail(String mail) {
	this.mail = mail;
  }


@Override
public String toString() {
	return "EmpDetails [no=" + no + ", fname=" + fname + ", lname=" + lname + ", mail=" + mail + "]";
}
  
  

}
