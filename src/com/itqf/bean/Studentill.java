package com.itqf.bean;

public class Studentill {
	private String name;
	private String age;
	private String date;
	private String reason;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public Studentill(String name, String age, String date, String reason, String id) {
		
		this.name = name;
		this.age = age;
		this.date = date;
		this.reason = reason;
		this.id = id;
	}
	public Studentill(){}
	
}
