package com.eeit95.her.model.orderform;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="orderform")
public class OrderformSelectBean implements Serializable {
	
	@Id
	private String id;
	private String memberId;
	private String beginDateCreated;
	private String endDateCreated;
	private int paymentStatus;
	private String note;
	
	
	
	
	@Override
	public String toString() {
		return "OrderformSelectBean [id=" + id + ", memberId=" + memberId + ", beginDateCreated=" + beginDateCreated
				+ ", endDateCreated=" + endDateCreated + ", paymentStatus=" + paymentStatus + ", note=" + note + "]";
	}
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
	public String getBeginDateCreated() {
		return beginDateCreated;
	}
	public void setBeginDateCreated(String beginDateCreated) {
		this.beginDateCreated = beginDateCreated;
	}
	public String getEndDateCreated() {
		return endDateCreated;
	}
	public void setEndDateCreated(String endDateCreated) {
		this.endDateCreated = endDateCreated;
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
	
}
