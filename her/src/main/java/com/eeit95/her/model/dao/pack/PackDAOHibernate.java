package com.eeit95.her.model.dao.pack;

import java.text.ParseException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.eeit95.her.model.pack.PackBean;
import com.eeit95.her.model.pack.PackDAOInterface;

import hibernate.util.HibernateUtil;

public class PackDAOHibernate implements PackDAOInterface {
	
	private final static String SELECT_BY_MID_AND_STATUS = 
			"from PackBean where memberId = ? and status = ?";

	public static void main(String[] args) throws ParseException {
		PackDAOHibernate dao = new PackDAOHibernate();
		List<PackBean> packList = dao.selectByMIdAndStatus("m01701150001", 1);
		for(PackBean packBean : packList) {
			System.out.println(packBean.getName());
		}
		
		PackBean bean = new PackBean();
		bean = dao.selectById("p01704150001");
		System.out.println(bean.getName());
		
//		boolean deleteResult = dao.deleteById("p01703150002");
//		System.out.println(deleteResult);
		
		String low = "2017-07-01", high = "2017-12-31";
		
		packList = dao.selectWithBetween("dateMailed", low, high, "asc");
		for(PackBean packbean : packList) {
			System.out.println(packbean.getName());
		}
		
		packList = dao.selectWithBetween("cardPrice", 30d, 45d, "desc");
		for(PackBean packbean : packList) {
			System.out.println(packbean.getName());
		}
	}
	
	@Override
	public List<PackBean> selectByMIdAndStatus(String memberId, int status) {
		List<PackBean> packList = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_MID_AND_STATUS);
			query.setParameter(0, memberId);
			query.setParameter(1, status);
			packList = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return packList;
	}

	@Override
	public PackBean selectById(String id) {
		PackBean packBean = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			packBean = (PackBean) session.get(PackBean.class, id);
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return packBean;
	}
	
	@Override
	public List<PackBean> selectWithBetween(String column, Double low, Double high, String ascOrDesc) {
		List<PackBean> packList = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(PackBean.class);
			criteria.add(Restrictions.between(column, low, high));
			if("DESC".equalsIgnoreCase(ascOrDesc)) 
				criteria.addOrder(Order.desc(column));
			else 
				criteria.addOrder(Order.asc(column));	
			packList = criteria.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return packList;
	}
	
	@Override
	public List<PackBean> selectWithBetween(String column, String low, String high, String ascOrDesc) {
		List<PackBean> packList = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(PackBean.class);
			
			criteria.add(Restrictions.between(column, 
					java.sql.Date.valueOf(low), java.sql.Date.valueOf(high)));
			
			if("DESC".equalsIgnoreCase(ascOrDesc)) 
				criteria.addOrder(Order.desc(column));
			else 
				criteria.addOrder(Order.asc(column));
			
			packList = criteria.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return packList;
	}

	@Override
	public PackBean insert(PackBean packBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			
			session.saveOrUpdate(packBean);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return packBean;
	}

	@Override
	public PackBean update(PackBean packBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			
			session.saveOrUpdate(packBean);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return packBean;
	}

	@Override
	public boolean deleteById(String id) {
		boolean result = false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			
			PackBean packBean = (PackBean) session.get(PackBean.class, id);
			session.delete(packBean);
			
			session.getTransaction().commit();
			result = true;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return result;
	}

}
