package com.nt.dao;

public class SRDAOFactory {
	
	public static SRDAO getInstance(){
		return new SRDAOImpl();
	}

}
