package com.eeit95.her.model.dao.pack;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.eeit95.her.model.dao.category.CategoryHibernateDAO;
import com.eeit95.her.model.misc.SpringJavaConfiguration;
import com.eeit95.her.model.pack.PackStatusBean;
import com.eeit95.her.model.pack.PackStatusDAOInterface;

@Repository
public class PackStatusHibernateDAO implements PackStatusDAOInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	private static final String selectAll = "from PackStatusBean order by id";
	private static final String selectByPackStatus = "from PackStatusBean where packStatus = ?";

	@Override
	public List<PackStatusBean> selectAll() {
		List<PackStatusBean> result = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectAll);
		result = query.list();
		return result;
	}
	
	@Override
	public PackStatusBean selectByPackStatus(int packStatus) {
		PackStatusBean bean = null;
		Session session = this.getSession();
		if(bean.getPackStatus() != 0) {
		Query query = session.createQuery(selectByPackStatus);
		query.setParameter(0, packStatus);
		}
		return bean;
	}
	
	
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");	
		PackStatusHibernateDAO dao =(PackStatusHibernateDAO) context.getBean("packStatusHibernateDAO");

	try {
		sessionFactory.getCurrentSession().beginTransaction();
		
		//● 查詢-1 selectAll(0810測試OK)
		List<PackStatusBean> list = dao.selectAll();
		for(PackStatusBean bean : list) {
			System.out.print(bean.getPackStatus() + ": ");
			System.out.println(bean.getStatusName());
			System.out.println("--------");
		}
		
		
		sessionFactory.getCurrentSession().getTransaction().commit();
	} catch (RuntimeException ex) {
		sessionFactory.getCurrentSession().getTransaction().rollback();
		throw ex;
	} finally {
		((ConfigurableApplicationContext) context).close();
	}

}
}