package com.nt.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.nt.domain.Project;
public class ProgrammerDTO implements Serializable {
	private int pid;
	private String pname;
	private double salary;
	  private Set<ProjectDTO> projects=new HashSet<ProjectDTO>();
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Set<ProjectDTO> getProjects() {
		return projects;
	}
	public void setProjects(Set<ProjectDTO> projects) {
		this.projects = projects;
	}
}
