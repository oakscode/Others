package com.payment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payee")
public class Payee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long fromid;
	private long toid;
	private String fullname;
	
	
	
	
	
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getFromid() {
		return fromid;
	}
	public void setFromid(long fromid) {
		this.fromid = fromid;
	}
	public long getToid() {
		return toid;
	}
	public void setToid(long toid) {
		this.toid = toid;
	}
	@Override
	public String toString() {
		return "Payee [id=" + id + ", fromid=" + fromid + ", toid=" + toid + "]";
	}
	
	
	
	
	

}
