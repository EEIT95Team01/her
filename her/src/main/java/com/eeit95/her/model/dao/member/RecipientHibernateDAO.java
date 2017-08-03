package com.eeit95.her.model.dao.member;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.eeit95.her.model.member.MemberBean;
import com.eeit95.her.model.member.RecipientBean;
import com.eeit95.her.model.member.RecipientDAOInterface;

import hibernate.util.HibernateUtil;

public class RecipientHibernateDAO implements RecipientDAOInterface {

	private static final String GET_ALL = "from RecipientBean";

	@Override
	public void insert(RecipientBean recipientBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(recipientBean);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void update(RecipientBean recipientBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(recipientBean);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			RecipientBean rb = new RecipientBean();
			rb.setId(id);
			session.delete(rb);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	@Override
	public RecipientBean findByPrimaryKey(String id) {
		RecipientBean rb = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			rb = (RecipientBean) session.get(RecipientBean.class, id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return rb;
	}

	@Override
	public List<RecipientBean> getAll() {
		List<RecipientBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
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

	public static void main(String[] args) {
		RecipientHibernateDAO dao = new RecipientHibernateDAO();

		// 新增
		MemberBean mb = new MemberBean();
		mb.setId("M000test");

		//
		// RecipientBean bean = new RecipientBean();
		// bean.setId("test");
		// bean.setMemberbean(mb);
		// bean.setName("七三一測試");
		// bean.setPhone("0912121212");
		// bean.setCity("台北");
		// bean.setDistrict("大安");
		// bean.setAddr("大安");
		// bean.setBirthday(java.sql.Date.valueOf("2017-7-31"));
		// dao.insert(bean);

		// 修改
		// RecipientBean bean = new RecipientBean();
		// bean.setId("test");
		// bean.setMemberbean(mb);
		// bean.setName("測試用");
		// bean.setPhone("098765432");
		// bean.setCity("台北");
		// bean.setDistrict("大安");
		// bean.setAddr("大安");
		// bean.setBirthday(java.sql.Date.valueOf("2017-7-31"));
		// dao.update(bean);

		// 刪除
		// dao.delete("r01704150002");

		// 找單筆
		// RecipientBean rb=dao.findByPrimaryKey("test");
		// System.out.print(rb.getId() + ",");
		// System.out.print(rb.getMemberbean().getId() + ",");
		// System.out.print(rb.getName() + ",");
		// System.out.print(rb.getPhone() + ",");
		// System.out.print(rb.getCity() + ",");
		// System.out.print(rb.getDistrict() + ",");
		// System.out.print(rb.getAddr() + ",");
		// System.out.print(rb.getBirthday()+",");
		// System.out.print(rb.getMemberbean().getId()+",");
		// System.out.print(rb.getMemberbean().getName()+",");
		// System.out.print(rb.getMemberbean().getEmail());

		// 查詢全部
		List<RecipientBean> list = dao.getAll();
		for (RecipientBean x : list) {
			System.out.print(x.getId() + ",");
			System.out.print(x.getName() + ",");
			System.out.print(x.getPhone() + ",");
			System.out.print(x.getCity() + ",");
			System.out.print(x.getDistrict() + ",");
			System.out.print(x.getAddr() + ",");
			System.out.print(x.getBirthday() + ",");
			System.out.print(x.getMemberbean().getId() + ",");
			System.out.print(x.getMemberbean().getName());
			System.out.println();
		}

	}

}
