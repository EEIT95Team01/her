package com.eeit95.her.model.member;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COLLECTION")
public class CollectionBean implements Serializable{
	
	@Id
	private String memberId;
	@Id
	private String productId;
	private java.sql.Timestamp addTime;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public java.sql.Timestamp getAddTime() {
		return addTime;
	}
	public void setAddTime(java.sql.Timestamp addTime) {
		this.addTime = addTime;
	}
	
	

}
