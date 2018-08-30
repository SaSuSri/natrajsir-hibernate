package com.nt.domain;

import com.nt.cid.Programmer_ProjectId;

public class Programmers_Projects{
	  private Programmer_ProjectId  id;
	  private String prgmr_name;
	  private String proj_name;
	  
	public Programmer_ProjectId getId() {
		return id;
	}
	public void setId(Programmer_ProjectId id) {
		this.id = id;
	}
	public String getPrgmr_name() {
		return prgmr_name;
	}
	public void setPrgmr_name(String prgmr_name) {
		this.prgmr_name = prgmr_name;
	}
	public String getProj_name() {
		return proj_name;
	}
	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}
	@Override
	public String toString() {
		return "Programmers_Projects [id=" + id + ", prgmr_name=" + prgmr_name + ", proj_name=" + proj_name + "]";
	}
	
}
