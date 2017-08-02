package com.eeit95.her.model.dao.card;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.collections.ResettableIterator;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardDescriptionBean;
import com.eeit95.her.model.card.CardDescriptionDAOInterface;
import hibernate.util.HibernateUtil;

public class CardDescriptionDAOhibernate implements CardDescriptionDAOInterface {

//	private static final String Delete = "delete from CardDescriptionBean where cardId = ?";

	public static void main(String[] args) {
		CardDescriptionDAOhibernate cddj = new CardDescriptionDAOhibernate();
		

		// Select 一筆cardID
		CardBean cardBean = new CardBean();
		cardBean.setId("c01701010001");
	
		List<CardDescriptionBean> beans = cddj.selectById(cardBean);
		for (CardDescriptionBean bean : beans) {
			System.out.println(bean.getCardBean().getName());
			System.out.println(bean.getCardBean().getId());
			System.out.println(bean.getOrderNo());
			System.out.println(bean.getCardBean().getId());
		}
//		// 修改cardId
//		CardBean cardBean1 = new CardBean();
//		cardBean1.setId("c01707280001");
//		for (CardDescriptionBean bean : beans) {
//			bean.setCardBean(cardBean1);
//		}
//		for (CardDescriptionBean bean : beans) {
//			System.out.println(bean);
//		}
//
//		System.out.println("=======================================================");
//		cddj.insert(beans);
//		beans = cddj.selectById(cardBean1);
//		for (CardDescriptionBean bean : beans) {
//			System.out.println(bean);
//		}
//
//		System.out.println("=======================================================");
//
//		System.out.println(cddj.deleteBycardId("c01707280001"));

	}

	@Override
	public List<CardDescriptionBean> selectById(CardBean cardBean) {
		String Select_By_Id = "from CardDescriptionBean where cardId = ?";
		List<CardDescriptionBean> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery(Select_By_Id);
			query.setParameter(0, cardBean.getId());
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;

	}

	@Override
	public List<CardDescriptionBean> insert(List<CardDescriptionBean> beans) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			if (beans != null) {
				for (CardDescriptionBean bean : beans) {
					session.save(bean);
				}

				session.getTransaction().commit();
				return beans;
			}

		} catch (RuntimeException ex) {
			throw ex;
		}
		return beans;
	}
	@Override
	public boolean deleteBycardId(String cardId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String delete = "delete from card_description where cardId=? ";
		CardDescriptionBean result = null;
		try {
//			result = (CardDescriptionBean) session.get(CardDescriptionBean.class, cardId);
			if (cardId != null) {
				Query query = session.createSQLQuery(delete);
				query.setParameter(0, cardId);
				System.out.println("刪除筆數:" + query.executeUpdate());
				session.getTransaction().commit();
				return true;
			}
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return false;
	}

//	@Override
//	public boolean deleteById(String cardId, int orderNo) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		CardDescriptionBean result = null;
//		try {
//			Criteria query = session.createCriteria(CardDescriptionBean.class);
//			query.add(Restrictions.eq("cardId", cardId));
//			query.add(Restrictions.eq("orderNo", orderNo));
//			result = (CardDescriptionBean) query.uniqueResult();
//			// result = (CardDescriptionBean) session.get(CardDescriptionBean.class,
//			// cardId);
//			if (result != null) {
//				session.delete(result);
//				session.getTransaction().commit();
//				return true;
//			}
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return false;
//	}
}