package com.eeit95.her.model.advertisement;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "advertisement")
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
	@Id
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
	@Temporal(TemporalType.DATE)
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	@Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
