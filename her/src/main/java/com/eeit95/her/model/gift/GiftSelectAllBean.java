package com.eeit95.her.model.gift;

import java.util.Arrays;
import java.util.List;

public class GiftSelectAllBean  {
	private List<GiftBean> gift;
	private String[] tagIds;
	private List<GiftDescriptionBean> descriptions;
	
	@Override
	public String toString() {
		return "GiftSelectAllBean [gift=" + gift + ", tagIds=" + Arrays.toString(tagIds) + ", descriptions="
				+ descriptions + "]";
	}
	
	
	public List<GiftBean> getGift() {
		return gift;
	}
	public void setGift(List<GiftBean> gift) {
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