package com.eeit95.her.model.dao.font;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontDAOInterface;

import hibernate.util.HibernateUtil;

public class FontDAOHibernate implements FontDAOInterface {

	private static final String SELECT_ALL = "from FontBean order by id";
	private static final String SELECT_TOPN = "from FontBean where status = 1 ORDER BY ? ,?" ;
	@Override
	public FontBean insert(FontBean fontBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(fontBean);
			session.getTransaction().commit();
			return fontBean;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public FontBean update(FontBean fontBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(fontBean);
			session.getTransaction().commit();
			return fontBean;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteById(String id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		boolean result = false;
		try {
			session.beginTransaction();
			FontBean fontBean = new FontBean();
			fontBean.setId(id);
			session.delete(fontBean);
			session.getTransaction().commit();
			result = true;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	@Override
	public FontBean selectById(String id) {
		FontBean fontBean = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			fontBean = (FontBean) session.get(FontBean.class, id);
			session.getTransaction().commit();
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return fontBean;
	}

	
	
	@Override
	public List<FontBean> selectWithBetween(String column, double low, double high) {
		List<FontBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(FontBean.class);
			criteria.addOrder(Order.asc("id"));
			criteria.add(Restrictions.between(column, low, high));
			list = criteria.list();
			session.getTransaction().commit();
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	@Override
	public List<FontBean> selectWithBetween(String column, int low, int high) {
		List<FontBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(FontBean.class);
			criteria.addOrder(Order.asc("id"));
			criteria.add(Restrictions.between(column, low, high));
			list = criteria.list();
			session.getTransaction().commit();
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	@Override
	public List<FontBean> selectTopN(int topN, String column, String ascOrDesc) {
		List<FontBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(FontBean.class);
			if("desc".equalsIgnoreCase(ascOrDesc)) {
				criteria.addOrder(Order.desc(column));
			}else {
				criteria.addOrder(Order.asc(column));
			}
			criteria.setMaxResults(topN);
			list = criteria.list();
			session.getTransaction().commit();
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	@Override
	public List<FontBean> selectAll() {
		List<FontBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_ALL);
			list = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public static void main(String[] args) {
		FontDAOHibernate dao = new FontDAOHibernate();
//		FontBean bean = new FontBean();
		
//		List<FontBean> list = dao.selectWithBetween("viewCount", 10,1000);
		List<FontBean> list = dao.selectTopN(2, "price" , "desc");
		for (FontBean bean : list) {
			System.out.print(bean.getId() + ",");
			System.out.print(bean.getName() + ",");
			System.out.print(bean.getPrice() + ",");
			System.out.print(bean.getCover() + ",");
			System.out.print(bean.getViewCount() + ",");
			System.out.print(bean.getSalesCount() + ",");
			System.out.print(bean.getStatus() + ",");
			System.out.print(bean.getWriterBean().getId() + ",");
			System.out.print(bean.getWriterBean().getName() + ",");
			System.out.print(bean.getWriterBean().getCover() + ",");
			System.out.print(bean.getWriterBean().getDescription());
			System.out.println();
		}

	}

}
