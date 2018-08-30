package com.nt.dao;

public class LuckyDrawDAOFactory {
	
	public static  LuckyDrawDAO getInstance(){
		return  new LuckyDrawDAOImpl();
	}

}
