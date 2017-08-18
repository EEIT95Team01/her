package com.eeit95.her.model.orderform;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderform_pack_status")
public class OrderformPackStatusBean implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int packStatus;
	private String statusName;

	
	
	public int getPackStatus() {
		return packStatus;
	}
	public void setPackStatus(int packStatus) {
		this.packStatus = packStatus;
	}
	
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
