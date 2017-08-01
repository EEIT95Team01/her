package com.eeit95.her.model.font;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "font")
public class FontBean implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private double price;
	private WriterBean writerBean;
	private String cover;
	private int viewCount;
	private int salesCount;
	private boolean status;
	
	
	
	
	@Override
	public String toString() {
		return "FontBean [id=" + id + ", name=" + name + ", price=" + price + ", writerBean=" + writerBean + ", cover="
				+ cover + ", viewCount=" + viewCount + ", salesCount=" + salesCount + ", status=" + status + "]";
	}
	@Id
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
	@ManyToOne //(fetch = FetchType.LAZY)
	@JoinColumn(name = "writerId") 
	public WriterBean getWriterBean() {
		return writerBean;
	}
	public void setWriterBean(WriterBean writerBean) {
		this.writerBean = writerBean;
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
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
	
}
