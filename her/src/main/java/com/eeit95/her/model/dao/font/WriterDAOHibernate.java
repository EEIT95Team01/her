package com.eeit95.her.model.dao.font;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.eeit95.her.model.font.WriterBean;
import com.eeit95.her.model.font.WriterDAOInterface;

import hibernate.util.HibernateUtil;

public class WriterDAOHibernate implements WriterDAOInterface {
	
	private static final String SELECT_ALL = "from WriterBean order by id";
	@Override
	public WriterBean insert(WriterBean writerBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(writerBean);
			session.getTransaction().commit();
			return writerBean;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
			return null;	
		}
	}

	@Override
	public WriterBean update(WriterBean writerBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(writerBean);
			session.getTransaction().commit();
			return writerBean;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
			return null;	
		}
		
	}

	@Override
	public boolean delete(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		boolean result = false;
		try {
			session.beginTransaction();
			WriterBean writerBean = new WriterBean();
			writerBean.setId(id);
			session.delete(writerBean);
			session.getTransaction().commit();
			result = true;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	@Override
	public WriterBean selectById(int id) {
		WriterBean writerBean = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			writerBean = (WriterBean) session.get(WriterBean.class, id);
			session.getTransaction().commit();
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return writerBean;
	}

	@Override
	public List<WriterBean> selectAll() {
		List<WriterBean> list = null;
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
		WriterDAOHibernate dao = new WriterDAOHibernate();
//		WriterBean wbean = new WriterBean();
//		wbean.setName("fdsfsf");
//		WriterBean www = dao.insert(wbean);
//		System.out.println(www.getName());
		List<WriterBean> list = dao.selectAll();
		for (WriterBean bean : list) {
			System.out.print(bean.getId() + ",");
			System.out.print(bean.getName() + ",");
			
			System.out.println();
		}

	}

}
