package com.eeit95.her.model.card;


import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="card_description")
public class CardDescriptionBean implements Serializable {
	@Id
	@ManyToOne//(fetch=FetchType.LAZY)
	@JoinColumn(name = "cardId")
	private CardBean cardBean;
	@Id
	private int orderNo;
	private String text;
	private byte[] image;
	
	
	
//	@Override
//	public String toString() {
//		return "CardDescriptionBean [cardBean=" + cardBean + ", orders=" + orders + ", text=" + text + ", image="
//				+ Arrays.toString(image) + "]";
//	}

	
	public CardBean getCardBean() {
		return cardBean;
	}


	public void setCardBean(CardBean cardBean) {
		this.cardBean = cardBean;
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


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[]  image) {
		this.image = image;
	}
	
	
	
}
