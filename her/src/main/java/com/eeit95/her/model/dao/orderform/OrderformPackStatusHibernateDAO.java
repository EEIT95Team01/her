package com.eeit95.her.model.dao.orderform;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.eeit95.her.model.misc.SpringJavaConfiguration;
import com.eeit95.her.model.orderform.OrderformPackStatusBean;
import com.eeit95.her.model.orderform.OrderformPackStatusDAOInterface;



@Repository
public class OrderformPackStatusHibernateDAO implements OrderformPackStatusDAOInterface{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private static final String selectAll = "from OrderformPackStatusBean";
	
	@Override
	public List<OrderformPackStatusBean> selectAll() {
		
		List<OrderformPackStatusBean> result = null;
		Session session = this.getSession();
		//selectAll = "from GiftBean "
		Query query = session.createQuery(selectAll);
		result = query.list();
		return result;
		
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		OrderformPackStatusHibernateDAO dao = (OrderformPackStatusHibernateDAO) context.getBean("orderformPackStatusHibernateDAO");
		
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			
			//● 查詢-1 selectAll(0809測試成功)
			List<OrderformPackStatusBean> beans = dao.selectAll();
			for(OrderformPackStatusBean bean : beans) {
				System.out.println(bean.getPackStatus());
				System.out.println(bean.getStatusName());
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