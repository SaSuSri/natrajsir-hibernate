package com.nt.dao;

public class TransferDAOFactory {
	
	public static TransferDAO getInstance(){
		return new TransferDAOImpl();
	}//method
}//class
