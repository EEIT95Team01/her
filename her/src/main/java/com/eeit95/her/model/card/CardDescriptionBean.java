package com.eeit95.her.model.card;


import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eeit95.her.model.dao.card.CardDescriptionDAOhibernate;
import com.eeit95.her.model.misc.SpringJavaConfiguration;



@Entity
@Table(name="card_description")
public class CardDescriptionBean implements Serializable {
//	@Id
//	@ManyToOne//(fetch=FetchType.LAZY)
//	@JoinColumn(name = "cardId")
//	private CardBean cardBean;
	@Id
	private String cardId;
	@Id
	private int orderNo;
	private String text;
	private String image;
//	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfigration.class);
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		
//		CardDescriptionBean	cddj = (CardDescriptionBean) context.getBean("CardDescriptionBean");
//		
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//			Session session = sessionFactory.getCurrentSession();
//
//////insert
////			CardDescriptionBean insert = new CardDescriptionBean();
////			insert.setCardBean(cardBean.setId);
////			insert.setPassword("xxx".getBytes());
////			insert.setEmail("xxx@iii.org.tw");
////			insert.setBirth(new java.util.Date());
////			session.save(insert);
////			
//////select
//////			CustomerBean bean = session.get(CustomerBean.class, "Alex");
//////			System.out.println(bean);
////
//////update
//////			CustomerBean update = session.get(CustomerBean.class, "xxx");
//////			update.setPassword("ooo".getBytes());
//////			update.setEmail("ooo@iii.org.tw");
//////			update.setBirth(new java.util.Date(0));
////
////delete			
//			CardDescriptionBean delete = session.get(CardDescriptionBean.class, "c01707280009");
//			session.delete(delete);
//			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} finally {
//			
//		}
//	
//	}
	
//	@Override
//	public String toString() {
//		return "CardDescriptionBean [cardBean=" + cardBean + ", orders=" + orders + ", text=" + text + ", image="
//				+ Arrays.toString(image) + "]";
//	}

	
//	public CardBean getCardBean() {
//		return cardBean;
//	}
//
//
//	public void setCardBean(CardBean cardBean) {
//		this.cardBean = cardBean;
//	}
	
	public String getCardId() {
		return cardId;
	}

	@Override
	public String toString() {
		return "CardDescriptionBean [cardId=" + cardId + ", orderNo=" + orderNo + ", text=" + text + ", image=" + image
				+ "]";
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	public int getOrderNo() {
		return orderNo;
	}
	
	

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String  image) {
		this.image = image;
	}
	
	
	
}
