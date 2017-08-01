package com.eeit95.her.model.card;


import java.io.Serializable;
import java.util.*;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="card")
public class CardBean implements Serializable {

	private String id;
	private String name;
	private double price;
	private byte[] cover;
	private int viewCount;
	private int salesCount;
	private Boolean	status;
	private String manufacturer;
	private double cost;
	private double gpratio;
	private int stock;
	private int maxWordCount;
	private Set<CardDescriptionBean> desc = new HashSet<CardDescriptionBean>();
	
	
	@OneToMany(mappedBy="cardBean")
	public Set<CardDescriptionBean> getDesc() {
		return desc;
	}


	public void setDesc(Set<CardDescriptionBean> desc) {
		this.desc = desc;
	}


	public CardBean() {
	}


	@Override
	public String toString() {
		return "CardBean [id=" + id + ", name=" + name + ", price=" + price + ", cover=" + cover + ", viewCount="
				+ viewCount + ", salesCount=" + salesCount + ", status=" + status + ", manufacturer=" + manufacturer
				+ ", cost=" + cost + ", gpratio=" + gpratio + ", stock=" + stock + ", maxWordCount=" + maxWordCount
				+ "]";
	}
	
	@Id
	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public byte[] getCover() {
		return cover;
	}


	public void setCover(byte[] cover) {
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


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public double getGpratio() {
		return gpratio;
	}


	public void setGpratio(double gpratio) {
		this.gpratio = gpratio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getMaxWordCount() {
		return maxWordCount;
	}


	public void setMaxWordCount(int maxWordCount) {
		this.maxWordCount = maxWordCount;
	}


	public void setId(String id) {
		this.id = id;
	}
	

	
}
