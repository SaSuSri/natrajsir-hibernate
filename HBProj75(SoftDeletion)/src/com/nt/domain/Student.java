package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "student_Tab_SoftDeletion")
 @SQLDelete(sql="UPDATE Student_tab_softdeletion SET deleted='yes' WHERE sno=?")
 @Where(clause="deleted is  NULL ")
public class Student {
	@Id
	@Column(name = "sno")
	private int sno;
	@Column(name = "sname")
	private String sname;
	@Column(name = "sadd")
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

	// toString
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", address=" + address + "]";
	}

}