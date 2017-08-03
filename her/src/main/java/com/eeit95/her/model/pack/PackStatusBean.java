package com.eeit95.her.model.pack;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pack_status")
public class PackStatusBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "psid", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="psid")
	private int packStatus;
	private String statusName;
	@OneToMany( mappedBy="packStatusBean")
	private Set<PackBean> packs = new HashSet<PackBean>();
	
	public int getPackStatus() {
		return packStatus;
	}
	public void setPackStatus(int packStatus) {
		this.packStatus = packStatus;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public Set<PackBean> getPacks() {
		return packs;
	}
	public void setPacks(Set<PackBean> packs) {
		this.packs = packs;
	}
	
}
