package com.eeit95.her.model.dao.font;

import java.io.File;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.eeit95.her.model.card.CardDescriptionBean;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontDescriptionBean;
import com.eeit95.her.model.font.FontDescriptionDAOInterface;

import hibernate.util.HibernateUtil;

public class FontDescriptionDAOHibernate implements FontDescriptionDAOInterface {
	
	private static final String DELETE = "delete from FontDescriptionBean where fontId =? ";
	private static final String SELECT_ID = "from FontDescriptionBean where fontId = ?";
	private static final String SELECT_ALL ="from FontDescriptionBean order by fontId";
	
	@Override
	public FontDescriptionBean insert(FontDescriptionBean fontDescriptionBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(fontDescriptionBean);
			session.getTransaction().commit();
			return fontDescriptionBean;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
			return null;
		}

	}

	@Override
	public FontDescriptionBean update(FontDescriptionBean fontDescriptionBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(fontDescriptionBean);
			session.getTransaction().commit();
			return fontDescriptionBean;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(String fontId ) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		boolean result = false;
		try {
			session.beginTransaction();
			Query query = session.createQuery(DELETE);
			query.setParameter(0, fontId);
			System.out.println("刪除的筆數=" + query.executeUpdate());
			session.getTransaction().commit();
			result = true;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	@Override
	public List<FontDescriptionBean> selectById(String fontId) {
		List<FontDescriptionBean> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_ID);
			query.setParameter(0, fontId);
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	@Override
	public List<FontDescriptionBean> selectAll() {
		List<FontDescriptionBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_ALL);
			list = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public static void main(String[] args) {
		FontDescriptionDAOHibernate dao = new FontDescriptionDAOHibernate();
		List<FontDescriptionBean> list = dao.selectById("f01701110001");
		
		for (FontDescriptionBean bean :list) {
			System.out.print(bean.getFontBean().getId()+", ");
			System.out.print(bean.getFontBean().getName()+", ");
			System.out.print(bean.getOrderNo()+", ");
			System.out.print(bean.getText()+", ");
			System.out.print(bean.getImage());
			System.out.println();
		}
		

	}

}
