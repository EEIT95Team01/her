package com.eeit95.her.model.dao.font;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.eeit95.her.model.font.FontDescriptionBean;
import com.eeit95.her.model.font.FontTagBean;
import com.eeit95.her.model.font.FontTagDAOInterface;
import com.eeit95.her.model.font.WriterBean;

import hibernate.util.HibernateUtil;

public class FontTagDAOHibernate implements FontTagDAOInterface {

	private static final String DELETE = "delete from FontTagBean where fontId =? and tagId = ?";
	private static final String SELECT_FONT_ID = "from FontTagBean where fontId = ? order by tagId";
	private static final String SELECT_TAG_ID = "from FontTagBean where tagId = ? order by fontId";
	private static final String SELECT_ALL ="from FontTagBean order by fontId , tagId";
	@Override
	public FontTagBean insert(FontTagBean fontTagBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(fontTagBean);
			session.getTransaction().commit();
			return fontTagBean;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public FontTagBean update(FontTagBean fontTagBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(fontTagBean);
			session.getTransaction().commit();
			return fontTagBean;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(String fontId, int tagId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		boolean result = false;
		try {
			session.beginTransaction();
			Query query = session.createQuery(DELETE);
			query.setParameter(0, fontId);
			query.setParameter(0, tagId);
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
	public List<FontTagBean> selectByFontId(String fontId) {
		List<FontTagBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_FONT_ID);
			query.setParameter(0, fontId);
			list = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	@Override
	public List<FontTagBean> selectByTagId(int tagId){
		List<FontTagBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_TAG_ID);
			list = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	@Override
	public List<FontTagBean> selectAll() {
		List<FontTagBean> list = null;
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
		FontTagDAOHibernate dao = new FontTagDAOHibernate();
		//List<FontTagBean> list = dao.selectByFontId("f01705110001");
		List<FontTagBean> list = dao.selectAll();
		for (FontTagBean bean :list) {
			System.out.print(bean.getFontBean().getId()+", ");
			System.out.print(bean.getTagBean().getId());
			System.out.println();
		}

	}

}
