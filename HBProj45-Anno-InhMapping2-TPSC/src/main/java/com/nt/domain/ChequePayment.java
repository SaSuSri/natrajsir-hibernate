package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cheque_payment2")
@PrimaryKeyJoinColumn(name="payment_id",referencedColumnName="payId")
public class ChequePayment extends Payment {
	@Column(name="chType")
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
