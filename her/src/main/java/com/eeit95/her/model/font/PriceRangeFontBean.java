package com.eeit95.her.model.font;

public class PriceRangeFontBean {

	
	private String id;
	private String name;
	private int lowPrice;
	private int highPrice;
	private int  writerId;
	private int status;
	
	@Override
	public String toString() {
		return "PriceRangeBean [id=" + id + ", name=" + name + ", lowPrice=" + lowPrice + ", highPrice=" + highPrice
				+ ", writerId=" + writerId + ", status=" + status + "]";
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
	public int getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(int lowPrice) {
		this.lowPrice = lowPrice;
	}
	public int getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(int highPrice) {
		this.highPrice = highPrice;
	}
	public int getWriterId() {
		return writerId;
	}
	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
