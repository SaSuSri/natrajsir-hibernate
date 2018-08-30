package com.nt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="CarCompany")
@Entity
public class CarCompany {
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
    private int cid;
	private String name;
	private String established;
	private String origin;
	//setters & getters
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEstablished() {
		return established;
	}
	public void setEstablished(String established) {
		this.established = established;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	@Override
	public String toString() {
		return "CarCompany [cid=" + cid + ", name=" + name + ", established=" + established + ", origin=" + origin
				+ "]";
	}
}

/* create table CarCompany(cid number(5) primary key,name varchar2(20),
                                                                 established varchar2(6),origin varchar2(15));
 create table CarModel(mid number(5) primary key,name varchar2(20),
      segment varchar2(20),carCompany number(5) references CarCompany(cid)); 

SQL> create sequence mid_sequence start with 100 increment by 1;
*/
