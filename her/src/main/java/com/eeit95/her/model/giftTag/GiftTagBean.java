package com.eeit95.her.model.giftTag;

public class GiftTagBean {
	private String giftId;
	private int tagId;	  //資料庫型態為smallint(-2^15~2^15-1),與short範圍相同。
	
	public String getGiftId() {
		return giftId;
	}
	public void setGiftId(String giftId) {
		this.giftId = giftId;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	
}