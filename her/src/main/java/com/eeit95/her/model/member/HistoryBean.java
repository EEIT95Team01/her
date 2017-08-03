package com.eeit95.her.model.member;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HISTORY")
public class HistoryBean implements java.io.Serializable{
	
	private MemberBean memberbean;
	private String productId;
	private java.sql.Timestamp viewtime;
	
//	@Id
//  待處理的問題
	@ManyToOne
	@JoinColumn(name = "memberId")
	public MemberBean getMemberbean() {
		return memberbean;
	}
	public void setMemberbean(MemberBean memberbean) {
		this.memberbean = memberbean;
	}
	
	@Id
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public java.sql.Timestamp getViewtime() {
		return viewtime;
	}
	public void setViewtime(java.sql.Timestamp viewtime) {
		this.viewtime = viewtime;
	}

}