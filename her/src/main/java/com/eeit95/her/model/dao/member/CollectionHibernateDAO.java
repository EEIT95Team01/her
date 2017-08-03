package com.eeit95.her.model.dao.member;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.eeit95.her.model.member.CollectionBean;
import com.eeit95.her.model.member.CollectionDAOInterface;
import com.eeit95.her.model.member.MemberBean;

import hibernate.util.HibernateUtil;

public class CollectionHibernateDAO implements CollectionDAOInterface {

	private static final String GET_ALL = "from CollectionBean";
	private static final String GET_BY_MEMBERID = "from CollectionBean where memberId = ?";
	private static final String GET_BY_PRODUCTID = "from CollectionBean where productId = ?";
	private static final String GET_BY_KEY = "from CollectionBean where memberId = ? and productId = ?";
	private static final String UPDATE = "update CollectionBean set addTime=:addTime where memberId=:memberId and productId=:productId";

	@Override
	public void update(String memberId, String productId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			long dateTime = System.currentTimeMillis();
			session.beginTransaction();
			Query query = session.createQuery(UPDATE);
			query.setParameter("addTime", new Timestamp(dateTime));
			query.setParameter("memberId", memberId);
			query.setParameter("productId", productId);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String memberid) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		CollectionBean cb = null;
		try {
			session.beginTransaction();
			cb = (CollectionBean) session.get(CollectionBean.class, memberid);
			session.delete(cb);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void insert(CollectionBean collectionBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(collectionBean);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<CollectionBean> findByPrimaryKey(String memberid, String productid) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<CollectionBean> list = null;
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
	public List<CollectionBean> findByMemberId(String memberid) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<CollectionBean> list = null;
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
	public List<CollectionBean> findByProductId(String productid) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<CollectionBean> list = null;
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
	public List<CollectionBean> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<CollectionBean> list = null;
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

		CollectionHibernateDAO dao = new CollectionHibernateDAO();
		long dateTime = System.currentTimeMillis();
		MemberBean mb=new MemberBean();
		mb.setId("M123");

		// 新增
//		 CollectionBean bean = new CollectionBean();
//		 bean.setMemberbean(mb);
//		 bean.setProductId("c654");
//		 bean.setAddTime(new Timestamp(dateTime));
//		 dao.insert(bean);

		// 修改
//		dao.update("M123", "c123");

		// 刪除
		// dao.delete("M123");

		// 用memberId找資料
		// List<CollectionBean> MBLIST=dao.findByMemberId("M123");
		// for(CollectionBean cb : MBLIST){
		// System.out.print(cb.getMemberbean().getId()+",");
		// System.out.print(cb.getProductId()+",");
		// System.out.print(cb.getAddTime());
		// System.out.println();
		// }

		// 用productId找資料
		// List<CollectionBean> PLIST=dao.findByProductId("c123");
		// for(CollectionBean cb : PLIST){
		// System.out.print(cb.getMemberbean().getId()+",");
		// System.out.print(cb.getProductId()+",");
		// System.out.print(cb.getAddTime());
		// System.out.println();
		// }

		// 用PK找資料
		// List<CollectionBean> PKLIST=dao.findByPrimaryKey("M123","c123");
		// for(CollectionBean cb : PKLIST){
		// System.out.print(cb.getMemberbean().getId()+",");
		// System.out.print(cb.getProductId()+",");
		// System.out.print(cb.getAddTime());
		// System.out.println();
		// }

		// 查詢全部
		List<CollectionBean> list2 = dao.getAll();
		for (CollectionBean cb : list2) {
			System.out.print(cb.getMemberbean().getId() + ",");
			System.out.print(cb.getProductId() + ",");
			System.out.print(cb.getAddTime());
			System.out.println();
		}

	}

}
