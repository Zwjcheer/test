package com.itqf.bean;

public class Student {
	private String username;
	private String password;
	private String sex;
	private int age;
	private String mobile;
	private String address;
	private String ismanager;
	private String path;
	private String id;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIsmanager() {
		return ismanager;
	}
	public void setIsmanager(String ismanager) {
		this.ismanager = ismanager;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Student(){}
	public Student(String username, String password, String sex, int age, String mobile, String address,
			String ismanager, String path) {
		
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
		this.ismanager = ismanager;
		this.path = path;
	}
	@Override
	public String toString() {
		return "Student [username=" + username + ", password=" + password + ", sex=" + sex + ", age=" + age
				+ ", mobile=" + mobile + ", address=" + address + ", ismanager=" + ismanager + ", path=" + path + "]";
	}
	
	
}
