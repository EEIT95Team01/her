package com.eeit95.her.model.member;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER")
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

	private Set<RecipientBean> rbs = new HashSet<RecipientBean>();
	private Set<MessageBean> mbs = new HashSet<MessageBean>();
	private Set<HistoryBean> hb = new HashSet<HistoryBean>();

	public MemberBean(){		
	}
	
	@Id
	@Column(name = "id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "district")
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	@Column(name = "addr")
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Column(name = "birthday")
	public java.sql.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="memberbean")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【目前deptVO是EmpVO的一個屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<RecipientBean> getRbs() {
		return rbs;
	}
	public void setRbs(Set<RecipientBean> rbs) {
		this.rbs = rbs;
	}
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="memberbean")
	public Set<MessageBean> getMbs() {
		return mbs;
	}

	public void setMbs(Set<MessageBean> mbs) {
		this.mbs = mbs;
	}

	@OneToMany(mappedBy="memberbean")
	public Set<HistoryBean> getHb() {
		return hb;
	}

	public void setHb(Set<HistoryBean> hb) {
		this.hb = hb;
	}
	
}
