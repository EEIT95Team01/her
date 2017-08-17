package com.eeit95.her.model.gift;

public class GiftSelectBean {

	private String id;
	private String name;
	private double lowPrice;
	private double highPrice;
	private double lowCost;
	private double highCost;
	private String manufacturer;
	private int status;

@Override
	public String toString() {
		return "GiftSelectBean [id=" + id + ", name=" + name + ", lowPrice=" + lowPrice + ", highPrice=" + highPrice
				+ ", lowCost=" + lowCost + ", highCost=" + highCost + ", manufacturer=" + manufacturer + ", status="
				+ status + "]";
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
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}


	
}
