package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cheque_payment3")
public class ChequePayment extends Payment {
	@Column(name="chType",length=15)
	private String chequeType;

	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}

	@Override
	public String toString() {
		return "ChequePayment ["+super.toString()+"chequeType=" + chequeType + "]";
	}
}//class
