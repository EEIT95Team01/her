package com.eeit95.her.model.pack;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.eeit95.her.model.member.MemberBean;

@Entity
@Table(name="orderform")
public class OrderformBean implements Serializable {
	
	@Id
	private String id;
	//@ManyToOne
	private String memberId;
	private Date dateCreated;
	private int paymentMethod;
	private int paymentStatus;
	private String note;
	@OneToMany(mappedBy= "orderformBean")
	private Set<OrderformPackBean> orderformPacks = new HashSet<OrderformPackBean>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public int getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public int getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Set<OrderformPackBean> getOrderformPacks() {
		return orderformPacks;
	}
	public void setOrderformPacks(Set<OrderformPackBean> orderformPacks) {
		this.orderformPacks = orderformPacks;
	}
	
}
