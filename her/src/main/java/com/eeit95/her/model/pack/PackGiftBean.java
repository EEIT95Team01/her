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
	private String packId; //FOREIGN KEY REFERENCES [pack](id)
	
	@Id
	private String giftId; //FOREIGN KEY REFERENCES [gift](id)
	
	private int giftQuantity;

	
	
	@Override
	public String toString() {
		return "PackGiftBean [packId=" + packId + ", giftId=" + giftId + ", giftQuantity=" + giftQuantity + "]";
	}

	public PackGiftBean() {

	}

	public String getPackId() {
		return packId;
	}

	public void setPackId(String packId) {
		this.packId = packId;
	}

	public String getGiftId() {
		return giftId;
	}

	public void setGiftId(String giftId) {
		this.giftId = giftId;
	}

	public int getGiftQuantity() {
		return giftQuantity;
	}

	public void setGiftQuantity(int giftQuantity) {
		this.giftQuantity = giftQuantity;
	}

	
}
