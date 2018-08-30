package com.nt.dao;

public interface BankDAO {
	public boolean transferMoney(int srcAcno,int destAcno,float amt);
}
