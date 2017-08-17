package com.eeit95.her.model.pack;

import java.util.Date;

public class PackSelectBean {

	private String id;
	private String name;
	private String memberId;
	private double lowPrice;
	private double highPrice;
	private Date beginDate;
	private Date endDate;
	private int status;
	
	
	@Override
	public String toString() {
		return "PackSelectBean [id=" + id + ", name=" + name + ", memberId=" + memberId + ", lowPrice=" + lowPrice
				+ ", highPrice=" + highPrice + ", beginDate=" + beginDate + ", endDate=" + endDate + ", status="
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
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
}
