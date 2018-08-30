package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name="student_tab")
@FilterDef(name="FILTER_STUDS_BY_RANGE",
                    parameters={@ParamDef(name="min",type="int"),
		                                    @ParamDef(name="max",type="int")
                                           }                      
                 )
 @Filter(name="FILTER_STUDS_BY_RANGE",
               condition="STNO>=:min and stno<=:max")
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
