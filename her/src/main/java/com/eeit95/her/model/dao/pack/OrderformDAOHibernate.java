package com.eeit95.her.model.dao.pack;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.eeit95.her.model.pack.OrderformBean;
import com.eeit95.her.model.pack.OrderformDAOInterface;

import hibernate.util.HibernateUtil;

public class OrderformDAOHibernate implements OrderformDAOInterface {
	
// Test start
	public static void main(String[] args) {
		OrderformDAOHibernate dao = new OrderformDAOHibernate();
		List<OrderformBean> orderformList = dao.selectByMIdAndStatus("m01707150001", 1);
		
		if(!orderformList.isEmpty()) {
			for(OrderformBean bean : orderformList) {
				System.out.println(bean.getDateCreated());
			}
		}
		
		orderformList = dao.select("o01707210001", "m01707150001", "2017-07-20", "2017-07-22", 2, 1);
		if(!orderformList.isEmpty()) {
			for(OrderformBean bean : orderformList) {
				System.out.println(bean.getDateCreated());
			}
		}
	}
// Test end
	
	private static final String SELECT_BY_MID_AND_STATUS = 
			"from OrderformBean where memberId = ? and paymentStatus = ?";

	@Override
	public List<OrderformBean> selectByMIdAndStatus(String memberId, int status) {
		List<OrderformBean> orderformList = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_MID_AND_STATUS);
			query.setParameter(0, memberId);
			query.setParameter(1, status);
			orderformList = query.list();
			session.getTransaction().commit();
		} catch(RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return orderformList;
	}

	@Override
	public List<OrderformBean> select(String id, String memberId, String lowDate, String highDate, int paymentMethod,
			int status) {
		List<OrderformBean> orderformList = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(OrderformBean.class);
			if(id != null)
				criteria.add(Restrictions.eq("id", id));
			if(memberId != null)
				criteria.add(Restrictions.eq("memberId", memberId));
			if(lowDate != null)
				criteria.add(Restrictions.ge("dateCreated", java.sql.Date.valueOf(lowDate)));
			if(highDate != null)
				criteria.add(Restrictions.le("dateCreated", java.sql.Date.valueOf(highDate)));
			if(paymentMethod != 0)
				criteria.add(Restrictions.eq("paymentMethod", paymentMethod));
			orderformList = criteria.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return orderformList;
	}

}
