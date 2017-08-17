package com.eeit95.her.model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eeit95.her.model.dao.font.FontDAOHibernate;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

public class AdminFontService {

	ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
	SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

	FontDAOInterface fontDAO = (FontDAOHibernate) context.getBean("fontDAOHibernate");

	// @auto
	// FontDAOInterface fontDAO = new FontDAOHibernate();

	public FontBean insert(FontBean fontBean) {

		FontBean result = null;

		try {
			sessionFactory.getCurrentSession().beginTransaction();

			result = new FontBean();
			if (fontBean != null) {
				FontBean bean = fontDAO.insert(fontBean);
				System.out.println(bean.getName());
				result = fontDAO.selectByNAndW(bean);

			}
			sessionFactory.getCurrentSession().getTransaction().commit();
			return result;

		} catch (RuntimeException ex) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw ex;
		}
	}

	public FontBean update(FontBean fontBean) {

		FontBean result = null;

		try {
			sessionFactory.getCurrentSession().beginTransaction();

			result = new FontBean();
			if (fontBean != null) {
				result = fontDAO.update(fontBean);
			}
			sessionFactory.getCurrentSession().getTransaction().commit();
			return result;

		} catch (RuntimeException ex) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw ex;
		}
	}

	public List<FontBean> select(FontBean bean) {
		List<FontBean> result = null;
		
		try {
			sessionFactory.getCurrentSession().beginTransaction();
		
		if (bean != null && bean.getId() != null) {
			FontBean temp = fontDAO.selectById(bean.getId());
			if (temp != null) {
				result = new ArrayList<FontBean>();
				result.add(temp);
			}
		} else {
			result = fontDAO.selectAll();
		}
		
		sessionFactory.getCurrentSession().getTransaction().commit();
		return result;
		
		} catch (RuntimeException ex) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw ex;
		}
	}

	public static void main(String[] args) {
		AdminFontService test = new AdminFontService();
		FontBean bean = new FontBean();
		bean.setId("f01701110001");
		// bean.setName("sfsfgg");
		// bean.setStatus(false);
		// test.insert(bean);

		List<FontBean> list = test.select(bean);
		for (FontBean f : list) {
			System.out.println(f.getId());
			System.out.println(f.getName());
			System.out.println(f.getPrice());
		}
	}

}
