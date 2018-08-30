package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="payment3")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Payment {
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	@Column(name="payId",length=10)
	private int payId;
	@Column(name="amount",length=8)
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

/*SQL> desc credit_payment3;
Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
PAYID                                     NOT NULL NUMBER(10) (PK)
AMOUNT                                             NUMBER(10)
CCTYPE                                             VARCHAR2(15)

SQL> desc cheque_payment3;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 PAYID                                     NOT NULL NUMBER(10)  (PK)
 AMOUNT                                             NUMBER(10)
 CHTYPE                                             VARCHAR2(15)
*/
