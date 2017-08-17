package com.eeit95.her.model.category;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category_main")
public class CategoryMainBean implements java.io.Serializable{

	@Id
	@Column(name = "id")
	//如果使用Oracl資料庫，需要以下步驟：
	//1.寫@SequenceGenerator(name="XXX", allocationSize=1) 
	//2.用@SequenceGenerator建立一個generator
	//2.再用@GeneratedValue的generator屬性指定要用哪個generator，【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】
	//3.最後寫generator="XXX"在@GeneratedValue裡面。
	@GeneratedValue(strategy = GenerationType.IDENTITY)//SQL資料庫的主鍵生成方式設為identity。    
	private int id;	//資料庫型態為smallint(-2^15~2^15-1),與short範圍相同。
	
	@Column(name = "name")
	private String name;
	
//	@OneToMany(fetch=FetchType.EAGER, mappedBy = "mainId")
//	private Set<CategoryBean> categorys =new HashSet<CategoryBean>();
	
	
	public CategoryMainBean(){
		
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
	
//	public Set<CategoryBean> getCategorys() {
//		return categorys;
//	}
//
//	public void setCategorys(Set<CategoryBean> categorys) {
//		this.categorys = categorys;
//	}
	
}