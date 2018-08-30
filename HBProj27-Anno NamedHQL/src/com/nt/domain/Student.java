package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="student_tab")
@NamedQueries({@NamedQuery(name="GET_STUDENTS_BY_RANGE",
                                                            query="from Student where sno>=:min and sno<=:max" ) ,
		                         @NamedQuery(name="UPDATE_ADDRS",
		                                                     query="update Student set sadd=:newAddrs where sadd=:oldAddrs")
		                         } 
                              )
public class Student {
	@Column(name="stno")
	@Id
	private int sno;
	@Column(name="stname")
	private String sname;
	@Column(name="stadd")
	//@Transient
	private String sadd;
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
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + "]";
	}

	
}
