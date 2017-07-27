package com.eeit95.her.model.pack;

import java.sql.Date;

public class PackageBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;					//  1
	private String name;				//  2
	private String memberId;			//  3
	private String cardId;				//  4
	private Double cardPrice;			//  5
	private String fontId;				//  6
	private Double fontPrice;			//  7
	private Double giftSum;				//  8
	private Double sum;					//  9
	private String content;				// 10
	private String recipientId;			// 11
	private String recipientName;		// 12
	private String recipientPhone;		// 13
	private String recipientCity;		// 14
	private String recipientDistrict;	// 15
	private String recipientAddr;		// 16
	private Date dateMailed;			// 17
	private String senderName;			// 18		
	private String senderPhone;			// 19
	private String senderCity;			// 20
	private String senderDistrict;		// 21
	private String senderAddr;			// 22
	private Boolean status;				// 23
	
	public PackageBean() {
		
	}
	
	@Override
	public String toString() {
		return "packageBean [id=" + id + ", name=" + name + ", memberId=" + memberId + ", cardId=" + cardId
				+ ", cardPrice=" + cardPrice + ", fontId=" + fontId + ", fontPrice=" + fontPrice + ", giftSum="
				+ giftSum + ", sum=" + sum + ", content=" + content + ", recipientId=" + recipientId
				+ ", recipientName=" + recipientName + ", recipientPhone=" + recipientPhone + ", recipientCity="
				+ recipientCity + ", recipientDistrict=" + recipientDistrict + ", recipientAddr=" + recipientAddr
				+ ", dateMailed=" + dateMailed + ", senderName=" + senderName + ", senderPhone=" + senderPhone
				+ ", senderCity=" + senderCity + ", senderDistrict=" + senderDistrict + ", senderAddr=" + senderAddr
				+ ", status=" + status + "]";
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public Double getCardPrice() {
		return cardPrice;
	}
	public void setCardPrice(Double cardPrice) {
		this.cardPrice = cardPrice;
	}
	public String getFontId() {
		return fontId;
	}
	public void setFontId(String fontId) {
		this.fontId = fontId;
	}
	public Double getFontPrice() {
		return fontPrice;
	}
	public void setFontPrice(Double fontPrice) {
		this.fontPrice = fontPrice;
	}
	public Double getGiftSum() {
		return giftSum;
	}
	public void setGiftSum(Double giftSum) {
		this.giftSum = giftSum;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getRecipientPhone() {
		return recipientPhone;
	}
	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}
	public String getRecipientCity() {
		return recipientCity;
	}
	public void setRecipientCity(String recipientCity) {
		this.recipientCity = recipientCity;
	}
	public String getRecipientDistrict() {
		return recipientDistrict;
	}
	public void setRecipientDistrict(String recipientDistrict) {
		this.recipientDistrict = recipientDistrict;
	}
	public String getRecipientAddr() {
		return recipientAddr;
	}
	public void setRecipientAddr(String recipientAddr) {
		this.recipientAddr = recipientAddr;
	}
	public Date getDateMailed() {
		return dateMailed;
	}
	public void setDateMailed(Date dateMailed) {
		this.dateMailed = dateMailed;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderPhone() {
		return senderPhone;
	}
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}
	public String getSenderCity() {
		return senderCity;
	}
	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}
	public String getSenderDistrict() {
		return senderDistrict;
	}
	public void setSenderDistrict(String senderDistrict) {
		this.senderDistrict = senderDistrict;
	}
	public String getSenderAddr() {
		return senderAddr;
	}
	public void setSenderAddr(String senderAddr) {
		this.senderAddr = senderAddr;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
}
