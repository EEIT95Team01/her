package com.eeit95.her.model.font;

import java.sql.Blob;

public class FontBean {
	private String id;
	private String name;
	private int price;
	private int writerId;
	private Blob cover;
	private int viewCount;
	private int salesCount;
	private boolean status;
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getWriterId() {
		return writerId;
	}
	public void setWriterId(int writerId) {
		this.writerId = writerId;
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
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
