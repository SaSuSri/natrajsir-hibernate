package com.nt.dao;

public class ManyToManyDAOFactory {
   public static ManyToManyDAO getInstance(){
	   return new ManyToManyDAOImpl();
   }
}
