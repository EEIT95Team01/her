package com.eeit95.her.model.pack;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.member.MemberBean;

@Entity
@Table(name = "pack")
public class PackBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;					//  1
	private String name;				//  2
	//@ManyToOne
	private String memberId;			//  3
	@ManyToOne
	@JoinColumn(name = "cardId")
	private CardBean cardBean;				//  4
	private Double cardPrice;			//  5
	@ManyToOne
	@JoinColumn(name = "fontId")
	private FontBean fontBean;				//  6
	private Double fontPrice;			//  7
	private Double giftSum;				//  8
	private Double sum;					//  9
	private String content;				// 10
	//要記得加@ManyToOne
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
	@ManyToOne
	@JoinColumn(name = "status")
	private PackStatusBean packStatusBean;					// 23
	@OneToMany(mappedBy="packBean")
	private Set<PackGiftBean> packGifts =new HashSet<PackGiftBean>();
	@OneToMany(mappedBy="packBean")
	private Set<OrderformPackBean> orderformPacks = new HashSet<OrderformPackBean>();
	
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
	public CardBean getCardBean() {
		return cardBean;
	}
	public void setCardBean(CardBean cardBean) {
		this.cardBean = cardBean;
	}
	public Double getCardPrice() {
		return cardPrice;
	}
	public void setCardPrice(Double cardPrice) {
		this.cardPrice = cardPrice;
	}
	
	public FontBean getFontBean() {
		return fontBean;
	}
	public void setFontBean(FontBean fontBean) {
		this.fontBean = fontBean;
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
	
	public PackStatusBean getPackStatusBean() {
		return packStatusBean;
	}
	public void setPackStatusBean(PackStatusBean packStatusBean) {
		this.packStatusBean = packStatusBean;
	}
	public Set<PackGiftBean> getPackGifts() {
		return packGifts;
	}
	public void setPackGifts(Set<PackGiftBean> packGifts) {
		this.packGifts = packGifts;
	}
	public Set<OrderformPackBean> getOrderformPacks() {
		return orderformPacks;
	}
	public void setOrderformPacks(Set<OrderformPackBean> orderformPacks) {
		this.orderformPacks = orderformPacks;
	}
	
	
}
