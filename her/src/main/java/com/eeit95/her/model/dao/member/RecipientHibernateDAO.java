package com.eeit95.her.model.dao.member;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.eeit95.her.model.member.MemberBean;
import com.eeit95.her.model.member.RecipientBean;
import com.eeit95.her.model.member.RecipientDAO_interface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Repository
public class RecipientHibernateDAO implements RecipientDAO_interface {

	@Autowired
	private SessionFactory sessionFactory;

	public RecipientHibernateDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private static final String GET_ALL = "from RecipientBean";
	private static final String FIND_RECIPIENT_BY_MEMBERID = "from RecipientBean where memberId = ?";
	private static final String DELETE_BY_MEMBERID ="delete from RecipientBean where memberId = ?";

	@Override
	public RecipientBean insert(RecipientBean recipientBean) {
		if (recipientBean != null) {
			RecipientBean rb = this.getSession().get(RecipientBean.class, recipientBean.getId());
			if (rb == null) {
				this.getSession().save(recipientBean);
				return recipientBean;
			}
		}
		return null;
	}

	@Override
	public RecipientBean update(RecipientBean recipientBean) {
		if (recipientBean != null) {
			RecipientBean rb = this.getSession().get(RecipientBean.class, recipientBean.getId());
			if (rb != null) {
				rb.setMemberId(recipientBean.getMemberId());
				rb.setName(recipientBean.getName());
				rb.setPhone(recipientBean.getPhone());
				rb.setCity(recipientBean.getCity());
				rb.setDistrict(recipientBean.getDistrict());
				rb.setAddr(recipientBean.getAddr());
				rb.setBirthday(recipientBean.getBirthday());
				this.getSession().save(rb);
				return rb;
			}
		}
		return null;
	
	}

	@Override
	public boolean delete(RecipientBean recipientBean) {
		RecipientBean rb = (RecipientBean)this.getSession().get(RecipientBean.class, recipientBean.getId());
		if(rb!=null){
			this.getSession().delete(rb);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteByMemberId(String memberId) {
		MemberBean mb = (MemberBean)this.getSession().get(MemberBean.class, memberId);
		if(mb!=null){
			Query query = this.getSession().createQuery(DELETE_BY_MEMBERID);
			query.setParameter(0, memberId);
			int count = query.executeUpdate();
			if(count==0){
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public RecipientBean findByPrimaryKey(String id) {
		RecipientBean rb = this.getSession().get(RecipientBean.class, id);
		if (rb != null) {
			return rb;
		}
		return null;
	}

	@Override
	public List<RecipientBean> findByMemberId(String memberId) {
		List<RecipientBean> list = null;

		MemberBean rb = this.getSession().get(MemberBean.class, memberId);
		if (rb != null) {
			Query query = this.getSession().createQuery(FIND_RECIPIENT_BY_MEMBERID);
			query.setParameter(0, rb.getId());
			list = query.list();

			return list;
		}

		return null;
	}
	
	

	@Override
	public String getNewId() {
		Session session = this.getSession();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
		String newsNo = "r" + df.format(new Date()).substring(1, 8);
		System.out.println("newsNo = " + newsNo);
		String temp2 = null;
		String temp3 = null;
		Query query = session.createSQLQuery("SELECT top 1 r.id from recipient as r order by id desc");
		String no = (String) query.uniqueResult();
		String temp = no.substring(1, 8);
		System.out.println("temp = " + temp);
		if (temp.equalsIgnoreCase(df.format(new Date()).substring(1, 8))) {
			temp2 = no.substring(no.length() - 4);
			System.out.println("temp2 = " + temp2);
			int no2 = Integer.parseInt(temp2);
			temp3 = newsNo + ("000" + (no2 + 1)).substring(("000" + (no2 + 1)).length() - 4);
			System.out.println("temp3 = " + temp3);
		} else {
			temp3 = newsNo + "0001";
			System.out.println("temp3 = " + temp3);
		}
		return temp3;
	}
	
	
	
//
//	public static void main(String[] args) {
//
//		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//
//		RecipientHibernateDAO dao = new RecipientHibernateDAO(sessionFactory);
//		
//		
//		MemberBean mb=new MemberBean();
//		mb.setId("M123");
//		
//		RecipientBean rb = new RecipientBean();
//		rb.setId("R0806");;
//		rb.setMemberId(mb);
//		rb.setName("Jack");
//		rb.setPhone("09123");
//		rb.setCity("ox市");
//		rb.setDistrict("xy區");
//		rb.setAddr("你心裡");
//		rb.setBirthday(java.sql.Date.valueOf("2012-12-31"));
//		
//		
//		// // 用會員ID查詢連絡人
//		// try {
//		// sessionFactory.getCurrentSession().beginTransaction();
//		//
//		// List<RecipientBean> list = dao.findByMemberId("M000test");
//		//
//		// sessionFactory.getCurrentSession().getTransaction().commit();
//		//
//		// for (RecipientBean x : list) {
//		// System.out.println(x);
//		// }
//		// } catch (HibernateException e) {
//		// sessionFactory.getCurrentSession().getTransaction().rollback();
//		// e.printStackTrace();
//		// }
//
//		// 用連絡人ID查單筆資料
//		// try {
//		// sessionFactory.getCurrentSession().beginTransaction();
//		//
//		// RecipientBean rb = dao.findByPrimaryKey("test");
//		//
//		// sessionFactory.getCurrentSession().getTransaction().commit();
//		//
//		// System.out.println(rb);
//		// } catch (HibernateException e) {
//		// sessionFactory.getCurrentSession().getTransaction().rollback();
//		// e.printStackTrace();
//		// }
//		
//		
//		//新增連絡人資料
////		 try {
////		 sessionFactory.getCurrentSession().beginTransaction();
////		 dao.insert(rb);
////		 sessionFactory.getCurrentSession().getTransaction().commit();
////		 
////		 System.out.println(rb);
////		 } catch (HibernateException e) {
////		 sessionFactory.getCurrentSession().getTransaction().rollback();
////		 e.printStackTrace();
////		 }
//		
//		//修改連絡人資料
////		 try {
////		 sessionFactory.getCurrentSession().beginTransaction();
////		 dao.update(rb);
////		 sessionFactory.getCurrentSession().getTransaction().commit();
////		 
////		 System.out.println(rb);
////		 } catch (HibernateException e) {
////		 sessionFactory.getCurrentSession().getTransaction().rollback();
////		 e.printStackTrace();
////		 }
//		
//		//刪除單筆連絡人資料
////		 try {
////		 sessionFactory.getCurrentSession().beginTransaction();
////		 boolean x=dao.delete("某個recipientId");
////		 sessionFactory.getCurrentSession().getTransaction().commit();
////		 
////		 System.out.println(x);
////		 } catch (HibernateException e) {
////		 sessionFactory.getCurrentSession().getTransaction().rollback();
////		 e.printStackTrace();
////		 }
//		
//		//刪除某個會員的所有聯絡人資料
////		 try {
////		 sessionFactory.getCurrentSession().beginTransaction();
////		 
////		 boolean x = dao.deleteByMemberId("某個MemberId");
////		 
////		 sessionFactory.getCurrentSession().getTransaction().commit();
////		 
////		 System.out.println(x);
////		 } catch (HibernateException e) {
////		 sessionFactory.getCurrentSession().getTransaction().rollback();
////		 e.printStackTrace();
////		 }	
//		
//
//		((ConfigurableApplicationContext) context).close();
//
//	}

}
