package com.eeit95.her.model.font;

public class FontSBean {

	private String id;
	private String option;
	private String name;
	private int tagId;
	
	
	
	@Override
	public String toString() {
		return "FontSBean [id=" + id + ", option=" + option + ", name=" + name + ", tagId=" + tagId + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	
}
