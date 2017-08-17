package com.eeit95.her.model.dao.card;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardDAOInterface;
import com.eeit95.her.model.card.CardDescriptionBean;
import com.eeit95.her.model.card.CardSelectBean;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Repository
public class CardDAOhibernate implements CardDAOInterface {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private static int n = 0;
	private static String type = null;
	private static final String selectAll = "from CardBean";
	private static final String Delete = "delete from CardBean where id=?";

	// public static void main(String[] args) {
	//
	// ApplicationContext context = new
	// AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
	// SessionFactory sessionFactory = (SessionFactory)
	// context.getBean("sessionFactory");
	//
	// CardDAOhibernate cdj = (CardDAOhibernate)
	// context.getBean("cardDAOhibernate");
	// CardBean bean = null;
	// List<CardBean> list = null;
	// try {
	// sessionFactory.getCurrentSession().beginTransaction();
	// list = cdj.selectAll();
	// bean = cdj.selectById("c01706010001");
	// sessionFactory.getCurrentSession().getTransaction().commit();
	// } catch (RuntimeException ex) {
	// sessionFactory.getCurrentSession().getTransaction().rollback();
	// }
	//
	// for (CardBean o : list) {
	// System.out.println(o.getId());
	// }
	// System.out.println("id:" + bean.getId() + " name:" + bean.getName());
	// bean.setId("c01707280009");

	// System.out.println("INSERT 一筆資料 & PRINT");
	//
	// CardBean bean1 = null;
	// try {
	// sessionFactory.getCurrentSession().beginTransaction();
	// bean1 = cdj.insert(bean);
	// sessionFactory.getCurrentSession().getTransaction().commit();
	// System.out.println("11111");
	// } catch (RuntimeException ex) {
	// sessionFactory.getCurrentSession().getTransaction().rollback();
	// }
	// System.out.println("update");
	// bean.setName("我是測試2~~~~");
	// try {
	// sessionFactory.getCurrentSession().beginTransaction();
	// cdj.update(bean);
	// sessionFactory.getCurrentSession().getTransaction().commit();
	// } catch (RuntimeException ex) {
	// sessionFactory.getCurrentSession().getTransaction().rollback();
	// }

	// System.out.println(bean1);
	//
	// CardBean bean2 = null;
	// try {
	// sessionFactory.getCurrentSession().beginTransaction();
	// bean2 = cdj.selectById("c01707280009");
	// sessionFactory.getCurrentSession().getTransaction();
	// }catch (RuntimeException ex) {
	// sessionFactory.getCurrentSession().getTransaction().rollback();
	// }
	//
	//
	// System.out.println("id:"+bean2.getId()+" name:"+bean2.getName());

	// SELECT 一筆資料 & PRINT
	// Query query = session.createQuery(selectAll);
	// List<CardBean> list = query.list();
	// for(CardBean o :list) {
	// System.out.println(o.getId());
	// }

	// System.out.println("==================");
	// CardBean bean = cdj.selectById("c01706010001");

	// System.out.println("===================================================");
	//
	// // INSERT 一筆資料 & PRINT
	// bean.setId("c01707280005");
	// bean = cdj.insert(bean);
	// System.out.println("INSERT 一筆資料 & PRINT");
	// System.out.println(bean);

	// System.out.println("===================================================");
	//
	// // UPDATE 一筆資料 & PRINT
	// bean.setName("史奴比");
	// System.out.println("snoopy");
	// cdj.update(bean);
	// System.out.println("UPDATE 一筆資料 & PRINT");
	// System.out.println(bean);
	//
	// System.out.println("===================================================");

	// DELETE 一筆資料 & PRINT
	// System.out.println("DELETE 一筆資料 & PRINT");
	// try {
	// sessionFactory.getCurrentSession().beginTransaction();
	// cdj.delete("c0170728009");
	// sessionFactory.getCurrentSession().getTransaction().commit();
	// } catch (RuntimeException ex) {
	// sessionFactory.getCurrentSession().getTransaction().rollback();
	// }
	// cdj.delete("c01707280001");
	//
	// System.out.println("===================================================");

	// // SELECT TopN & PRINT
	// List<CardBean> result = cdj.selectTopN(5, "viewCount", "asc");
	// System.out.println("SELECT 所有資料 & PRINT");
	// for (CardBean bean1 : result) {
	// System.out.println(bean1);
	// }

	// System.out.println("===================================================");
	//
	// // // SELECT 所有資料 & PRINT

	// System.out.println("selectWithBetween");
	// try {
	// sessionFactory.getCurrentSession().beginTransaction();
	// list = cdj.selectWithBetween("price", 45.0, 55.0, "asc");
	// sessionFactory.getCurrentSession().getTransaction().commit();
	// } catch (RuntimeException ex) {
	// sessionFactory.getCurrentSession().getTransaction().rollback();
	// }
	//
	// System.out.println("SELECT Between & PRINT");
	// for (CardBean bean1 : list) {
	// System.out.println(bean1);
	// Set<CardDescriptionBean> desc =bean1.getDesc();
	// for(CardDescriptionBean BEAN2:desc) {
	// System.out.println(BEAN2.getOrderNo());
	// }
	// }
	// //
	// // List<CardBean> beans1 = cdj.selectAll();
	// // System.out.println("SELECT 所有資料 & PRINT");
	// // for (CardBean bean1 : beans1) {
	// // System.out.println(bean1);
	// //// Set<CardDescriptionBean> desc =bean1.getDesc();
	// //// for(CardDescriptionBean BEAN2:desc) {
	// //// System.out.println(BEAN2);
	// //// }
	// // }
	//
	// List<CardBean> beansC =null;
	// List<CardBean> beansM =null;
	// CardSelectBean cardSelectBean=new CardSelectBean();
	// cardSelectBean.setHiStock(50);
	// try {
	// sessionFactory.getCurrentSession().beginTransaction();
	// beansC = cdj.selectAllFC(null, 0, 180, 45, 55, "desc", "viewCount");
	// beansM = cdj.selectAllFM(cardSelectBean);
	// sessionFactory.getCurrentSession().getTransaction().commit();
	// } catch (RuntimeException ex) {
	// sessionFactory.getCurrentSession().getTransaction().rollback();
	// }
	//
	// System.out.println("SELECT selectAllFC");
	// System.out.println(beansC.size());
	// for (CardBean bean1 : beansC) {
	// System.out.println(bean1);
	// Set<CardDescriptionBean> desc =bean1.getDesc();
	// for(CardDescriptionBean BEAN2:desc) {
	// System.out.println(BEAN2);
	// }
	// }
	//
	// System.out.println("SELECT selectAllFM");
	// System.out.println(beansM.size());
	// for (CardBean bean1 : beansM) {
	// System.out.println(bean1);
	// Set<CardDescriptionBean> desc = bean1.getDesc();
	// for (CardDescriptionBean BEAN2 : desc) {
	// System.out.println(BEAN2);
	// }
	// }
	//
	// }

	@Override
	public List<CardBean> selectTopN(int n, String type, String desc) {
		String Select_All_TopN = null;
		Select_All_TopN = "from CardBean where status = 1 ORDER BY " + type + " " + desc;
		System.out.println(Select_All_TopN);
		List<CardBean> result = null;
		Session session = this.getSession();
		session.beginTransaction();

		if (n > 0) {
			Query query = session.createQuery(Select_All_TopN);
			query.setMaxResults(n);
			result = query.list();
		} else {
			Query query = session.createQuery(Select_All_TopN);
			result = query.list();
		}
		return result;
	}

	@Override
	public List<CardBean> selectAll() {
		List<CardBean> list = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectAll);
		list = query.list();
		for (CardBean bean : list) {
			System.out.println(bean);
		}
		return list;

	}

	@Override
	public CardBean selectById(String id) {
		return this.getSession().get(CardBean.class, id);
	}

	@Override
	public CardBean insert(CardBean bean) {
		Session session = this.getSession();
		if (bean != null) {
			CardBean result = session.get(CardBean.class, bean.getId());
			if (result == null) {
				session.save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public CardBean update(CardBean bean) {
		System.out.println("into update");
		Session session = this.getSession();
		System.out.println("CardBean update.id = " + bean.getId());
		CardBean result = session.get(CardBean.class, bean.getId());
		System.out.println("11" + result);
		if (result != null) {
			// System.out.println("555555555");
			result.setName(bean.getName());
			result.setPrice(bean.getPrice());
			result.setCover(bean.getCover());
			result.setViewCount(bean.getViewCount());
			result.setSalesCount(bean.getSalesCount());
			result.setStatus(bean.getStatus());
			result.setManufacturer(bean.getManufacturer());
			result.setCost(bean.getCost());
			result.setGpratio(bean.getGpratio());
			result.setStock(bean.getStock());
			result.setMaxWordCount(bean.getMaxWordCount());
			// System.out.println("555555555");
		}
		return result;
	}

	@Override
	public boolean delete(String id) {
		Session session = this.getSession();
		CardBean bean = (CardBean) session.get(CardBean.class, id);
		if (bean != null) {
			session.delete(bean);
			return true;
		}
		return false;
	}

	@Override
	public List<CardBean> selectWithBetween(String type, double lo, double hi, String ascOrdesc) {
		Session session = this.getSession();
		List<CardBean> list = null;
		Criteria query = session.createCriteria(CardBean.class);
		query.add(Restrictions.between(type, lo, hi));
		query.add(Restrictions.eq("status", 1));
		if (ascOrdesc.equalsIgnoreCase("desc")) {
			query.addOrder(Order.desc(type));
		} else {
			query.addOrder(Order.asc(type));
		}
		list = query.list();
		return list;
	}

	@Override
	public List<CardBean> selectWithBetween(String type, int lo, int hi, String ascOrdesc) {
		Session session = this.getSession();
		List<CardBean> list = null;
		Criteria query = session.createCriteria(CardBean.class);
		query.add(Restrictions.between(type, lo, hi));
		query.add(Restrictions.eq("status", true));
		if (ascOrdesc.equalsIgnoreCase("desc")) {
			query.addOrder(Order.desc(type));
		} else {
			query.addOrder(Order.asc(type));
		}
		list = query.list();
		return list;
	}

	@Override
	public List<CardBean> selectAllFC(String name, int loWordCount, int hiWordCount, double loPrice, double hiPrice,
			String ascOrDesc, String column) {
		List<CardBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(CardBean.class);
		if (column != null && !column.isEmpty()) {
			if ("desc".equalsIgnoreCase(ascOrDesc)) {
				criteria.addOrder(Order.desc(column));
			} else {
				criteria.addOrder(Order.asc(column));
			}
			if (name != null) {
				criteria.add(Restrictions.like("name", "%name%"));
			}
		}
		criteria.add(Restrictions.between("maxWordCount", loWordCount, hiWordCount));
		criteria.add(Restrictions.between("price", loPrice, hiPrice));
		list = criteria.list();
		System.out.println("1111111");
		return list;
	}

	@Override
	public List<CardBean> selectAllFM(CardSelectBean cardSelectBean) {
		List<CardBean> list = null;
		System.out.println(cardSelectBean);
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(CardBean.class);
		if (cardSelectBean.getId() != null&&cardSelectBean.getId().length()!=0) {
			criteria.add(Restrictions.eq("id", cardSelectBean.getId()));
		}
		// criteria.add(Restrictions.eq("status", cardSelectBean.getStatus()));
		String name = cardSelectBean.getName();
		if (cardSelectBean.getName() != null && cardSelectBean.getName().trim().length() != 0) {
			criteria.add(Restrictions.like("name", "%" + name + "%"));
		}
		criteria.add(Restrictions.between("price", cardSelectBean.getLowPrice(), cardSelectBean.getHighPrice()));
		criteria.add(Restrictions.between("cost", cardSelectBean.getLowCost(), cardSelectBean.getHighCost()));
		list = criteria.list();

		return list;
	}

	@Override
	public List<CardBean> selectAllOrderBySales() {
		List<CardBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(CardBean.class);
		criteria.addOrder(Order.desc("salesCount"));
		criteria.add(Restrictions.eq("status", 1));
		list = criteria.list();
		return list;
	}

	@Override
	public List<CardBean> selectAllOrderByPrice(String ascOrDesc) {
		List<CardBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(CardBean.class);
		if ("desc".equalsIgnoreCase(ascOrDesc)) {
			criteria.addOrder(Order.desc("price"));
		} else {
			criteria.addOrder(Order.asc("price"));
		}
		criteria.add(Restrictions.eq("status", 1));
		list = criteria.list();
		return list;
	}

	@Override
	public List<CardBean> selectAllStatus(boolean tOrF) {
		List<CardBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(CardBean.class);
		criteria.addOrder(Order.asc("id"));
		if (tOrF) {
			criteria.add(Restrictions.eq("status", 1));
		} else {
			criteria.add(Restrictions.eq("status", 0));
		}
		list = criteria.list();
		return list;
	}

	@Override
	public String getNewId() {
		Session session = this.getSession();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
		String newsNo = "c" + df.format(new Date()).substring(1, 8);
		System.out.println("newsNo = " + newsNo);
		String temp2 = null;
		String temp3 = null;
		Query query = session.createSQLQuery("SELECT top 1 c.id from card as c order by id desc");
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

}
