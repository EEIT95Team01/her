package com.eeit95.her.model.pack;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pack_status")
public class PackStatusBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "psid", allocationSize = 1)
	private int packStatus;
	private String statusName;
	
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
}
