package com.nt.domain;

public class Employee extends Person {
	private int department;
	private double salary;
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee ["+super.toString()+"department=" + department + ", salary=" + salary + "]";
	}
	

}
