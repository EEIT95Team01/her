package com.eeit95.her.model.font;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.eeit95.her.model.pack.PackBean;

@Entity
@Table(name = "font")
public class FontBean implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String name;
	private double price;
	private int writerId;
	private String cover;
	private int viewCount;
	private int salesCount;
	private int status;
//	@OneToMany( mappedBy="fontBean")//cascade=CascadeType.ALL, fetch=FetchType.EAGER,
//	private Set<FontDescriptionBean> fontDescriptions = new HashSet<FontDescriptionBean>();
//	@OneToMany( mappedBy="fontBean")
//	private Set<FontTagBean> fontTags = new HashSet<FontTagBean>();
//	@OneToMany( mappedBy="fontBean")
//	private Set<PackBean> packs = new HashSet<PackBean>();

	public FontBean() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getSalesCount() {
		return salesCount;
	}
	public void setSalesCount(int salesCount) {
		this.salesCount = salesCount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
//	public Set<FontDescriptionBean> getFontDescriptions() {
//		return fontDescriptions;
//	}
//	public void setFontDescriptions(Set<FontDescriptionBean> fontDescriptions) {
//		this.fontDescriptions = fontDescriptions;
//	}
//	@OneToMany( mappedBy="fontBean")
//	public Set<FontTagBean> getFontTags() {
//		return fontTags;
//	}
//	public void setFontTags(Set<FontTagBean> fontTags) {
//		this.fontTags = fontTags;
//	}

//	public Set<PackBean> getPacks() {
//		return packs;
//	}
//
//	public void setPacks(Set<PackBean> packs) {
//		this.packs = packs;
//	}

}
