package com.nt.test;

import com.nt.dao.LuckyDrawDAO;
import com.nt.dao.LuckyDrawDAOFactory;
import com.nt.utility.HibernateUtil;

public class CustomGeneratorTest {

	public static void main(String[] args) {
		LuckyDrawDAO dao=null;
		int thambolaNumber=0;
		//Get DAO
		dao=LuckyDrawDAOFactory.getInstance();
		//Save object and get draw number
		thambolaNumber=dao.generateDrawNumber("rahul gandhi");
		System.out.println("Generated Thambola Number is:"+thambolaNumber);
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
		
	}//main
}//class
