package com.eeit95.her.model.orderform;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "orderform_pack")
public class OrderformPackBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String orderformId; //FOREIGN KEY REFERENCES [orderform](id)
	
	@Id
	private String packId; //FOREIGN KEY REFERENCES [pack](id)
	
	private String trackingNumber;

	private int status; //FOREIGN KEY REFERENCES [orderform_pack_status]([packStatus])

	
	public String getOrderformId() {
		return orderformId;
	}

	public void setOrderformId(String orderformId) {
		this.orderformId = orderformId;
	}

	public String getPackId() {
		return packId;
	}

	public void setPackId(String packId) {
		this.packId = packId;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
