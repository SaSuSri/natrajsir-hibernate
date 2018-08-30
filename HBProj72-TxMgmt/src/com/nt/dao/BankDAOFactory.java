package com.nt.dao;

public class BankDAOFactory {
   public static BankDAO getInstance(){
	   return new BankDAOImpl();
   }
}
