package com.eeit95.her.model.tag;

public class TagBean {
	private short id;
	private String name;
	private Long discount;
	
	
	
	@Override
	public String toString() {
		return "TagBean [id=" + id + ", name=" + name + ", discount=" + discount + "]";
	}
	public short getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDiscount() {
		return discount;
	}
	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	
	
	
}
