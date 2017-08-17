package com.eeit95.her.model.font;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eeit95.her.model.tag.TagBean;

@Entity
@Table(name = "font_tag")
public class FontTagBean implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String fontId;
	@Id
	private int tagId;
	
	public FontTagBean(){
		
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
