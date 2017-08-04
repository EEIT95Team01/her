package com.eeit95.her.model.pack;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eeit95.her.model.gift.GiftBean;

@Entity
@Table(name = "pack_gift")
public class PackGiftBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "packId")
	private PackBean packBean;
	@Id
	@ManyToOne
	@JoinColumn(name = "giftId")
	private GiftBean giftBean;
	private int giftQuantity;

	public PackGiftBean() {

	}

	public PackBean getPackBean() {
		return packBean;
	}

	public void setPackBean(PackBean packBean) {
		this.packBean = packBean;
	}

	public GiftBean getGiftBean() {
		return giftBean;
	}

	public void setGiftBean(GiftBean giftBean) {
		this.giftBean = giftBean;
	}

	public int getGiftQuantity() {
		return giftQuantity;
	}

	public void setGiftQuantity(int giftQuantity) {
		this.giftQuantity = giftQuantity;
	}

}
