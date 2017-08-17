package com.eeit95.her.model.font;

import java.util.List;

public class FontIUBean  {
	private List<FontBean> font;
	private String[] tagIds;
	private List<FontDescriptionBean> descriptions;
	
	
	
	
	public List<FontBean> getFont() {
		return font;
	}
	public void setFont(List<FontBean> font) {
		this.font = font;
	}
	public String[] getTagIds() {
		return tagIds;
	}
	public void setTagIds(String[] tagIds) {
		this.tagIds = tagIds;
	}
	public List<FontDescriptionBean> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(List<FontDescriptionBean> descriptions) {
		this.descriptions = descriptions;
	}
	
	
	
	
	
}