package com.eeit95.her.model.card;

import java.sql.Blob;

public class CardDescriptionBean {
	private String cardId;
	private short order;
	private String text;
	private byte[] image;
	
	
	@Override
	public String toString() {
		return "CardDescriptionBean [cardId=" + cardId + ", order=" + order + ", text=" + text + ", image=" + image
				+ "]";
	}


	public String getCardId() {
		return cardId;
	}


	public void setCardId(String cardId) {
		this.cardId = cardId;
	}


	public short getOrder() {
		return order;
	}


	public void setOrder(short order) {
		this.order = order;
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


	public void setImage(byte[]  image) {
		this.image = image;
	}
	
	
	
}
