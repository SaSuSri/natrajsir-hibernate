package com.nt.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="credit_payment2")
@PrimaryKeyJoinColumn(name="payment_id",referencedColumnName="payId")
public class CreditCardPayment extends Payment {
	private String ccType;

	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	@Override
	public String toString() {
		return "CreditCardPayment ["+super.toString()+"ccType=" + ccType + "]";
	}
}//class
