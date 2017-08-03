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
	@ManyToOne
	@JoinColumn(name="fontId")
	private FontBean fontBean;
	@Id
	@ManyToOne
	@JoinColumn(name="tagId")
	private TagBean tagBean;
	
	public FontTagBean(){
		
	}
	
	
	public FontBean getFontBean() {
		return fontBean;
	}

	public void setFontBean(FontBean fontBean) {
		this.fontBean = fontBean;
	}
	
	public TagBean getTagBean() {
		return tagBean;
	}

	public void setTagBean(TagBean tagBean) {
		this.tagBean = tagBean;
	}
}
