package com.eeit95.her.model.card;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eeit95.her.model.dao.card.CardTagDAOhibernate;
import com.eeit95.her.model.tag.TagBean;

@Entity
@Table(name = "card_tag")
public class CardTagBean implements Serializable {

	@Id
	private String cardId;
//	@ManyToOne//(fetch=FetchType.LAZY)
//	@JoinColumn(name = "cardId")
//	private CardBean cardBean;
	@Id
	private int tagId;
//	@ManyToOne//(fetch=FetchType.LAZY)
//	@JoinColumn(name = "tagId")
//	private TagBean tagBean;
	
	
    public CardTagBean() {
    }
    @Override
	public String toString() {
		return ""+tagId;
	}


//	public CardBean getCardBean() {
//		return cardBean;
//	}
//	public void setCardBean(CardBean cardBean) {
//		this.cardBean = cardBean;
//	}
    
    
//	public TagBean getTagBean() {
//		return tagBean;
//	}
//  public void setTagBean(TagBean tagBean) {
//		this.tagBean = tagBean;
//	}
    
    
	public String getCardId() {
		return cardId;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}



	
}
