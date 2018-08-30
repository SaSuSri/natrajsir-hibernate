package com.nt.domain;

public class Person {
	private int pid;
	private String pname;
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
