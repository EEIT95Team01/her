package com.eeit95.her.model.font;

import java.sql.Blob;

public class FontDescriptionBean {

	private String fontId;
	private int order;
	private String text;
	private byte[] image;
	
	
	@Override
	public String toString() {
		return "FontDescriptionBean [fontId=" + fontId + ", order=" + order + ", text=" + text + ", image=" + image
				+ "]";
	}
	public String getFontId() {
		return fontId;
	}
	public void setFontId(String fontId) {
		this.fontId = fontId;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
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
	public void setImage(byte[] image) {
		this.image = image;
	}
}
