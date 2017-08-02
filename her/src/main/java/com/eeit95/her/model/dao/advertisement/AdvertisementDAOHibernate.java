package com.eeit95.her.model.dao.advertisement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import com.eeit95.her.model.advertisement.AdvertisementBean;
import com.eeit95.her.model.advertisement.AdvertisementDAOInterface;
import com.eeit95.her.model.font.FontBean;

import hibernate.util.HibernateUtil;

public class AdvertisementDAOHibernate implements AdvertisementDAOInterface {

	private static final String SELECT_ALL ="from AdvertisementBean order by id";
	
	@Override
	public AdvertisementBean insert(AdvertisementBean advertisementBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(advertisementBean);
			session.getTransaction().commit();
			return advertisementBean;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public AdvertisementBean update(AdvertisementBean advertisementBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(advertisementBean);
			session.getTransaction().commit();
			return advertisementBean;
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
			AdvertisementBean advertisementBean = new AdvertisementBean();
			advertisementBean.setId(id);
			session.delete(advertisementBean);
			session.getTransaction().commit();
			result = true;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	@Override
	public AdvertisementBean selectById(int id) {
		AdvertisementBean advertisementBean = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			advertisementBean = (AdvertisementBean) session.get(AdvertisementBean.class, id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return advertisementBean;
	}

	@Override
	public List<AdvertisementBean> selectByDate() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<AdvertisementBean> list = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String s = sdf.format(new Date());
			java.sql.Date today = java.sql.Date.valueOf(s);
			session.beginTransaction();
			Criteria criteria = session.createCriteria(AdvertisementBean.class);
			criteria.add(Restrictions.ge("endDate", today));
			criteria.add(Restrictions.le("beginDate", today));
			list = criteria.list();
			session.getTransaction().commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<AdvertisementBean> selectAll() {
		List<AdvertisementBean> list = null;
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
		AdvertisementDAOHibernate dao = new AdvertisementDAOHibernate();
//		boolean b = dao.delete(1);
//		System.out.println(b);
		List<AdvertisementBean> list = dao.selectAll();
		for(AdvertisementBean bean: list) {
			System.out.println(bean.getName());
		}
	}

}
