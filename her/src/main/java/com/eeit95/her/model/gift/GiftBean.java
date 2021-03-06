package com.eeit95.her.model.gift;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.eeit95.her.model.category.CategoryBean;

@Entity
@Table(name="gift")
public class GiftBean implements java.io.Serializable{

	@Id
	private String id;
	private String name;
	private double price;			//資料庫型態是money，要用double
	private String cover;			//資料庫型態是varbinary(max)，參考網址：https://goo.gl/6ThJ2r。
	private int viewCount;
	private int salesCount;
	private int status;			//資料庫型態是bit，參考網址：https://goo.gl/6ThJ2r。
	private String manufacturer;
	private double cost;			//資料庫型態是money，要用double
	private double gpratio;			//資料庫型態是money，要用double
	private int stock;			//資料庫型態為smallint(-2^15~2^15-1),與short範圍相同。
//	private int categoryId;
//	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
//	@JoinColumn(name = "categoryId")  //指定用來join table的column
//	private CategoryBean categoryId;	//FOREIGN KEY REFERENCES [category](id)
	
//	@OneToMany(mappedBy= "giftBean")
//	private Set<PackGiftBean> packGifts = new HashSet<PackGiftBean>();
	
	
	public GiftBean(){
		
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
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
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
	
	
	public int isStatus() {
		return status;
	}
	public void setStatus(int status) {
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


//	public int getCategoryId() {
//		return categoryId;
//	}
//
//
//	public void setCategoryId(int categoryId) {
//		this.categoryId = categoryId;
//	}
//	

//	public CategoryBean getCategoryId() {
//		return categoryId;
//	}
//
//	public void setCategoryId(CategoryBean categoryId) {
//		this.categoryId = categoryId;
//	}

	
//	public Set<PackGiftBean> getPackGifts() {
//		return packGifts;
//	}
//
//	public void setPackGifts(Set<PackGiftBean> packGifts) {
//		this.packGifts = packGifts;
//	}
}