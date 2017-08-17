package com.eeit95.her.model.dao.card;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

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

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardDescriptionBean;
import com.eeit95.her.model.card.CardDescriptionDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Repository
public class CardDescriptionDAOhibernate implements CardDescriptionDAOInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();

	}

//	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//
//		CardDescriptionDAOhibernate cddj = (CardDescriptionDAOhibernate) context.getBean("cardDescriptionDAOhibernate");
//
//		// Select 一筆cardID
//		CardBean cardBean = new CardBean();
//		cardBean.setId("c01701010001");
//		List<CardDescriptionBean> list = null;
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//
//			list = cddj.selectById(cardBean);
////			for (CardDescriptionBean bean : list) {
////				System.out.println("1:" + bean.getCardBean().getName());
////				System.out.println("2:" + bean.getCardBean().getId());
////				System.out.println("3:" + bean.getOrderNo());
////				System.out.println("4:" + bean.getCardBean().getId());
////				System.out.println("-------------------------");
////			}
//			List<CardDescriptionBean> list1 = new ArrayList<CardDescriptionBean>();
//			CardBean cardBean1 = new CardBean();
//			cardBean1.setId("c01707280009");
//
////			CardDescriptionBean CardDescriptionBean1 = new CardDescriptionBean();
////			CardDescriptionBean1.setCardBean(cardBean1);
////			CardDescriptionBean1.setOrderNo(1);
////			System.out.println(CardDescriptionBean1.getCardBean().getId() + CardDescriptionBean1.getOrderNo());
////
////			CardDescriptionBean CardDescriptionBean2 = new CardDescriptionBean();
////			CardDescriptionBean2.setCardBean(cardBean1);
////			CardDescriptionBean2.setOrderNo(2);
////			list1.add(CardDescriptionBean1);
////			list1.add(CardDescriptionBean2);
//
//			// for (CardDescriptionBean bean : list) {
//			// System.out.println(bean.getCardBean().getId()+","+bean.getOrderNo());
//			// }
//			//
//			System.out.println("=======================================================");
//
//			// insert
//			cddj.insert(list1);
//			System.out.println("=======================================================");
//			cddj.deleteBycardId("c01707280009");
//	
//             System.out.println("commit");
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} catch (RuntimeException ex) {
//			sessionFactory.getCurrentSession().getTransaction().rollback();
//			throw ex;
//		} finally {
//			((ConfigurableApplicationContext) context).close();
//		}
//
//		// for (CardDescriptionBean bean : list) {
//		// System.out.println(bean.getCardBean().getName());
//		// System.out.println(bean.getCardBean().getId());
//		// System.out.println(bean.getOrderNo());
//		// System.out.println(bean.getCardBean().getId());
//		// }
//		// 修改cardId
//		// CardBean cardBean1 = new CardBean();
//		// cardBean1.setId("c01707280006");
//		// for (CardDescriptionBean bean : list) {
//		// bean.setCardBean(cardBean1);
//		// }
//		// for (CardDescriptionBean bean : list) {
//		// System.out.println(bean.getCardBean().getId()+","+bean.getOrderNo());
//		// }
//		// //
////		System.out.println("=======================================================");
//
//		// list = cddj.selectById(cardBean1);
//		// for (CardDescriptionBean bean : list) {
//		// System.out.println(bean.getCardBean().getId()+","+bean.getOrderNo());
//		// }
//		//
//		// System.out.println("=======================================================");
//		//
//		// boolean delete=true;
//		// try {
//		// sessionFactory.getCurrentSession().beginTransaction();
//		// System.out.println("66666666666666");
//		// delete = cddj.deleteBycardId("c01707280005");
//		// sessionFactory.getCurrentSession().getTransaction().commit();
//		// } catch (RuntimeException ex) {
//		// sessionFactory.getCurrentSession().getTransaction().rollback();
//		// }
//		// System.out.println(delete);
//
//	}

	@Override
	public List<CardDescriptionBean> selectById(String cardId) {
		String Select_By_Id = "from CardDescriptionBean where cardId = ?";
		System.out.println("CardDescription  1"+Select_By_Id);
		List<CardDescriptionBean> result = null;
		System.out.println("CardDescription  2");
		Session session = this.getSession();
		System.out.println("CardDescription  3");
		Query query = session.createQuery(Select_By_Id);
		System.out.println("CardDescription  4");
		query.setParameter(0, cardId);
		System.out.println("CardDescription  5");
		result = query.list();
		System.out.println("CardDescription  6"+result.toString());
		return result;
	}

	@Override
	public List<CardDescriptionBean> insert(List<CardDescriptionBean> beans) {
		Session session = this.getSession();
		System.out.println("111111111111111111");
		if (beans != null) {
			System.out.println("2222222222222222 beans:"+beans.size());
			for (CardDescriptionBean bean : beans) {
				System.out.println("33333333333333333333:"+bean);
				System.out.println("33333333333333333333:"+session.getTransaction().getStatus());

				session.saveOrUpdate(bean);
				System.out.println("44444444444444444444");
			}
		}
		return beans;
	}

	@Override
	public boolean deleteBycardId(String cardId) {
		Session session = this.getSession();
		String delete = "delete from card_description where cardId=? ";
////		System.out.println("2222222222222222222222");
//
////		System.out.println("333333333333333333333333333");
//		Criteria criteria = session.createCriteria(CardDescriptionBean.class);
//		System.out.println("444444444444444444444444444444444444");
//		criteria.add(Restrictions.eq("cardId", cardId));
//		System.out.println("555555555555555555555555555555555555");
//		List<CardDescriptionBean> result = criteria.list();
//		System.out.println("*******************");
		if (cardId != null) {
			System.out.println("*******************");
			Query query = session.createSQLQuery(delete);
			query.setParameter(0, cardId);
			System.out.println("刪除筆數:" + query.executeUpdate());
			return true;
		}
		return false;
	}

	// @Override
	// public boolean deleteById(String cardId, int orderNo) {
	// Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	// session.beginTransaction();
	// CardDescriptionBean result = null;
	// try {
	// Criteria query = session.createCriteria(CardDescriptionBean.class);
	// query.add(Restrictions.eq("cardId", cardId));
	// query.add(Restrictions.eq("orderNo", orderNo));
	// result = (CardDescriptionBean) query.uniqueResult();
	// // result = (CardDescriptionBean) session.get(CardDescriptionBean.class,
	// // cardId);
	// if (result != null) {
	// session.delete(result);
	// session.getTransaction().commit();
	// return true;
	// }
	// } catch (RuntimeException ex) {
	// session.getTransaction().rollback();
	// throw ex;
	// }
	// return false;
	// }
}