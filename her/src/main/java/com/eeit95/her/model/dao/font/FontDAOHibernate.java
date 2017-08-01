package com.eeit95.her.model.dao.font;

import java.util.List;

import org.hibernate.*;

import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontDAOInterface;

import hibernate.util.HibernateUtil;

public class FontDAOHibernate implements FontDAOInterface {

	private static final String SELECT_ALL = "from FontBean order by id";
	
	@Override
	public void insert(FontBean fontBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(fontBean);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(FontBean fontBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(fontBean);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(String id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			FontBean fontBean = new FontBean();
			fontBean.setId(id);
			session.delete(fontBean);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public FontBean selectById(String id) {
		FontBean fontBean = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			fontBean = (FontBean) session.get(FontBean.class, id);
			session.getTransaction().commit();
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return fontBean;
	}

	@Override
	public List<FontBean> selectAll() {
		List<FontBean> list = null;
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
		FontDAOHibernate dao = new FontDAOHibernate();
//		FontBean bean = new FontBean();
		
		List<FontBean> list = dao.selectAll();
		for (FontBean bean : list) {
			System.out.print(bean.getId() + ",");
			System.out.print(bean.getName() + ",");
			System.out.print(bean.getPrice() + ",");
			System.out.print(bean.getCover() + ",");
			System.out.print(bean.getViewCount() + ",");
			System.out.print(bean.getSalesCount() + ",");
			System.out.print(bean.getStatus() + ",");
			System.out.print(bean.getWriterBean().getId() + ",");
			System.out.print(bean.getWriterBean().getName() + ",");
			System.out.print(bean.getWriterBean().getCover() + ",");
			System.out.print(bean.getWriterBean().getDescription());
			System.out.println();
		}

	}

}
