package com.nt.dao;

public class StudentDAOFactory {
	public static StudentDAO getInstance(){
		return new StudentDAOImpl();
	}

}
