package com.eeit95.her.model.pack;

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
	@ManyToOne
	@JoinColumn(name = "orderformId")
	private OrderformBean orderformBean;
	@Id
	@ManyToOne
	@JoinColumn(name = "packId")
	private PackBean packBean;
	private String trackingNumber;
	@ManyToOne
	@JoinColumn(name = "status")
	private OrderformPackStatusBean orderformPackStatusBean;
	
	
	public OrderformBean getOrderformBean() {
		return orderformBean;
	}
	public void setOrderformBean(OrderformBean orderformBean) {
		this.orderformBean = orderformBean;
	}
	public PackBean getPackBean() {
		return packBean;
	}
	public void setPackBean(PackBean packBean) {
		this.packBean = packBean;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public OrderformPackStatusBean getOrderformPackStatusBean() {
		return orderformPackStatusBean;
	}
	public void setOrderformPackStatusBean(OrderformPackStatusBean orderformPackStatusBean) {
		this.orderformPackStatusBean = orderformPackStatusBean;
	}
	

}
