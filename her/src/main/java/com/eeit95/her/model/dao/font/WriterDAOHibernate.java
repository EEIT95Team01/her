package com.eeit95.her.model.dao.font;

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
import com.eeit95.her.model.dao.advertisement.AdvertisementDAOHibernate;
import com.eeit95.her.model.font.WriterBean;
import com.eeit95.her.model.font.WriterDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Repository
public class WriterDAOHibernate implements WriterDAOInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public WriterBean insert(WriterBean writerBean) {
		if (writerBean != null) {
			WriterBean result = (WriterBean) this.getSession().get(WriterBean.class, writerBean.getId());
			if (result == null) {
				this.getSession().save(writerBean);
				return writerBean;
			}
		}
		return null;
	}

	@Override
	public WriterBean update(WriterBean writerBean) {
		WriterBean result = (WriterBean) this.getSession().get(WriterBean.class, writerBean.getId());
		if (result != null) {
			result.setName(writerBean.getName());
			result.setCover(writerBean.getCover());
			result.setDescription(writerBean.getDescription());
		}
		return result;
	}

	@Override
	public boolean delete(int id) {
		WriterBean bean = (WriterBean) this.getSession().get(WriterBean.class, id);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

	@Override
	public WriterBean selectById(int id) {
		return this.getSession().get(WriterBean.class, id);
	}

	public List<WriterBean> selectByIdOrName(int id, String name) {
		Criteria criteria = this.getSession().createCriteria(WriterBean.class);
		if (id != 0) {
			criteria.add(Restrictions.eq("id", id));
		}
		if (!name.isEmpty()) {
			criteria.add(Restrictions.like("name", "%" + name + "%"));
		}
		List<WriterBean> list = criteria.list();
		return list;
	}

	@Override
	public List<WriterBean> selectAll() {
		Criteria criteria = this.getSession().createCriteria(WriterBean.class);
		List<WriterBean> list = criteria.list();
		return list;
	}

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		WriterDAOHibernate dao = (WriterDAOHibernate) context.getBean("writerDAOHibernate");

		// WriterBean wbean = new WriterBean();
		// wbean.setName("fdsfsf");
		// WriterBean www = dao.insert(wbean);
		// System.out.println(www.getName());
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			List<WriterBean> list = dao.selectAll();
			for (WriterBean bean : list) {
				System.out.print(bean.getId() + ",");
				System.out.print(bean.getName() + ",");

				System.out.println();
			}
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException ex) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}

	}

}
