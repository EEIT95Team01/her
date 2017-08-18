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
import com.eeit95.her.model.orderform.OrderformPackBean;
import com.eeit95.her.model.orderform.OrderformPackDAOInterface;

@Repository
public class OrderformPackHibernateDAO implements OrderformPackDAOInterface{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	private static final String delete = 
			"delete from OrderformPackBean where orderformId=? and packId=?";
	
	private static final String selectByOrderformId = 
			"from OrderformPackBean where orderformId = ?";
	
	private static final String selectByPackId = 
			"from OrderformPackBean where packId = ?";
	
	private static final String selectAll = 
			"from OrderformPackBean order by orderformId";
	
	
	@Override
	public OrderformPackBean insert(OrderformPackBean bean) {
		Session session = this.getSession();
		if(bean != null){
			session.save(bean);
			return bean;
		}
		return null;
	}



	@Override
	public OrderformPackBean update(OrderformPackBean bean) {
		Session session = this.getSession();
		OrderformPackBean result = new OrderformPackBean();
		if(result != null) {
			result.setOrderformId(bean.getOrderformId());
			result.setPackId(bean.getPackId());
			result.setTrackingNumber(bean.getTrackingNumber());
			result.setStatus(bean.getStatus());
			session.update(result);
			return result;
		}
		return result;
	}



	@Override
	public boolean delete(String orderformId, String packId) {
		Session session = this.getSession();
		Query result = null;
		result = session.createQuery("from OrderformPackBean where orderformId = ?");
		result.setParameter(0, orderformId);
		if(result != null) {
			Query query = session.createQuery(delete);
			query.setParameter(0, orderformId);
			query.setParameter(1, packId);
			System.out.println("刪除筆數:" + query.executeUpdate());
			return true;
		}
		return false;
	}



	@Override
	public List<OrderformPackBean> selectByOrderformId(String orderformId) {
		List<OrderformPackBean> result = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectByOrderformId);
		query.setParameter(0, orderformId);
		result = query.list();
		return result;
	}



	@Override
	public List<OrderformPackBean> selectByPackId(String packId) {
		List<OrderformPackBean> result = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectByPackId);
		query.setParameter(0, packId);
		result = query.list();
		return result;
	}



	@Override
	public List<OrderformPackBean> selectAll() {
		List<OrderformPackBean> result = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectAll);
		result = query.list();
		return result;
	}
	
	
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		OrderformPackHibernateDAO dao = (OrderformPackHibernateDAO) context.getBean("orderformPackHibernateDAO");
		
		try {
			sessionFactory.getCurrentSession().beginTransaction();

		//● 新增-1 insert(0810測試成功)
//		OrderformPackBean bean = new OrderformPackBean();
//		bean.setOrderformId("o01705160001");
//		bean.setPackId("p01707200001");
//		bean.setTrackingNumber("20170810001");
//		bean.setStatus(1);
//		dao.insert(bean);
			
		//● 修改-2 update(0810測試成功)
//		OrderformPackBean bean = new OrderformPackBean();
//		bean.setOrderformId("o01705160001");
//		bean.setPackId("p01707200001");
//		bean.setTrackingNumber("20170810003");
//		bean.setStatus(3);
//		System.out.println(dao.update(bean));
		
		//●刪除-3 delete(0810測試成功)
//		dao.delete("o01705160001", "p01707200001");	
			
		//●查詢-4 selectByOrderformId(0810測試成功)
//		List<OrderformPackBean> list = dao.selectByOrderformId("o01707210001");
//		for(OrderformPackBean bean :list) {
//			System.out.print(bean.getOrderformId()+ ",");
//			System.out.print(bean.getPackId()+ ",");
//			System.out.print(bean.getTrackingNumber()+ ",");
//			System.out.print(bean.getStatus()+ ",");
//			System.out.println();
//		}
		
		//●查詢-5 selectByPackId(0810測試成功)
//		List<OrderformPackBean> list = dao.selectByPackId("p01705150001");
//		for(OrderformPackBean bean :list) {
//			System.out.print(bean.getOrderformId()+ ",");
//			System.out.print(bean.getPackId()+ ",");
//			System.out.print(bean.getTrackingNumber()+ ",");
//			System.out.print(bean.getStatus()+ ",");
//			System.out.println();
//		}
		//●查詢-6 selectAll(0810測試成功)
		List<OrderformPackBean> list = dao.selectAll();	
		for(OrderformPackBean bean :list) {
			System.out.print(bean.getOrderformId()+ ",");
			System.out.print(bean.getPackId()+ ",");
			System.out.print(bean.getTrackingNumber()+ ",");
			System.out.print(bean.getStatus()+ ",");
			System.out.println();
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