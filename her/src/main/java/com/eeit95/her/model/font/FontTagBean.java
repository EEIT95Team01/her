package com.eeit95.her.model.font;

public class FontTagBean {
	private String fontId;
	private int tagId;
	
	
	@Override
	public String toString() {
		return "FontTagBean [fontId=" + fontId + ", tagId=" + tagId + "]";
	}
	public String getFontId() {
		return fontId;
	}
	public void setFontId(String fontId) {
		this.fontId = fontId;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	
	
}
