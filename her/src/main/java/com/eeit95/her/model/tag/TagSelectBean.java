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


public class TagSelectBean implements Serializable {
	
	private int id;
	private String name;
	private double lowDiscount;
	private double highDiscount;
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
	public double getLowDiscount() {
		return lowDiscount;
	}
	public void setLowDiscount(double lowDiscount) {
		this.lowDiscount = lowDiscount;
	}
	public double getHighDiscount() {
		return highDiscount;
	}
	public void setHighDiscount(double highDiscount) {
		this.highDiscount = highDiscount;
	}
	@Override
	public String toString() {
		return "TagSelectBean [id=" + id + ", name=" + name + ", lowDiscount=" + lowDiscount + ", highDiscount="
				+ highDiscount + "]";
	}

	
	
}
