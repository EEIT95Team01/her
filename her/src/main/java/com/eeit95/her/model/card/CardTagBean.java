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
	@ManyToOne//(fetch=FetchType.LAZY)
	@JoinColumn(name = "cardId")
	private CardBean cardBean;
	@Id
	@ManyToOne//(fetch=FetchType.LAZY)
	@JoinColumn(name = "tagId")
	private TagBean tagBean;
	
	
    public CardTagBean() {
    }



	public CardBean getCardBean() {
		return cardBean;
	}
	public void setCardBean(CardBean cardBean) {
		this.cardBean = cardBean;
	}
	public TagBean getTagBean() {
		return tagBean;
	}
	public void setTagBean(TagBean tagBean) {
		this.tagBean = tagBean;
	}
}
