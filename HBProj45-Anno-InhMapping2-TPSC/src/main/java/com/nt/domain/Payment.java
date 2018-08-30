package com.nt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="payment2")
@Inheritance(strategy=InheritanceType.JOINED)
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

/*SQL> desc payment2
Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
PAYID                                     NOT NULL NUMBER(5) (pk)
AMOUNT                                             NUMBER(10)

SQL> desc credit_payment2;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 CCTYPE                                             VARCHAR2(20)
 PAYMENT_ID                                         NUMBER(5) (FK)
 
 
SQL> desc cheque_payment2;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 CHTYPE                                             VARCHAR2(20)
 PAYMENT_ID                                         NUMBER(5)  (FK)

*/