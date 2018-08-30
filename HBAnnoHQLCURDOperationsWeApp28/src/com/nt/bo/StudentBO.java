package com.nt.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="student_tab")
@Entity
@NamedQueries(value={@NamedQuery(name="GET_ALL_STUDENTS",
		                                                                query="from StudentBO"),
		                                    @NamedQuery(name="UPDATE_STUDENT_BY_NO",
		                                                                query="update StudentBO set sname=:newName,sadd=:newAddrs where sno=:no"
		                                                               )
                                            })
public class StudentBO {
	@Column(name="stno")
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	private int sno;
	@Column(name="stname")
	private String sname;
	@Column(name="stadd")
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
