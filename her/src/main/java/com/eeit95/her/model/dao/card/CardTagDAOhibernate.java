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

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardTagBean;
import com.eeit95.her.model.card.CardTagBean;
import com.eeit95.her.model.card.CardTagBean;
import com.eeit95.her.model.card.CardTagInterface;
import hibernate.util.HibernateUtil;
import com.eeit95.her.model.tag.TagBean;

public class CardTagDAOhibernate implements CardTagInterface {
	private static final String selectBycardId = "from CardTagBean where cardId = ?";
	private static final String selectBytagId = "from CardTagBean where tagId = ?";
	private static final String deleteBycardId = "delete from CardTagBean where cardId = ?";
	private static final String deleteBytagId = "delete from CardTagBean where tagId = ?";
	private static final String delete = "delete from CardTagBean where cardId = ? AND tagId = ?";
	private static final String selectAll = "from CardTagBean";

	public static void main(String[] args) {
		
		CardTagDAOhibernate cto = new CardTagDAOhibernate();
		 //select cardId & print
		 System.out.println("select cardId & print");
	
		 List<CardTagBean> beans = cto.selectBycardId("c01701010001");
		 for (CardTagBean bean:beans) {
			 System.out.println("CardTagBean [cardId=" + bean.getCardBean().getName() + ", tagId=" + bean.getTagBean().getName() + "]");
		 }
//		 System.out.println("========================================");
//		 //select tagId & print
//		 System.out.println("select tagId & print");
//		 List<CardTagBean> beans1 = cto.selectBytagId(2);
//		 for (CardTagBean bean:beans1) {
//		 System.out.println("CardTagBean [cardId=" + bean.getCardId() + ", tagId=" + bean.getTagId() + "]");
//		 }
//		
//		 System.out.println("========================================");
//		 //insert & print
//		 System.out.println("insert & print");
//		 for (CardTagBean bean:beans1) {
//		 System.out.println("CardTagBean [cardId=" + bean.getCardId() + ", tagId=" + bean.getTagId() + "]");
//		 bean.setTagId(14);
//		 System.out.println("CardTagBean [cardId=" + bean.getCardId() + ", tagId=" + bean.getTagId() + "]");
//		 System.out.println("------------------------------------------------");
//		 }
//		 cto.insert(beans1);
//		 System.out.println("select tagId & print");
//		 List<CardTagBean> beans2 = cto.selectBytagId(13);
//		 for (CardTagBean bean:beans2) {
//			 System.out.println("CardTagBean [cardId=" + bean.getCardId() + ", tagId=" + bean.getTagId() + "]");
//		 }
//		 System.out.println("========================================");
//		 System.out.println(cto.delete("c01702010001",13));
//		 System.out.println(cto.delete("c01701010001",13));
//		 beans = cto.selectAll();
//		 for (CardTagBean bean:beans) {
//		 System.out.println("CardTagBean [cardId=" + bean.getCardId() + ", tagId=" + bean.getTagId() + "]");
//		 }
//		System.out.println("========================================");
//		System.out.println(cto.deleteBycardId("c01701010001"));
//		List<CardTagBean> beans3 = cto.selectAll();
//		for (CardTagBean bean : beans3) {
//			System.out.println("CardTagBean [cardId=" + bean.getCardId() + ", tagId=" + bean.getTagId() + "]");
//		}
//		 System.out.println("========================================");
//		 System.out.println(cto.deleteBytagId(14));
//		 List<CardTagBean> beans = cto.selectAll();
//		 for (CardTagBean bean:beans) {
//		 System.out.println("CardTagBean [cardId=" + bean.getCardId() + ", tagId=" + bean.getTagId() + "]");
//		 }
	}

	@Override
	public List<CardTagBean> selectBycardId(String cardId) {
		List<CardTagBean> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery(selectBycardId);
			query.setParameter(0, cardId);
			result = query.list();
			session.getTransaction().commit();
			
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	@Override
	public List<CardTagBean> selectBytagId(int tagId) {
		List<CardTagBean> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery(selectBytagId);
			query.setParameter(0, tagId);
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	@Override
	public List<CardTagBean> insert(List<CardTagBean> beans) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			if (beans != null) {
				for (CardTagBean bean : beans) {
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
		Query result = null;
		try {
			result = session.createQuery("from CardTagBean where cardId = ?");
			result.setParameter(0, cardId);
			if (result != null) {
				Query query = session.createQuery(deleteBycardId);
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

	@Override
	public boolean deleteBytagId(int tagId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query result = null;
		try {
			result = session.createQuery("from CardTagBean where tagId = ?");
			result.setParameter(0, tagId);
			if (result != null) {
				Query query = session.createQuery(deleteBytagId);
				query.setParameter(0, tagId);
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

	@Override
	public boolean delete(String cardId,int tagId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query result = null;
		try {
			result = session.createQuery("from CardTagBean where cardId = ? AND tagId = ?");
			result.setParameter(0, cardId);
			result.setParameter(1, tagId);
			if (result != null) {
				Query query = session.createQuery(delete);
				query.setParameter(0, cardId);
				query.setParameter(1, tagId);
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

	@Override
	public List<CardTagBean> selectAll() {
		List<CardTagBean> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(selectAll);
			result = query.list();
			if (!session.getTransaction().wasCommitted())
				session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

}
