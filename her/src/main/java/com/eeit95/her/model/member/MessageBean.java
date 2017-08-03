package com.eeit95.her.model.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGE") 
public class MessageBean implements java.io.Serializable{
	
	private Integer id;
	private MemberBean memberbean;
	private String name;
	private String email;
	private String content;
	private java.sql.Timestamp time;

	public MessageBean(){
	}

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name="xxx", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="xxx") 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity=MemberBean.class)
	@JoinColumn(name = "memberId")
	public MemberBean getMemberbean() {
		return memberbean;
	}

	public void setMemberbean(MemberBean memberbean) {
		this.memberbean = memberbean;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public java.sql.Timestamp getTime() {
		return time;
	}


	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}
	
	
	
}
