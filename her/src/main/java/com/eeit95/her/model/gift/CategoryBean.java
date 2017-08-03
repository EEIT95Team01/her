package com.eeit95.her.model.gift;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryBean implements java.io.Serializable{
	private CategoryMainBean mainId;
	private int id;		//資料庫型態為smallint(-2^15~2^15-1),與short範圍相同。
	private String subName;
	private Set<GiftBean> gifts =new HashSet<GiftBean>();
	
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "categoryId")
	public Set<GiftBean> getGifts() {
		return gifts;
	}

	public void setGifts(Set<GiftBean> gifts) {
		this.gifts = gifts;
	}

	public CategoryBean(){
		
	}
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name="idNum", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="idNum")   //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "mainId")  //指定用來join table的column
	public CategoryMainBean getMainId() {
		return mainId;
	}

	public void setMainId(CategoryMainBean mainId) {
		this.mainId = mainId;
	}
	
	@Column(name="subName")
	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}
	
}