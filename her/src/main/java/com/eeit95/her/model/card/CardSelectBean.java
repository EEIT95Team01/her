package com.eeit95.her.model.card;

import javax.persistence.Entity;

public class CardSelectBean {

	private String id;
	private String name;
	private String manufacturer;
	private double lowPrice;
	private double highPrice;
	private double lowCost;
	private double highCost;
	private int status;
	@Override
	public String toString() {
		return "CardSelectBean [id=" + id + ", name=" + name + ", manufacturer=" + manufacturer + ", lowPrice="
				+ lowPrice + ", highPrice=" + highPrice + ", lowCost=" + lowCost + ", highCost=" + highCost
				+ ", status=" + status + "]";
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
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public double getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}
	public double getLowCost() {
		return lowCost;
	}
	public void setLowCost(double lowCost) {
		this.lowCost = lowCost;
	}
	public double getHighCost() {
		return highCost;
	}
	public void setHighCost(double highCost) {
		this.highCost = highCost;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
