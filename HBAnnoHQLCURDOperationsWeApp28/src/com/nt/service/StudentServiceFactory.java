package com.nt.service;

public class StudentServiceFactory {
	
	public static StudentService getInstance(){
		return new StudentServiceImpl();
	}

}
