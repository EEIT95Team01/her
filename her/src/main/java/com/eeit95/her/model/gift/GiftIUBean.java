package com.eeit95.her.model.gift;

import java.util.List;

import com.eeit95.her.model.card.CardDescriptionBean;

public class GiftIUBean  {
	private GiftBean gift;
	private String[] tagIds;
	private List<GiftDescriptionBean> descriptions;
	
	
	
	public GiftBean getGiftBean() {
		return gift;
	}
	public void setGiftBean(GiftBean gift) {
		this.gift = gift;
	}
	public String[] getTagIds() {
		return tagIds;
	}
	public void setTagIds(String[] tagIds) {
		this.tagIds = tagIds;
	}
	public List<GiftDescriptionBean> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(List<GiftDescriptionBean> descriptions) {
		this.descriptions = descriptions;
	}
	
	
	
}