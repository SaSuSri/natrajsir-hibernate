package com.nt.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Project {
	private int proid;
	private String proname;
	private List<Programmer> programmers=new ArrayList<Programmer>();
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public List<Programmer> getProgrammers() {
		return programmers;
	}
	public void setProgrammers(List<Programmer> programmers) {
		this.programmers = programmers;
	}
	@Override
	public String toString() {
		return "Project [proid=" + proid + ", proname=" + proname + "]";
	}
}

/*
  create table programmers(pid number(5) primary key, pname varchar2(20),salary number(11,2));
  create table projects(proid number(5) primary key, proname varchar2(20));
  
 create table programmers_projects(programmer_id number(5) references programmers(pid),
              project_id number(5) references Projects(proid),
               primary key(programmer_id,project_id),prgmr_proj_indx number(5));
*/