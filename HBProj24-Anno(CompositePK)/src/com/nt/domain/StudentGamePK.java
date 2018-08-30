package com.nt.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class StudentGamePK implements Serializable {
	private int stno;
	private int gameNo;
	public int getStno() {
		return stno;
	}
	public void setStno(int stno) {
		this.stno = stno;
	}
	public int getGameNo() {
		return gameNo;
	}
	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}
	

}
