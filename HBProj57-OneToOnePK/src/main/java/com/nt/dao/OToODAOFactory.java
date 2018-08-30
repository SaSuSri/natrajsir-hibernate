package com.nt.dao;

public class OToODAOFactory {
	
	public static OToODAO getInstance(){
		return new OToODAOImpl();
	}

}
