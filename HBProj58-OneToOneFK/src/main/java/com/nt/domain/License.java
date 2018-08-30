package com.nt.domain;

import java.util.Date;

public class License {
	private int lid;
	private String type;
	private Date validFrom,validTo;
	private Person licenseHolder;
	
	public License() {
	  System.out.println("License:0-param constructor");
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validForm) {
		this.validFrom = validForm;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Person getLicenseHolder() {
		return licenseHolder;
	}

	public void setLicenseHolder(Person licenseHolder) {
		this.licenseHolder = licenseHolder;
	}

	@Override
	public String toString() {
		return "License [lid=" + lid + ", type=" + type + ", validForm=" + validFrom + ", validTo=" + validTo+"]";
	}

}
