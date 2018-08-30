package com.nt.cid;

import java.io.Serializable;

public class Programmer_ProjectId implements Serializable{
	  private int proj_id;
	  private int prgmr_id;
	public int getProj_id() {
		return proj_id;
	}
	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}
	public int getPrgmr_id() {
		return prgmr_id;
	}
	public void setPrgmr_id(int prgmr_id) {
		this.prgmr_id = prgmr_id;
	}
	@Override
	public String toString() {
		return "Programmer_ProjectId [proj_id=" + proj_id + ", prgmr_id=" + prgmr_id + "]";
	}
	
}