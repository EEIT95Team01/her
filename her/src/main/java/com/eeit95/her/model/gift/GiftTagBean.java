package com.eeit95.her.model.gift;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gift_tag")
public class GiftTagBean implements java.io.Serializable{
	private GiftBean giftId;
	private int tagId;		//資料庫型態為smallint(-2^15~2^15-1),與short範圍相同。
	
	public GiftTagBean(){
		
	}
	
	@Id
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "giftId")  //指定用來join table的column
	public GiftBean getGiftId() {
		return giftId;
	}
	public void setGiftId(GiftBean giftId) {
		this.giftId = giftId;
	}
	
	@Id
	@Column(name = "tagId")
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	
}