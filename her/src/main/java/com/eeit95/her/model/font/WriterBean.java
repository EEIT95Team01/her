package com.eeit95.her.model.font;

import java.sql.Blob;

public class WriterBean {
	
	private int id;
	private String name;
	private byte[] cover;
	private String description;
	
	
	@Override
	public String toString() {
		return "WriterBean [id=" + id + ", name=" + name + ", cover=" + cover + ", description=" + description + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getCover() {
		return cover;
	}
	public void setCover(byte[] cover) {
		this.cover = cover;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
