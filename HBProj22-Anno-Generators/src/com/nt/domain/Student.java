package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="student_tab")
public class Student {
	/*@Column(name="stno")
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")*/
	
	/*@Column(name="stno")
	@Id
	@GenericGenerator(name="gen1",
	                                         strategy="sequence",
	                                         parameters=@Parameter(name="sequence_name",value="STNO_SEQUENCE"))
	@GeneratedValue(generator="gen1")*/
	
	/*@Column(name="stno")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)*/
	
/*	@Column(name="stno")
	@Id
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="gen1",sequenceName="STNO_SEQ1",
	                                             initialValue=100,allocationSize=20)*/
	/*@Column(name="stno")
	@Id
	@GeneratedValue(generator="gen1",strategy=GenerationType.TABLE)
	@TableGenerator(name="gen1",
	                                    table="SEQ_TAB",
   	                                    pkColumnName="SEQ_NAME",
   	                                    valueColumnName="SEQ_VALUE",
    	                                 pkColumnValue="STNO",
	                                    initialValue=10,
	                                    allocationSize=10
	                                    )*/
	@Column(name="stno")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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

}
