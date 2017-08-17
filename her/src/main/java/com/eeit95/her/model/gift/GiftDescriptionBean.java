package com.eeit95.her.model.gift;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gift_description")
public class GiftDescriptionBean implements java.io.Serializable{
	@Id
	private String giftId;
	@Id
	private int orderNo;  //資料庫型態是tinyint，參考網址：https://goo.gl/6ThJ2r。
	private String text;
	private String image;	  //資料庫的型態是varbinary(max)，參考網址：https://goo.gl/6ThJ2r。

	public GiftDescriptionBean(){
		
	}
	
	
//	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
//	@JoinColumn(name = "giftId")  //指定用來join table的column
//	public GiftBean getGiftId() {
//		return giftId;
//	}
//	public void setGiftId(GiftBean giftId) {
//		this.giftId = giftId;
//	}	
	
	
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
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