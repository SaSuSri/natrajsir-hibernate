package com.nt.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="payment1")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="paytype",discriminatorType=DiscriminatorType.STRING)
public abstract class Payment {
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	private int payId;
	private int amount;
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", amount=" + amount + "]";
	}
}//class



/*SQL> desc payment1;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 PAYID                                     NOT NULL NUMBER(5)
 AMOUNT                                             NUMBER(10)
 CCTYPE                                             VARCHAR2(20)
 CHEQUETYPE                                         VARCHAR2(20)
 PAYTYPE                                            VARCHAR2(10)
*/