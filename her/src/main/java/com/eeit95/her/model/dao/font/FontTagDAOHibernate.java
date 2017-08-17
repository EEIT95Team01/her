package com.eeit95.her.model.dao.font;

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

import com.eeit95.her.model.font.FontTagBean;
import com.eeit95.her.model.font.FontTagDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Repository
public class FontTagDAOHibernate implements FontTagDAOInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public FontTagBean insert(FontTagBean fontTagBean) {
		if (fontTagBean != null) {
			Criteria criteria = this.getSession().createCriteria(FontTagBean.class);
			criteria.add(Restrictions.eq("fontId", fontTagBean.getFontId()));
			criteria.add(Restrictions.eq("tagId", fontTagBean.getTagId()));
			List<FontTagBean> list = criteria.list();
			if (list.isEmpty()) {
				this.getSession().save(fontTagBean);
				return fontTagBean;
			}
		}
		return null;
	}

	
	
	@Override
	public boolean insert(List<FontTagBean> fontTagBeans) {
		boolean result = false;
		if(!fontTagBeans.isEmpty()) {
			for(FontTagBean bean : fontTagBeans) {
//				Criteria criteria = this.getSession().createCriteria(FontTagBean.class);
//				criteria.add(Restrictions.eq("fontId", bean.getFontId()));
//				criteria.add(Restrictions.eq("tagId", bean.getTagId()));
//				List<FontTagBean> list = criteria.list();
				if(bean!=null) {
					this.getSession().saveOrUpdate(bean);
				}else {
					return false;
				}
			}
			return true;
		}else {
			return false;	
		}
		
	}

	@Override
	public boolean delete(String fontId, int tagId) {
		Criteria criteria = this.getSession().createCriteria(FontTagBean.class);
		criteria.add(Restrictions.eq("fontId", fontId));
		criteria.add(Restrictions.eq("tagId", tagId));
		List<FontTagBean> list = criteria.list();
		if(!list.isEmpty()) {
			FontTagBean bean = list.get(0);
			this.getSession().delete(bean);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<FontTagBean> selectByFontId(String fontId) {
		List<FontTagBean> result = null;
		Session session = this.getSession();
//		Criteria criteria = session.createCriteria(FontTagBean.class);
//		criteria.add(Restrictions.eq("fontId", fontId));
//		result = criteria.list();
		String Select_By_FontId = "from FontTagBean where fontId = ?";
		Query query = session.createQuery(Select_By_FontId);
		query.setParameter(0, fontId);
		result = query.list();
		
		return result;
	}

	@Override
	public List<FontTagBean> selectByTagId(int tagId) {
		List<FontTagBean> result = null;
		Session session = this.getSession();
//		Criteria criteria = session.createCriteria(FontTagBean.class);
//		criteria.add(Restrictions.eq("tagId", tagId));
//		result = criteria.list();
		String Select_By_TagId = "from FontTagBean where tagId = ?";
		Query query = session.createQuery(Select_By_TagId);
		query.setParameter(0, tagId);
		result = query.list();
		return result;
	}

	@Override
	public List<FontTagBean> selectAll() {
		List<FontTagBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(FontTagBean.class);
//		criteria.addOrder(Order.asc("fontId"));
//		criteria.addOrder(Order.asc("tagId"));
		list = criteria.list();
		return list;
	}

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		FontTagDAOHibernate dao = (FontTagDAOHibernate) context.getBean("fontTagDAOHibernate");

		// List<FontTagBean> list = dao.selectByFontId("f01705110001");

		try {
			sessionFactory.getCurrentSession().beginTransaction();
			List<FontTagBean> list = dao.selectByTagId(1);
			for (FontTagBean bean : list) {
				System.out.print(bean.getFontId() + ", ");
				System.out.print(bean.getTagId());
				System.out.println();
			}
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException ex) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
	}

}
