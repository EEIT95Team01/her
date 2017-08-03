package com.eeit95.her.model.gift;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "category_main")
public class CategoryMainBean implements java.io.Serializable{

	private int id;	//資料庫型態為smallint(-2^15~2^15-1),與short範圍相同。
	private String name;
	
	public CategoryMainBean(){
		
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
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}