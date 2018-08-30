package com.nt.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person_tab")
public class Person {
	@Id
	private int pid;
	private String pname;
	@Embedded
	private  JobType pjob;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public JobType getPjob() {
		return pjob;
	}
	public void setPjob(JobType pjob) {
		this.pjob = pjob;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", pjob=" + pjob + "]";
	}
	

}
