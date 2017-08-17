package com.eeit95.her.model.dao.tag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.dao.card.CardDAOhibernate;
import com.eeit95.her.model.misc.SpringJavaConfiguration;
import com.eeit95.her.model.tag.TagBean;
import com.eeit95.her.model.tag.TagDAOInterface;
import com.eeit95.her.model.tag.TagSelectBean;

@Repository
public class TagDAOhibernate implements TagDAOInterface {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private static final String selectAll = "from TagBean";
	private static final String Delete = "delete from TagBean where id = ?";

//	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//
//		TagDAOhibernate cdj = (TagDAOhibernate) context.getBean("tagDAOhibernate");
//		TagBean bean = null;
//		List<TagBean> list = null;
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
////			bean = cdj.selectById(8);
////			list = cdj.selectAll();
//
//			TagBean bean1 = new TagBean();
//			bean1.setName("Text~~~");
//			bean1.setDiscount(0.8);
////			bean.setName("text2!!!!");
//			cdj.insert(bean1);
////			cdj.update(bean);
////			cdj.delete(bean.getId());
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} catch (RuntimeException ex) {
//			sessionFactory.getCurrentSession().getTransaction().rollback();
//			throw ex;
//		} finally {
//			((ConfigurableApplicationContext) context).close();
//		}
////		for (TagBean bean : list) {
////			System.out.println(bean.getId());
////		}
//	}

	@Override
	public TagBean selectById(int id) {
		return this.getSession().get(TagBean.class, id);
	}

	@Override
	public boolean insert(TagBean bean) {
		Session session = this.getSession();
		if (bean != null) {
			TagBean result = session.get(TagBean.class, bean.getId());
			if (result == null) {
				session.save(bean);
				return true;
			}
		}
		return false;
		
	}

	@Override
	public boolean update(TagBean bean) {
		Session session = this.getSession();
		session.beginTransaction();
		TagBean result = session.get(TagBean.class, bean.getId());
		if (result != null) {
			result.setName(bean.getName());
			result.setDiscount(bean.getDiscount());
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		Session session = this.getSession();
		TagBean tagBean = session.get(TagBean.class, id);
		if (tagBean != null) {
			Query query = session.createQuery(Delete);
			query.setParameter(0, id);
			System.out.println("刪除筆數 :" + query.executeUpdate());
			return true;
		}
		return false;
	}

	@Override
	
	public List<TagBean> selectAll() {
		List<TagBean> list = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectAll);
		list = query.list();
		return list;

	}

	@Override
	public List<TagBean> selectFM(TagSelectBean tagSelectBean) {
		List<TagBean> list = null;
		Session session = this.getSession();
		Criteria query = session.createCriteria(TagBean.class);
		if(tagSelectBean.getId()!=0) {
			query.add(Restrictions.eq("tagId", tagSelectBean.getId()));
		}
		if(tagSelectBean.getName()!=null) {
			query.add(Restrictions.like("name", "%"+tagSelectBean.getName()+"%"));
		}
		query.add(Restrictions.between("discount", tagSelectBean.getLowDiscount(), tagSelectBean.getHighDiscount()));
		list = query.list();
		return list;
	}


}
