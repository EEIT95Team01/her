package com.eeit95.her.model.font;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "font_description")
public class FontDescriptionBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String fontId;
	@Id
	private int orderNo;
	private String text;
	private String image;
	
	public FontDescriptionBean() {
		
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
