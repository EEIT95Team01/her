package com.eeit95.her.model.gift;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.eeit95.her.model.pack.PackGiftBean;

@Entity
@Table(name="gift")
public class GiftBean implements java.io.Serializable{

	private String id;
	private String name;
	private double price;			//資料庫型態是money，要用double
	private byte[] cover;			//資料庫型態是varbinary(max)，參考網址：https://goo.gl/6ThJ2r。
	private int viewCount;
	private int salesCount;
	private boolean status;			//資料庫型態是bit，參考網址：https://goo.gl/6ThJ2r。
	private String manufacturer;
	private double cost;			//資料庫型態是money，要用double
	private double gpratio;			//資料庫型態是money，要用double
	private int stock;			//資料庫型態為smallint(-2^15~2^15-1),與short範圍相同。
	private CategoryBean categoryId;	//FOREIGN KEY REFERENCES [category](id)
	private Set<PackGiftBean> packGifts = new HashSet<PackGiftBean>();
	
	public GiftBean(){
		
	}
	
	@Id
	@Column(name = "id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="price")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Column(name="cover")
	public byte[] getCover() {
		return cover;
	}
	public void setCover(byte[] cover) {
		this.cover = cover;
	}
	
	@Column(name="viewCount")
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	@Column(name="salesCount")
	public int getSalesCount() {
		return salesCount;
	}
	public void setSalesCount(int salesCount) {
		this.salesCount = salesCount;
	}
	
	@Column(name="status")
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Column(name="manufacturer")
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@Column(name="cost")
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	@Column(name="gpratio")
	public double getGpratio() {
		return gpratio;
	}
	public void setGpratio(double gpratio) {
		this.gpratio = gpratio;
	}
	
	@Column(name="stock")
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "categoryId")  //指定用來join table的column
	public CategoryBean getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(CategoryBean categoryId) {
		this.categoryId = categoryId;
	}

	@OneToMany(mappedBy= "giftBean")
	public Set<PackGiftBean> getPackGifts() {
		return packGifts;
	}

	public void setPackGifts(Set<PackGiftBean> packGifts) {
		this.packGifts = packGifts;
	}

	
	
}