package com.nt.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FacebookAccount {
	@Id
	@Column(name = "fb_id")
	private String fbId;
	private String name;
	private int followers;
	@OneToOne(targetEntity = UberAccount.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "facebookDetails")
	private UberAccount uberDetails;

	public String getFbId() {
		return fbId;
	}

	public void setFbId(String fbId) {
		this.fbId = fbId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public UberAccount getUberDetails() {
		return uberDetails;
	}

	public void setUberDetails(UberAccount uberDetails) {
		this.uberDetails = uberDetails;
	}

}

/*
 * SQL> create table FacebookAccount(fb_id varchar2(15) primary key,name
 * varchar2(15),followers number(10));
 * 
 * Table created.
 * 
 * SQL> create table UberAccount(uber_id varchar2(15) primary key,name
 * varchar2(15),mobileNo number(10));
 */