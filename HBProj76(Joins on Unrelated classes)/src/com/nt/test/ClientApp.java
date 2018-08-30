package com.nt.test;

import com.nt.dao.JoinsDAO;
import com.nt.dao.JoinsDAOFactory;
import com.nt.utility.HibernateUtil;

public class ClientApp {

	public static void main(String[] args) {
		JoinsDAO dao=null;
		//get DAO
		dao=JoinsDAOFactory.getInstance();
		dao.showData();
		//clsose objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();

	}

}
