package com.eeit95.her.model.font;

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
public class AdvertisementBean implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String image;
	private Date beginDate;
	private Date endDate;
	
	
	@Override
	public String toString() {
		return "AdvertisementBean [id=" + id + ", name=" + name + ", image=" + image + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + "]";
	}
	@Id
	@SequenceGenerator(name="adid", allocationSize=1) 
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="adid") 
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
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
