package com.eeit95.her.model.dao.font;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.Spring;

import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.eeit95.her.model.dao.advertisement.AdvertisementDAOHibernate;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontDAOInterface;
import com.eeit95.her.model.font.WriterBean;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Repository
public class FontDAOHibernate implements FontDAOInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public String getNewId() {
		Session session = this.getSession();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
		String newsNo = "f" + df.format(new Date()).substring(1, 8);
		System.out.println("newsNo = " + newsNo);
		String temp2 = null;
		String temp3 = null;
		Query query = session.createSQLQuery("SELECT top 1 f.id from font as f order by id desc");
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

	@Override
	public FontBean insert(FontBean fontBean) {
		if (fontBean != null) {
			FontBean result = (FontBean) this.getSession().get(FontBean.class, fontBean.getId());
			if (result == null) {
				this.getSession().save(fontBean);
				return fontBean;
			}
		}
		return null;
	}

	@Override
	public FontBean update(FontBean fontBean) {
		FontBean result = this.getSession().get(FontBean.class, fontBean.getId());
		if (result != null) {
			result.setName(fontBean.getName());
			result.setPrice(fontBean.getPrice());
			result.setWriterId(fontBean.getWriterId());
			result.setCover(fontBean.getCover());
			result.setViewCount(fontBean.getViewCount());
			result.setSalesCount(fontBean.getSalesCount());
			result.setStatus(fontBean.getStatus());
		}
		return result;
	}

	@Override
	public boolean deleteById(String id) {
		FontBean bean = this.getSession().get(FontBean.class, id);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

	@Override
	public FontBean selectById(String id) {
		FontBean result = null;
		List<FontBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(FontBean.class);
		criteria.add(Restrictions.eq("id", id));
		list = criteria.list();
		if (!list.isEmpty()) {
			result = list.get(0);
		}
		return result;
	}

	@Override
	public FontBean selectByNAndW(FontBean fontBean) {
		List<FontBean> list = null;
		FontBean bean = null;
		Criteria criteria = this.getSession().createCriteria(FontBean.class);
		criteria.add(Restrictions.eq("name", fontBean.getName()));
		// criteria.add(Restrictions.eq("writerId",fontBean.getWriterBean().getId()));
		list = criteria.list();
		bean = list.get(0);
		return bean;
	}

	@Override
	public List<FontBean> selectWithBetween(String column, double low, double high) {
		List<FontBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(FontBean.class);
		criteria.addOrder(Order.asc("id"));
		criteria.add(Restrictions.between(column, low, high));
		criteria.add(Restrictions.eq("status", 1));
		list = criteria.list();
		return list;
	}

	@Override
	public List<FontBean> selectWithBetween(String column, int low, int high) {
		List<FontBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(FontBean.class);
		criteria.addOrder(Order.asc("id"));
		criteria.add(Restrictions.between(column, low, high));
		criteria.add(Restrictions.eq("status", 1));
		list = criteria.list();
		return list;
	}

	@Override
	public List<FontBean> selectTopN(int topN, String column, String ascOrDesc) {
		List<FontBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(FontBean.class);
		if ("desc".equalsIgnoreCase(ascOrDesc)) {
			criteria.addOrder(Order.desc(column));
		} else {
			criteria.addOrder(Order.asc(column));
		}
		criteria.add(Restrictions.eq("status", 1));
		// criteria.setMaxResults(topN);
		list = criteria.list();
		return list;
	}

	@Override
	public List<FontBean> select(String id, String name, double lowPrice, double highPrice, int writerId, int status,
			String column, String ascOrDesc) {
		List<FontBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(FontBean.class);
		if (id != null && id.length() != 0) {
			criteria.add(Restrictions.eq("id", id));
		}
		if (name != null && name.length() != 0) {
			criteria.add(Restrictions.like("name", "%" + name + "%"));
		}
		if(highPrice!=0) {
			criteria.add(Restrictions.between("price", lowPrice, highPrice));
		}
		

		if (writerId != 0) {
			criteria.add(Restrictions.eq("writerId", writerId));
			// criteria.add(Restrictions.sqlRestriction("{alias}.writerId = ?", writerId,
			// IntegerType.INSTANCE));
		}
		if (column != null) {
			if ("desc".equalsIgnoreCase(ascOrDesc)) {
				criteria.addOrder(Order.desc(column));
			} else {
				criteria.addOrder(Order.asc(column));
			}
		} else {
			if ("desc".equalsIgnoreCase(ascOrDesc)) {
				criteria.addOrder(Order.desc("id"));
			} else {
				criteria.addOrder(Order.asc("id"));
			}
		}
		if(status==1) {
			criteria.add(Restrictions.eq("status", 1));
		}else if(id ==null && status==0) { //要注意 請多注意 查ID
			criteria.add(Restrictions.eq("status", 0));
		}
		list = criteria.list();
		return list;
	}

	@Override
	public List<FontBean> selectAllOrderBySales() {
		List<FontBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(FontBean.class);
		criteria.addOrder(Order.desc("salesCount"));
		criteria.add(Restrictions.eq("status", 1));
		list = criteria.list();
		return list;
	}

	@Override
	public List<FontBean> selectAllOrderByPrice(String ascOrDesc) {
		List<FontBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(FontBean.class);
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
	public List<FontBean> selectAll() {
		List<FontBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(FontBean.class);
		list = criteria.list();
		return list;
	}

	@Override
	public List<FontBean> selectAllStatus(boolean tOrF) {
		List<FontBean> list = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(FontBean.class);
		criteria.addOrder(Order.asc("id"));
		if (tOrF) {
			criteria.add(Restrictions.eq("status", 1));
		} else {
			criteria.add(Restrictions.eq("status", 0));
		}
		list = criteria.list();
		return list;
	}

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		FontDAOHibernate dao = (FontDAOHibernate) context.getBean("fontDAOHibernate");

		// FontBean bean = new FontBean();

		// List<FontBean> list = dao.selectWithBetween("viewCount", 10,1000);
		// List<FontBean> list = dao.selectTopN(2, "price" , "desc");

		try {
			sessionFactory.getCurrentSession().beginTransaction();

			String id = null;
			String name = null;
			double lowPrice = 0;
			double highPrice = 0;
			int writerId = 1;
			int status = 1;
			String column = "price";
			String ascOrDesc = "desc";
			List<FontBean> list1 = dao.select(id, name, lowPrice, highPrice, writerId,status , column, ascOrDesc);
			for (FontBean bean : list1) {
				System.out.print(bean.getId() + ",");
				System.out.print(bean.getName() + ",");
				System.out.print(bean.getPrice() + ",");
				System.out.print(bean.getCover() + ",");
				System.out.print(bean.getViewCount() + ",");
				System.out.print(bean.getSalesCount() + ",");
				System.out.print(bean.getStatus() + ",");
				System.out.print(bean.getWriterId());
				System.out.println();
			}
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException ex) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}

		// try {
		// sessionFactory.getCurrentSession().beginTransaction();
		// List<FontBean> list = dao.selectAllStatus(true);
		// for (FontBean bean : list) {
		// System.out.print(bean.getId() + ",");
		// System.out.print(bean.getName() + ",");
		// System.out.print(bean.getPrice() + ",");
		// System.out.print(bean.getCover() + ",");
		// System.out.print(bean.getViewCount() + ",");
		// System.out.print(bean.getSalesCount() + ",");
		// System.out.print(bean.getStatus() + ",");
		// System.out.print(bean.getWriterBean().getId() + ",");
		// System.out.print(bean.getWriterBean().getName() + ",");
		// System.out.print(bean.getWriterBean().getCover() + ",");
		// System.out.print(bean.getWriterBean().getDescription());
		// System.out.println();
		// }
		// sessionFactory.getCurrentSession().getTransaction().commit();
		// } catch (RuntimeException ex) {
		// sessionFactory.getCurrentSession().getTransaction().rollback();
		// }

	}

}
