package com.eeit95.her.model.gift;

public class GiftBean {
	private String id;
	private String name;
	private float price;		//資料庫型態是money，要用float還是double？
	private byte[] cover;		//資料庫的型態是varbinary(max)，參考網址：https://goo.gl/6ThJ2r。
	private int viewCount;
	private int salesCount;
	private boolean status;		//資料庫的型態是bit，參考網址：https://goo.gl/6ThJ2r。
	private String manufacturer;
	private float cost;			//資料庫型態是money，要用float還是double？
	private float gpratio;		//資料庫型態是money，要用float還是double？
	private int stock;		//資料庫型態為smallint(-2^15~2^15-1),與short範圍相同。
	private int categoryId;	//資料庫型態為smallint(-2^15~2^15-1),與short範圍相同。
	
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public float getGpratio() {
		return gpratio;
	}
	public void setGpratio(float gpratio) {
		this.gpratio = gpratio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
}