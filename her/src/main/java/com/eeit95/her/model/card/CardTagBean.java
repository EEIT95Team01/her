package com.eeit95.her.model.card;

public class CardTagBean {
	private String cardId;
	private short tagId;
	
	

	@Override
	public String toString() {
		return "CardTagBean [cardId=" + cardId + ", tagId=" + tagId + "]";
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public short getTagId() {
		return tagId;
	}
	public void setTagId(short tagId) {
		this.tagId = tagId;
	}
}
