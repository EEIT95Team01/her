package com.eeit95.her.model.font;

public class FontDescriptionBean implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fontId;
	private int orderNo;
	private String text;
	private String image;
	
	
	
	@Override
	public String toString() {
		return "FontDescriptionBean [fontId=" + fontId + ", orderNo=" + orderNo + ", text=" + text + ", image=" + image
				+ "]";
	}
	public String getFontId() {
		return fontId;
	}
	public void setFontId(String fontId) {
		this.fontId = fontId;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
