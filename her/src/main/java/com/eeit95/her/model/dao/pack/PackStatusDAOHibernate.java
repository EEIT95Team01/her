package com.eeit95.her.model.dao.pack;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.eeit95.her.model.pack.PackStatusBean;
import com.eeit95.her.model.pack.PackStatusDAOInterface;

import hibernate.util.HibernateUtil;

public class PackStatusDAOHibernate implements PackStatusDAOInterface {

	private String SELECT_ALL_STATEMENT = "from PackStatusBean";

	@Override
	public List<PackStatusBean> selectAll() {
		List<PackStatusBean> packStatusList = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();

			Query query = session.createQuery(SELECT_ALL_STATEMENT);
			packStatusList = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

		return packStatusList;
	}

	public static void main(String[] args) {
		PackStatusDAOHibernate dao = new PackStatusDAOHibernate();

		List<PackStatusBean> packStatusList = dao.selectAll();
		for (PackStatusBean bean : packStatusList) {
			System.out.println(bean.getPackStatus() + ", " + bean.getStatusName());
		}
	}

}
