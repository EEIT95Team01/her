package com.eeit95.her.model.dao.member;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.eeit95.her.model.member.HistoryBean;
import com.eeit95.her.model.member.HistoryDAOInterface;
import com.eeit95.her.model.member.MemberBean;

import hibernate.util.HibernateUtil;

public class HistoryHibernateDAO implements HistoryDAOInterface {

	private static final String GET_ALL = "from HistoryBean";
	private static final String GET_BY_MEMBERID = "from HistoryBean where memberId = ?";
	private static final String GET_BY_PRODUCTID = "from HistoryBean where productId = ?";
	private static final String GET_BY_KEY = "from HistoryBean where memberId = ? and productId = ?";

	@Override
	public void delete(String memerid) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		HistoryBean mb = null;
		try {
			session.beginTransaction();
			mb = (HistoryBean) session.get(HistoryBean.class, memerid);
			session.delete(mb);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void insert(HistoryBean historyBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(historyBean);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<HistoryBean> findByPrimaryKey(String memberid, String productid) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		HistoryBean mb = null;
		List<HistoryBean> list = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_BY_KEY);
			query.setParameter(0, memberid);
			query.setParameter(1, productid);
			list = query.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<HistoryBean> findByMemberId(String memberid) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<HistoryBean> list = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_BY_MEMBERID);
			query.setParameter(0, memberid);
			list = query.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<HistoryBean> findByProductId(String productid) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<HistoryBean> list = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_BY_PRODUCTID);
			query.setParameter(0, productid);
			list = query.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<HistoryBean> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<HistoryBean> list = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL);
			list = query.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return list;
	}

	// 以下為測試程式
	public static void main(String[] args) {

		HistoryHibernateDAO dao = new HistoryHibernateDAO();
		long dateTime = System.currentTimeMillis();
		MemberBean mb = new MemberBean();
		mb.setId("M456");

		// 新增
//		 HistoryBean bean = new HistoryBean();
//		 bean.setMemberbean(mb);
//		 bean.setProductId("TEST0803");
//		 bean.setViewtime(new Timestamp(dateTime));
//		 dao.insert(bean);

		// 刪除
		// dao.delete("M123");

		// 用memberId找資料
		// List<HistoryBean> MBLIST=dao.findByMemberId("M123");
		// for(HistoryBean hb : MBLIST){
		// System.out.print(hb.getMemberbean().getId()+",");
		// System.out.print(hb.getProductId()+",");
		// System.out.print(hb.getViewtime());
		// System.out.println();
		// }

		// 用productId找資料
		// List<HistoryBean> PLIST=dao.findByProductId("c123");
		// for(HistoryBean hb : PLIST){
		// System.out.print(hb.getMemberbean().getId()+",");
		// System.out.print(hb.getProductId()+",");
		// System.out.print(hb.getViewtime());
		// System.out.println();
		// }

		// 用PK找資料
//		 List<HistoryBean> PKLIST=dao.findByPrimaryKey("M123","c123");
//		 for(HistoryBean hb : PKLIST){
//		 System.out.print(hb.getMemberbean().getId()+",");
//		 System.out.print(hb.getProductId()+",");
//		 System.out.print(hb.getViewtime());
//		 System.out.println();
//		 }

		// 查詢全部
		List<HistoryBean> list2 = dao.getAll();
		for (HistoryBean hb : list2) {
			System.out.print(hb.getMemberbean().getId() + ",");
			System.out.print(hb.getProductId() + ",");
			System.out.print(hb.getViewtime());
			System.out.println();
		}

	}

}
