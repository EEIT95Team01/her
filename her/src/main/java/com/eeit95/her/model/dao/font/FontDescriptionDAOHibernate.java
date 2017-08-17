package com.eeit95.her.model.dao.font;

import java.io.File;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.eeit95.her.model.advertisement.AdvertisementBean;
import com.eeit95.her.model.card.CardDescriptionBean;
import com.eeit95.her.model.dao.advertisement.AdvertisementDAOHibernate;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontDescriptionBean;
import com.eeit95.her.model.font.FontDescriptionDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Repository
public class FontDescriptionDAOHibernate implements FontDescriptionDAOInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public FontDescriptionBean insert(FontDescriptionBean fontDescriptionBean) {
		if (fontDescriptionBean != null) {
			Criteria criteria = this.getSession().createCriteria(FontDescriptionBean.class);
			criteria.add(Restrictions.eq("fontId", fontDescriptionBean.getFontId()));
			criteria.add(Restrictions.eq("orderNo", fontDescriptionBean.getOrderNo()));
			List<FontDescriptionBean> list = criteria.list();
			if (list.isEmpty()) {
				this.getSession().save(fontDescriptionBean);
				return fontDescriptionBean;
			}
		}
		return null;

	}

	@Override
	public FontDescriptionBean update(FontDescriptionBean fontDescriptionBean) {
		Criteria criteria = this.getSession().createCriteria(FontDescriptionBean.class);
		criteria.add(Restrictions.eq("fontId", fontDescriptionBean.getFontId()));
		criteria.add(Restrictions.eq("orderNo", fontDescriptionBean.getOrderNo()));
		List<FontDescriptionBean> list = criteria.list();
		FontDescriptionBean result = list.get(0);
		if (result != null) {
			result.setText(fontDescriptionBean.getText());
			result.setImage(fontDescriptionBean.getImage());
		}
		return result;
	}

	@Override
	public boolean delete(String fontId) {
//		List<FontDescriptionBean> bean = this.getSession().get(FontDescriptionBean.class, fontId);
		List<FontDescriptionBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(FontDescriptionBean.class);
		criteria.add(Restrictions.eq("fontId", fontId));
		list = criteria.list();
		if (!list.isEmpty()) {
			for(FontDescriptionBean fontDescriptionBeans : list) {
				this.getSession().delete(fontDescriptionBeans);	
			}
			
			return true;
		}
		return false;
	}

	@Override
	public List<FontDescriptionBean> selectById(String fontId) {
		List<FontDescriptionBean> result = null;
		Session session = this.getSession();
//		Criteria criteria = session.createCriteria(FontDescriptionBean.class);
//		criteria.add(Restrictions.eq("fontId", fontBean));
//		result = criteria.list();
		String Select_By_Id = "from FontDescriptionBean where fontId = ?";
		Query query = session.createQuery(Select_By_Id);
		query.setParameter(0, fontId);
		result = query.list();
		return result;
	}

	@Override
	public List<FontDescriptionBean> selectAll() {
		List<FontDescriptionBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(FontDescriptionBean.class);
//		criteria.addOrder(Order.asc("fontId"));
//		criteria.addOrder(Order.asc("orderNo"));
		list = criteria.list();
		return list;
	}

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		FontDescriptionDAOHibernate dao = (FontDescriptionDAOHibernate) context.getBean("fontDescriptionDAOHibernate");

		try {
			sessionFactory.getCurrentSession().beginTransaction();
			List<FontDescriptionBean> list = dao.selectById("f01701110001");

			for (FontDescriptionBean bean : list) {
				System.out.print(bean.getFontId() + ", ");
				System.out.print(bean.getOrderNo() + ", ");
				System.out.print(bean.getText() + ", ");
				System.out.print(bean.getImage());
				System.out.println();
			}
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException ex) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}

	}

}
