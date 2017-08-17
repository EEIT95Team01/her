package com.eeit95.her.model.dao.card;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardDescriptionBean;
import com.eeit95.her.model.card.CardTagBean;
import com.eeit95.her.model.card.CardTagBean;
import com.eeit95.her.model.card.CardTagBean;
import com.eeit95.her.model.card.CardTagInterface;
import com.eeit95.her.model.dao.tag.TagDAOhibernate;
import com.eeit95.her.model.misc.SpringJavaConfiguration;
import com.eeit95.her.model.tag.TagBean;

@Repository
public class CardTagDAOhibernate implements CardTagInterface {
	private static final String selectBycardId = "from CardTagBean where cardId = ?";
	private static final String selectBytagId = "from CardTagBean where tagId = ?";
	private static final String deleteBycardId = "delete from CardTagBean where cardId = ?";
	private static final String deleteBytagId = "delete from CardTagBean where tagId = ?";
	private static final String delete = "delete from CardTagBean where cardId = ? AND tagId = ?";
	private static final String selectAll = "from CardTagBean";
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

//	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//
//		CardTagDAOhibernate cto = (CardTagDAOhibernate) context.getBean("cardTagDAOhibernate");
//		CardTagBean bean = null;
//		List<CardTagBean> list = null;
//		List<CardTagBean> list1 = new ArrayList<CardTagBean>();
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
////			list=cto.selectBycardId("c01701010001");
//			
//			
//			
//			CardBean cardBean1 = new CardBean();
//			cardBean1.setId("c01706010001");
//			TagBean tagBean1=new TagBean();
//			tagBean1.setId(12);
//			
//			TagBean tagBean2=new TagBean();
//			tagBean2.setId(11);
//			
//			CardTagBean CardTagBean1 = new CardTagBean();
//			CardTagBean1.setCardBean(cardBean1);
//			CardTagBean1.setTagBean(tagBean1);
//			System.out.println(CardTagBean1.getCardBean().getId() +","+CardTagBean1.getTagBean().getId());
//
//			CardTagBean CardTagBean2 = new CardTagBean();
//			CardTagBean2.setCardBean(cardBean1);
//			CardTagBean2.setTagBean(tagBean2);
//			System.out.println(CardTagBean2.getCardBean().getId() +","+CardTagBean2.getTagBean().getId());
//			list1.add(CardTagBean1);
//			list1.add(CardTagBean2);
//			
////			cto.insert(list1);
//			cto.deleteBytagId(CardTagBean2.getTagBean().getId());
//			
//			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} catch (RuntimeException ex) {
//			sessionFactory.getCurrentSession().getTransaction().rollback();
//			throw ex;
//		} finally {
//			((ConfigurableApplicationContext) context).close();
//		}
//
//	
//	}

	@Override
	public List<CardTagBean> selectBycardId(String cardId) {
		List<CardTagBean> result = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectBycardId);
		query.setParameter(0, cardId);
		result = query.list();
		return result;
	}

	@Override
	public List<CardTagBean> selectBytagId(int tagId) {
		List<CardTagBean> result = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectBytagId);
		query.setParameter(0, tagId);
		result = query.list();
		return result;
	}

	@Override
	public List<CardTagBean> insert(List<CardTagBean> beans) {
		Session session = this.getSession();
		if (beans != null) {
			for (CardTagBean bean : beans) {
				session.saveOrUpdate(bean);
			}
			return beans;
		}
		return beans;
	}

	@Override
	public boolean deleteBycardId(String cardId) {
		Session session = this.getSession();
		Query result = null;
		result = session.createQuery("from CardTagBean where cardId = ?");
		result.setParameter(0, cardId);
		if (result != null) {
			Query query = session.createQuery(deleteBycardId);
			query.setParameter(0, cardId);
			System.out.println("刪除筆數:" + query.executeUpdate());
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBytagId(int tagId) {
		Session session = this.getSession();
		Query result = null;
		result = session.createQuery("from CardTagBean where tagId = ?");
		result.setParameter(0, tagId);
		if (result != null) {
			Query query = session.createQuery(deleteBytagId);
			query.setParameter(0, tagId);
			System.out.println("刪除筆數:" + query.executeUpdate());
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String cardId, int tagId) {
		Session session = this.getSession();
		Query result = null;
		result = session.createQuery("from CardTagBean where cardId = ? AND tagId = ?");
		result.setParameter(0, cardId);
		result.setParameter(1, tagId);
		if (result != null) {
			Query query = session.createQuery(delete);
			query.setParameter(0, cardId);
			query.setParameter(1, tagId);
			System.out.println("刪除筆數:" + query.executeUpdate());
			return true;
		}
		return false;
	}

	@Override
	public List<CardTagBean> selectAll() {
		List<CardTagBean> result = null;
		Session session = this.getSession();
		session.beginTransaction();
		Query query = session.createQuery(selectAll);
		result = query.list();
		return result;
	}

}
