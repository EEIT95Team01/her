package com.eeit95.her.model.dao.pack;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.eeit95.her.model.pack.OrderformPackStatusBean;
import com.eeit95.her.model.pack.OrderformPackStatusDAOInterface;

import hibernate.util.HibernateUtil;

public class OrderformPackStatusDAOHibernate implements OrderformPackStatusDAOInterface {

	private String SELECT_ALL_STATEMENT = "from OrderformPackStatusBean";

	@Override
	public List<OrderformPackStatusBean> selectAll() {
		List<OrderformPackStatusBean> orderformPackStatusList = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
			Query query = session.createQuery(SELECT_ALL_STATEMENT);
			orderformPackStatusList = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return orderformPackStatusList;
	}
	
	public static void main(String[] args) {
		OrderformPackStatusDAOHibernate dao = new OrderformPackStatusDAOHibernate();
		
		List<OrderformPackStatusBean> orderformPackStatusList = dao.selectAll();
		for(OrderformPackStatusBean orderformPackStatusBean : orderformPackStatusList) {
			System.out.println(orderformPackStatusBean.getPackStatus() + ", " + orderformPackStatusBean.getStatusName());
		}

	}

}
