package com.nt.dao;

public class JoinsDAOFactory {
	
	public static JoinsDAO getInstance(){
		return new JoinsDAOImpl();
	}

}
