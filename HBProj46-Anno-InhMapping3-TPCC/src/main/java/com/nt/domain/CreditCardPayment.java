package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="credit_payment3")
public class CreditCardPayment extends Payment {
	@Column(name="ccType",length=15)
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
