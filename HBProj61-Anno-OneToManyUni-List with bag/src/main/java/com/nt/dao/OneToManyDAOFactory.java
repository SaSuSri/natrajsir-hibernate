package com.nt.dao;

import javax.persistence.OneToMany;

public class OneToManyDAOFactory {
	
	public static OneToManyDAO getInstance(){
		return new OneToManyDAOImpl();
	}

}
