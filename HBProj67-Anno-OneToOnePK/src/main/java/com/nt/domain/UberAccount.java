package com.nt.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class UberAccount {
	@Id
	@Column(name="uber_id")
	@GenericGenerator(name="gen1",strategy="foreign",
	                                          parameters=@Parameter(name="property",value="facebookDetails"))
	@GeneratedValue(generator="gen1")
	private String uberId;
	private String name;
	private long mobileNo;
	@OneToOne(targetEntity=FacebookAccount.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn(name="uber_id",referencedColumnName="fb_id")
	
	private FacebookAccount facebookDetails;
	public String getUberId() {
		return uberId;
	}
	public void setUberId(String uberId) {
		this.uberId = uberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public FacebookAccount getFacebookDetails() {
		return facebookDetails;
	}
	public void setFacebookDetails(FacebookAccount facebookDetails) {
		this.facebookDetails = facebookDetails;
	}
}
