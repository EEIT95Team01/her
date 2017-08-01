package com.eeit95.her.model.font;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "writer")
public class WriterBean implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String cover;
	private String description;
	private Set<FontBean> fonts = new HashSet<FontBean>();
	
	@Override
	public String toString() {
		return "WriterBean [id=" + id + ", name=" + name + ", cover=" + cover + ", description=" + description + "]";
	}
	@Id
	@SequenceGenerator(name="wid", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="wid")
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
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="writerBean")
	@OrderBy("id,asc")
	public Set<FontBean> getFonts() {
		return fonts;
	}
	public void setFonts(Set<FontBean> fonts) {
		this.fonts = fonts;
	}
	
	
}
