package com.nt.dao;

public class InhDAOFactory {
	
	public static InhDAO getInstance(){
		return  new InhDAOImpl();
	}//method
}//class
