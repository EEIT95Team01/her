package com.eeit95.her.model.font;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "font_tag")
public class FontTagBean implements java.io.Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name="fontId")
	private FontBean fontBean;
	@Id
	@ManyToOne
	@JoinColumn()
	private int tagId;
	
	
	
	@Override
	public String toString() {
		return "FontTagBean [fontBean=" + fontBean + ", tagId=" + tagId + "]";
	}
	
	public FontBean getFontBean() {
		return fontBean;
	}

	public void setFontBean(FontBean fontBean) {
		this.fontBean = fontBean;
	}

	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	
	
}
