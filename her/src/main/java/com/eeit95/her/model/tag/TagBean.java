package com.eeit95.her.model.tag;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.eeit95.her.model.card.CardDescriptionBean;
import com.eeit95.her.model.card.CardTagBean;

@Entity
@Table(name = "tag")
public class TagBean implements Serializable {

	@Id
	@SequenceGenerator(name = "tagId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "tagId")
	private int id;
	private String name;
	private double discount;
	@OneToMany(mappedBy = "tagBean")
	private Set<CardTagBean> CTB = new HashSet<CardTagBean>();

	public TagBean() {
	}

	public Set<CardTagBean> getCTB() {
		return CTB;
	}
	

	public void setCTB(Set<CardTagBean> cTB) {
		CTB = cTB;
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
