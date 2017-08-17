package com.eeit95.her.model.dao.advertisement;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.eeit95.her.model.advertisement.AdvertisementBean;
import com.eeit95.her.model.advertisement.AdvertisementDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Repository
public class AdvertisementDAOHibernate implements AdvertisementDAOInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public AdvertisementBean insert(AdvertisementBean advertisementBean) {
		if (advertisementBean != null) {
			AdvertisementBean result = (AdvertisementBean) this.getSession().get(AdvertisementBean.class,
					advertisementBean.getId());
			if (result == null) {
				this.getSession().save(advertisementBean);
				return advertisementBean;
			}
		}
		return null;
	}

	@Override
	public AdvertisementBean update(AdvertisementBean advertisementBean) {
		if (advertisementBean != null) {
			AdvertisementBean result = (AdvertisementBean) this.getSession().get(AdvertisementBean.class,
					advertisementBean.getId());
			if (result != null) {
				result.setName(advertisementBean.getName());
				result.setImage(advertisementBean.getImage());
				result.setBeginDate(advertisementBean.getBeginDate());
				result.setEndDate(advertisementBean.getEndDate());
			}
			return result;
		}
		return null;

	}

	@Override
	public boolean delete(int id) {
		AdvertisementBean bean = (AdvertisementBean) this.getSession().get(AdvertisementBean.class, id);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

	@Override
	public AdvertisementBean selectById(int id) {
		return this.getSession().get(AdvertisementBean.class, id);
	}

	@Override
	public List<AdvertisementBean> select(int id, String name, Date selectBeginDate, Date selectEndDate) {
		Session session = this.getSession();
		List<AdvertisementBean> list = null;
		Criteria criteria = session.createCriteria(AdvertisementBean.class);
		if (id != 0) {
			criteria.add(Restrictions.ge("id", id));
		}
		if (!name.isEmpty()) {
			criteria.add(Restrictions.ge("name", name));
		}
		try {
			if (selectBeginDate != null) {
				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String s = sdf.format(selectBeginDate);
				System.out.println(s);
				java.sql.Date selectBegin = java.sql.Date.valueOf(s);
				criteria.add(Restrictions.ge("endDate", selectBegin));
			}
			if (selectEndDate != null) {
				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String s = sdf.format(selectEndDate);
				System.out.println(s);
				java.sql.Date selectEnd = java.sql.Date.valueOf(s);
				criteria.add(Restrictions.le("beginDate", selectEnd));
			}
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<AdvertisementBean> selectByDate() {
		Session session = this.getSession();
		List<AdvertisementBean> list = null;
		try {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String s = sdf.format(new Date());
			System.out.println(s);
			java.sql.Date today = java.sql.Date.valueOf(s);

			Criteria criteria = session.createCriteria(AdvertisementBean.class);
			criteria.add(Restrictions.ge("endDate", today));
			criteria.add(Restrictions.le("beginDate", today));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<AdvertisementBean> selectAll() {
		Criteria criteria = this.getSession().createCriteria(AdvertisementBean.class);
		List<AdvertisementBean> list = criteria.list();
		return list;
	}

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		AdvertisementDAOHibernate dao = (AdvertisementDAOHibernate) context.getBean("advertisementDAOHibernate");

		// boolean b = dao.delete(1);
		// System.out.println(b);
		// List<AdvertisementBean> list = dao.selectByDate();
		// for(AdvertisementBean bean: list) {
		// System.out.println(bean.getName());
		// }
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			AdvertisementBean advertisementBean = new AdvertisementBean();
			advertisementBean.setId(1);
			advertisementBean.setName("不快樂");
			dao.update(advertisementBean);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException ex) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
	}

}
