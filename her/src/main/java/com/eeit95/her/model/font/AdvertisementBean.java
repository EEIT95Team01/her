package com.eeit95.her.model.font;

import java.sql.Date;

public class AdvertisementBean {
	private int id;
	private String name;
	private byte[] image;
	private Date beginDate;
	private Date endDate;
	
	
	@Override
	public String toString() {
		return "AdvertisementBean [id=" + id + ", name=" + name + ", image=" + image + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
