package com.nt.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="students_games")
@Entity
public class StudentGame {
	@EmbeddedId
	private StudentGamePK id;
	private String sname;
	private String gameName;
	public StudentGamePK getId() {
		return id;
	}
	public void setId(StudentGamePK id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
}//class
