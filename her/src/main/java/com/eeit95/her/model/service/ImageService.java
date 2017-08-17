package com.eeit95.her.model.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardDAOInterface;
import com.eeit95.her.model.dao.font.FontDAOHibernate;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Service
public class ImageService {

	// ApplicationContext context = new
	// AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
	// SessionFactory sessionFactory = (SessionFactory)
	// context.getBean("sessionFactory");

	@Autowired
	private FontDAOInterface fontDAO;

	@Autowired
	private CardDAOInterface cardDAO;

	// @Autowired
	// private FontDAOInterface fontDAO;

	// = (FontDAOHibernate) context.getBean("fontDAOHibernate");

	// FontDAOInterface fontDAO = new FontDAOHibernate();

	public CardBean selectById(CardBean cardBean) {

		CardBean result = cardDAO.selectById(cardBean.getId());
		return result;

	}

	public FontBean selectById(FontBean fontBean) {

		// try {
		// sessionFactory.getCurrentSession().beginTransaction();
		FontBean result = fontDAO.selectById(fontBean.getId());

		// sessionFactory.getCurrentSession().getTransaction().commit();
		return result;

		// } catch (RuntimeException ex) {
		// sessionFactory.getCurrentSession().getTransaction().rollback();
		// throw ex;
		// }

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
