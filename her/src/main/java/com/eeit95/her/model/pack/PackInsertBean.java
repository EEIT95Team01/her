package com.eeit95.her.model.pack;

import java.util.List;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.gift.GiftQuantityBean;

public class PackInsertBean {

	private String memberId;
	private String name;
	private CardBean card;
	private FontBean font;
	private List<GiftQuantityBean> gift;
	private double giftSum;
	private double sum;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public CardBean getCard() {
		return card;
	}
	public void setCard(CardBean card) {
		this.card = card;
	}
	
	public FontBean getFont() {
		return font;
	}
	public void setFont(FontBean font) {
		this.font = font;
	}
	
	public List<GiftQuantityBean> getGift() {
		return gift;
	}
	public void setGift(List<GiftQuantityBean> gift) {
		this.gift = gift;
	}
	
	public double getGiftSum() {
		return giftSum;
	}
	public void setGiftSum(double giftSum) {
		this.giftSum = giftSum;
	}
	
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	
}