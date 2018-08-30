package com.nt.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="CREDIT")
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
