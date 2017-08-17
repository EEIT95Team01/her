package com.eeit95.her.model.category;

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
import javax.persistence.Table;

import com.eeit95.her.model.gift.GiftBean;

@Entity //要加上@Entity才能成為JPA的一個Entity類別
@Table(name = "category") //代表這個class是對應到資料庫的實體table，目前對應的table是category 
public class CategoryBean implements java.io.Serializable{
	private CategoryMainBean mainId;
	private int id;		//資料庫型態為smallint(-2^15~2^15-1),與short範圍相同。
	private String subName;
//	private Set<GiftBean> gifts =new HashSet<GiftBean>();
	
	public CategoryBean(){
		//必需有一個不傳參數建構子(JavaBean基本知識)
	}
	
//	@OneToMany(fetch=FetchType.EAGER, mappedBy = "categoryId")
//	public Set<GiftBean> getGifts() {
//		return gifts;
//	}
//
//	public void setGifts(Set<GiftBean> gifts) {
//		this.gifts = gifts;
//	}
	
	@Id //@Id代表這個屬性是這個Entity的唯一識別屬性，並且對映到Table的主鍵
	@Column(name = "id") //@Column指這個屬性是對應到資料庫Table的哪一個欄位   //【非必要，但當欄位名稱與屬性名稱不同時則一定要用】
	//如果使用Oracl資料庫，需要以下步驟：
	//1.寫@SequenceGenerator(name="XXX", allocationSize=1) 
	//2.用@SequenceGenerator建立一個generator
	//2.再用@GeneratedValue的generator屬性指定要用哪個generator，【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】
	//3.最後寫generator="XXX"在@GeneratedValue裡面。
	@GeneratedValue(strategy = GenerationType.IDENTITY)//SQL資料庫的主鍵生成方式設為identity。  
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