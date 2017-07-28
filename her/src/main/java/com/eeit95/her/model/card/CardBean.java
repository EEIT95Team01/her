package com.eeit95.her.model.card;

import java.sql.Blob;

public class CardBean {
	
	private String name;
	private Long price;
	private Blob cover;
	private int viewCount;
	private int salesCount;
	private Boolean	status;
	private String manufacturer;
	private Long cost;
	private Long gpratio;
	private short stock;
	private short maxWordCount;
	
	
	private String id;
	@Override
	public String toString() {
		return "CardBean [id=" + id + ", name=" + name + ", price=" + price + ", cover=" + cover + ", viewCount="
				+ viewCount + ", salesCount=" + salesCount + ", status=" + status + ", manufacturer=" + manufacturer
				+ ", cost=" + cost + ", gpratio=" + gpratio + ", stock=" + stock + ", maxWordCount=" + maxWordCount
				+ "]";
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
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Blob getCover() {
		return cover;
	}
	public void setCover(Blob cover) {
		this.cover = cover;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getSalesCount() {
		return salesCount;
	}
	public void setSalesCount(int salesCount) {
		this.salesCount = salesCount;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Long getCost() {
		return cost;
	}
	public void setCost(Long cost) {
		this.cost = cost;
	}
	public Long getGpratio() {
		return gpratio;
	}
	public void setGpratio(Long gpratio) {
		this.gpratio = gpratio;
	}
	public short getStock() {
		return stock;
	}
	public void setStock(short stock) {
		this.stock = stock;
	}
	public short getMaxWordCount() {
		return maxWordCount;
	}
	public void setMaxWordCount(short maxWordCount) {
		this.maxWordCount = maxWordCount;
	}
	

	
}
