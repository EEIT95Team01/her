package com.eeit95.her.model.gift;

public class GiftDescriptionBean {
	
	private String giftId;
	private int g_order;		//資料庫型態是tinyint，參考網址：https://goo.gl/6ThJ2r。
	private String text;
	private byte[] image;		//資料庫的型態是varbinary(max)，參考網址：https://goo.gl/6ThJ2r。
	
	public String getGiftId() {
		return giftId;
	}
	public void setGiftId(String giftId) {
		this.giftId = giftId;
	}
	public int getG_order() {
		return g_order;
	}
	public void setG_order(int g_order) {
		this.g_order = g_order;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}

}