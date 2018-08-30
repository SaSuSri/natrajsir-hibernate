package com.nt.dao;

public class MToODAOFactory {
	public static MToODAO getInstance(){
		return new MToODAOImpl();
	}

}
