package com.nt.domain;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Table(name="University3")
@Entity
public class University {
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	private int unid;
	private String name;
	private String region;
	@OneToMany(targetEntity=College.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	@JoinColumn(name="affiliatedTo",referencedColumnName="unid")
	@Fetch(value=FetchMode.JOIN)
	@MapKeyColumn(name="map_indx")
	private Map<String,College> colleges;
	public int getUnid() {
		return unid;
	}
	public void setUnid(int unid) {
		this.unid = unid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Map<String,College> getColleges() {
		return colleges;
	}
	public void setColleges(Map<String,College> colleges) {
		this.colleges = colleges;
	}
	@Override
	public String toString() {
		return "University [unid=" + unid + ", name=" + name + ", region=" + region + "]";
	}
}


/*create table University3(unid number(5) primary key,
                                   name varchar2(20),region varchar2(20));
 create table College3(cid number(5) primary key,name varchar2(20),
            location varchar2(20),
             affiliatedTo number(6) references University3(unid),
             map_indx varchar2(5));


*/