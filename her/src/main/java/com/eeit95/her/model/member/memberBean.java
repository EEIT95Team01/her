package com.eeit95.her.model.member;

public class memberBean {
	private String id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private String city;
	private String district;
	private String add;
	private java.sql.Date birthday;
	
	
	@Override
	public String toString() {
		return "memberBean [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", city=" + city + ", district=" + district + ", add=" + add + ", birthday=" + birthday + "]";
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
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public java.sql.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}
	
}
