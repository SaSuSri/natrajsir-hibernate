package com.nt.domain;

import java.sql.Blob;
import java.sql.Clob;

public class EmpProfile {
	private int eid;
	private String ename;
	private Clob eresume;
	private Blob ephoto;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Clob getEresume() {
		return eresume;
	}

	public void setEresume(Clob eresume) {
		this.eresume = eresume;
	}

	public Blob getEphoto() {
		return ephoto;
	}

	public void setEphoto(Blob ephoto) {
		this.ephoto = ephoto;
	}

}