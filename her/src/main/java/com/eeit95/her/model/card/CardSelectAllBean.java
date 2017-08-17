package com.eeit95.her.model.card;

import java.util.Arrays;
import java.util.List;

public class CardSelectAllBean  {
	private List<CardBean> card;
	private String[] tagIds;
	private List<CardDescriptionBean> descriptions;
	
	
	@Override
	public String toString() {
		return "CardIUBean [card=" + card + ", tagIds=" + Arrays.toString(tagIds) + ", descriptions=" + descriptions
				+ "]";
	}
	public List<CardBean> getCard() {
		return card;
	}
	public void setCard(List<CardBean> card) {
		this.card = card;
	}
	public String[] getTagIds() {
		return tagIds;
	}
	public void setTagIds(String[] tagIds) {
		this.tagIds = tagIds;
	}
	public List<CardDescriptionBean> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(List<CardDescriptionBean> descriptions) {
		this.descriptions = descriptions;
	}
	
	
	
	
}