package com.eeit95.her.model.member;

import java.sql.Date;

public class MemberBean implements java.io.Serializable{
	private String id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private String city;
	private String district;
	private String addr;
	private java.sql.Date birthday;
	
	public MemberBean(String email, String password, String name, String phone, String city, String district,
			String addr, Date birthday) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.district = district;
		this.addr = addr;
		this.birthday = birthday;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	public java.sql.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}
	
}