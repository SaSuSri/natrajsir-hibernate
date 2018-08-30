package com.nt.dao;

public class M2ODAOFactory {
	
	public static M2ODAO  getInstance(){
		return new  M2ODAOImpl();
	}

}
