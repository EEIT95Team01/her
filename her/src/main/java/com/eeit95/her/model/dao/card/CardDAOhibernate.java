package com.eeit95.her.model.dao.card;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardDAOInterface;
import com.eeit95.her.model.card.CardDescriptionBean;

import hibernate.util.HibernateUtil;


public class CardDAOhibernate implements CardDAOInterface {
	private static int n = 0;
	private static String type = null;
	private static final String selectAll = "from CardBean";
	private static final String Delete = "delete from CardBean where id=?";

	public static void main(String[] args) {

		CardDAOhibernate cdj = new CardDAOhibernate();

		// SELECT 一筆資料 & PRINT
		System.out.println("==================");
		CardBean bean = cdj.selectById("c01706010001");
		System.out.println("SELECT 一筆資料 & PRINT");
		System.out.println(bean);

//		System.out.println("===================================================");
//
//		// INSERT 一筆資料 & PRINT
//		bean.setId("c01707280001");
//		bean = cdj.insert(bean);
//		System.out.println("INSERT 一筆資料 & PRINT");
//		System.out.println(bean);
//
//		System.out.println("===================================================");
//
//		// UPDATE 一筆資料 & PRINT
//		bean.setName("史奴比");
//		System.out.println("snoopy");
//		cdj.update(bean);
//		System.out.println("UPDATE 一筆資料 & PRINT");
//		System.out.println(bean);
//
//		System.out.println("===================================================");

//		// DELETE 一筆資料 & PRINT
//		System.out.println("DELETE 一筆資料 & PRINT");
//		cdj.delete("c01707280001");
//		
//		System.out.println("===================================================");

//		// SELECT TopN & PRINT
		List<CardBean> result = cdj.selectAll(0,"viewCount","asc");
		System.out.println("SELECT 所有資料 & PRINT");
		for (CardBean bean1 : result) {
			System.out.println(bean1);
		}
		
//		System.out.println("===================================================");
//
//		// SELECT 所有資料 & PRINT
		List<CardBean> beans = cdj.selectBetween(40	,55);
		System.out.println("SELECT Between & PRINT");
		for (CardBean bean1 : beans) {
			System.out.println(bean1);
//			Set<CardDescriptionBean> desc =bean1.getDesc();
//			for(CardDescriptionBean BEAN2:desc) {
//				System.out.println(BEAN2);
//			}
		}
//		
//		List<CardBean> beans1 = cdj.selectAll();
//		System.out.println("SELECT 所有資料 & PRINT");
//		for (CardBean bean1 : beans1) {
//			System.out.println(bean1);
////			Set<CardDescriptionBean> desc =bean1.getDesc();
////			for(CardDescriptionBean BEAN2:desc) {
////				System.out.println(BEAN2);
////			}
//		}

	}

	@Override
	public List<CardBean> selectAll(int n,String type,String desc) {
		String Select_All_TopN = null;
		Select_All_TopN = "from CardBean where status = 1 ORDER BY " + type +" "+ desc;
		System.out.println(Select_All_TopN);
		List<CardBean> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			if(n>0) {
			Query query=session.createQuery(Select_All_TopN);
			query.setMaxResults(n);
			result = query.list();
			session.getTransaction().commit();
			}else {
				Query query=session.createQuery(Select_All_TopN);
				result = query.list();
				session.getTransaction().commit();
			}
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	@Override
	public List<CardBean> selectAll() {
		List<CardBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery(selectAll);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	@Override
	public CardBean selectById(String id) {
		CardBean bean = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			bean = (CardBean) session.get(CardBean.class, id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return bean;
	}

	@Override
	public CardBean insert(CardBean bean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			if (bean != null) {
				session.save(bean);
				session.getTransaction().commit();
				return bean;
			}
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return null;

	}

	@Override
	public CardBean update(CardBean bean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(bean);
			session.getTransaction().commit();
			if (bean != null)
				return bean;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;

		}
		return null;
	}

	@Override
	public boolean delete(String id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		CardBean result = null;
		try {
			result = (CardBean) session.get(CardBean.class, id);
			if (result != null) {
				Query query = session.createQuery(Delete);
				query.setParameter(0, id);
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
	public List<CardBean> selectBetween(double lo, double hi) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<CardBean> list = null;
		try {
			Criteria query = session.createCriteria(CardBean.class);
			query.add(Restrictions.between("price", lo,hi));
			list = query.list();
			session.getTransaction().commit();
			
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
		return list;
	}

}
