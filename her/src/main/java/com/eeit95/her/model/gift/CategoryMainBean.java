package com.eeit95.her.model.gift;

public class CategoryMainBean {

	private int id;	 //資料庫型態為smallint(-2^15~2^15-1),與short範圍相同。
	private String name;
	
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
	
}