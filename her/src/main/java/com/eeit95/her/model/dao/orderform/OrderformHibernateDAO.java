package com.eeit95.her.model.dao.orderform;

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
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.eeit95.her.model.misc.SpringJavaConfiguration;
import com.eeit95.her.model.orderform.OrderformBean;
import com.eeit95.her.model.orderform.OrderformDAOInterface;
import com.eeit95.her.model.pack.PackBean;

@Repository
public class OrderformHibernateDAO implements OrderformDAOInterface{
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	private String selectByMIdAndStatus = "from OrderformBean where id = ? and paymentStatus = ?";
	private String select = 
			"from OrderformBean where id = ? and paymentMethod = ? and paymentStatus = ? "
			+ "and (dateCreated between ? and ?)";
	
	@Override
	public OrderformBean insert (OrderformBean bean) {
		Session session = this.getSession();
		if(bean != null){
			System.out.println("我是DAO：" + bean.getId());
			OrderformBean result = session.get(OrderformBean.class, bean.getId());
			
			if(result == null) {	
				session.save(bean);
				return bean;
			}
		}
		return null;
	}
	
	@Override
	public List<OrderformBean> selectByMIdAndStatus(String id, int status) {
		
		List<OrderformBean> result = null;
		Session session = this.getSession();
		
		//from orderform where id = ? and paymentStatus = ?
		Query query = session.createQuery(selectByMIdAndStatus);
		query.setParameter(0, id);
		query.setParameter(1, status);
		result = query.list();
		
		return result;
		
	}

	@Override
	public List<OrderformBean> select
	(String id, String memberId, int status, String lowDate, String highDate) {
		
		List<OrderformBean> result = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(OrderformBean.class);
		if(!id.isEmpty()) {
			criteria.add(Restrictions.eq("id",id));
			System.out.println("id" +id);
		}
		if(!memberId.isEmpty()) {
			criteria.add(Restrictions.eq("memberId",memberId));
			System.out.println("memberId" +memberId);
		}
		if(status!=0) {
			criteria.add(Restrictions.eq("paymentStatus",status));
			System.out.println("status" +status);
		}
		if(!lowDate.isEmpty()) {
			criteria.add(Restrictions.ge("dateCreated",lowDate));
			System.out.println("lowDate" +lowDate);
		}
		if(!highDate.isEmpty()) {
			criteria.add(Restrictions.le("dateCreated",highDate));
			System.out.println("highDate" +highDate);
		}
		result = criteria.list();
		
		return result;
	}
	
	@Override
	 public String getNewId() {
	  Session session = this.getSession();
	  SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
	  String newNo = "o"+df.format(new Date()).substring(1, 8);
	  System.out.println("newNo = "+newNo);
	  String temp2= null;  
	  String temp3= null;
	  Query query = session.createSQLQuery("SELECT top 1 o.id from orderform as o order by id desc");
	  String no = (String) query.uniqueResult();
	  String temp =no.substring(1, 8);
	  System.out.println("temp = " +temp);
	  if(temp.equalsIgnoreCase(df.format(new Date()).substring(1, 8))) {
	   temp2=no.substring(no.length()-4);
	   System.out.println("temp2 = " +temp2);
	   int no2=Integer.parseInt(temp2);
	   temp3 = newNo+("000"+(no2+1)).substring(("000"+(no2+1)).length()-4);
	   System.out.println("temp3 = " +temp3);
	  }else {
	   temp3 = newNo+"0001";
	   System.out.println("temp3 = " +temp3);
	  }
	  return temp3;
	 }
	

//	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		OrderformHibernateDAO dao = (OrderformHibernateDAO) context.getBean("orderformHibernateDAO");
//		
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();

		//● 查詢-1 selectByMIdAndStatus(0809測試OK)
//		List<OrderformBean> beans = dao.selectByMIdAndStatus("o01705160001", 0);
//		for(OrderformBean bean : beans) {
//			System.out.println(bean.getId());
//			System.out.println(bean.getDateCreated());
//			System.out.println(bean.getPaymentMethod());
//			System.out.println(bean.getPaymentStatus());
//			System.out.println(bean.getNote());
//		}
			
		//● 查詢-2 select	(0809測試OK)
//		List<OrderformBean> beans = dao.select("o01707210001",2,1,"2017-07-01", "2017-07-30");
//		for(OrderformBean bean : beans) {
//			System.out.println(bean.getId());
//			System.out.println(bean.getDateCreated());
//			System.out.println(bean.getPaymentMethod());
//			System.out.println(bean.getPaymentStatus());
//			System.out.println(bean.getNote());
//		}
//			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} catch (RuntimeException ex) {
//			sessionFactory.getCurrentSession().getTransaction().rollback();
//			throw ex;
//		} finally {
//			((ConfigurableApplicationContext) context).close();
//		}

//	}
}