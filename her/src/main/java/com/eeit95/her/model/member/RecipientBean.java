package com.eeit95.her.model.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "RECIPIENT")
public class RecipientBean implements java.io.Serializable{
	
	@Id
	@Column(name = "ID")
	private String id;
	private String name;
	private String phone;
	private String city;
	private String district;
	private String addr;
	private java.sql.Date birthday;
//	@ManyToOne(targetEntity=MemberBean.class)
//	@JoinColumn(name = "memberId")
	private String memberId;
	
	public RecipientBean(){
	}

	@Override
	public String toString() {
		return "RecipientBean [id=" + id + ", name=" + name + ", phone=" + phone + ", city=" + city + ", district="
				+ district + ", addr=" + addr + ", birthday=" + birthday + ", memberId=" + memberId + "]";
	}

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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	
	
}
