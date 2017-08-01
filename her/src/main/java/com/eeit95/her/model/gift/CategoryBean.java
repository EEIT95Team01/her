package com.eeit95.her.model.gift;

public class CategoryBean {
	private int mainId;	//資料庫型態為smallint(-2^15~2^15-1),與short範圍相同。
	private int id;		//資料庫型態為smallint(-2^15~2^15-1),與short範圍相同。
	private String subName;
	
	public int getMainId() {
		return mainId;
	}
	public void setMainId(int mainId) {
		this.mainId = mainId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	
}