package com.eeit95.her.model.gift;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gift_description")
public class GiftDescriptionBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String giftId;
	@Id
	private int orderNo;  //資料庫型態是tinyint，參考網址：https://goo.gl/6ThJ2r。
	private String text;
	private String image;   

	public GiftDescriptionBean(){
		
	}

	public String getGiftId() {
		return giftId;
	}

	public void setGiftId(String giftId) {
		this.giftId = giftId;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


}