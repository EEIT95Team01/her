package com.eeit95.her.model.advertisement;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "advertisement")
public class AdvertisementBean {
	
	@Id
	@SequenceGenerator(name="adid", allocationSize=1) 
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="adid") 
	private int id;
	private String name;
	private byte[] image;
	@Temporal(TemporalType.DATE)
	private Date beginDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	public AdvertisementBean() {
		
	}
	
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
