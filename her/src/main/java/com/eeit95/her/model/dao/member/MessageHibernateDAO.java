package com.eeit95.her.model.dao.member;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.eeit95.her.model.member.MemberBean;
import com.eeit95.her.model.member.MessageBean;
import com.eeit95.her.model.member.MessageDAOInterface;

import hibernate.util.HibernateUtil;

public class MessageHibernateDAO implements MessageDAOInterface {

	private static final String GET_ALL = "from MessageBean";



	@Override
	public void insert(MessageBean messageBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(messageBean);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}



	@Override
	public void update(MessageBean messageBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(messageBean);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			MessageBean mb = new MessageBean();
			mb.setId(id);
			session.delete(mb);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}



	@Override
	public MessageBean findByPrimaryKey(Integer id) {
		MessageBean mb = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			mb = (MessageBean) session.get(MessageBean.class, id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return mb;
	}



	@Override
	public List<MessageBean> getAll() {
		List<MessageBean> list = null;
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
		MessageHibernateDAO dao = new MessageHibernateDAO();
		long dateTime = System.currentTimeMillis();
		
		// 新增
		 MemberBean mb = new MemberBean();
		 mb.setId("M123");
		 
		
//		 MessageBean bean = new MessageBean();
//		 bean.setMemberbean(mb);
//		 bean.setName("八一測試");
//		 bean.setEmail("test@abc.com");
//		 bean.setTime(new Timestamp(dateTime));
//		 bean.setContent("ㄏㄏ來測試");
//		 dao.insert(bean);

		// 修改
//		 MessageBean bean = new MessageBean();
//		 bean.setId(4);
//		 bean.setMemberbean(mb);
//		 bean.setName("八一第二次測試");
//		 bean.setEmail("test@abc.com");
//		 bean.setTime(new Timestamp(dateTime));
//		 bean.setContent("ㄏㄏ來測試");
//		 dao.insert(bean);

		// 刪除
		// dao.delete(4);

		// 找單筆
//		 MessageBean mb=dao.findByPrimaryKey(2);
//		 System.out.print(mb.getId() + ",");
//		 System.out.print(mb.getMemberbean().getId() + ",");
//		 System.out.print(mb.getName() + ",");
//		 System.out.print(mb.getEmail() + ",");
//		 System.out.print(mb.getTime() + ",");
//		 System.out.print(mb.getContent() );

		// 查詢全部
		 List<MessageBean> list = dao.getAll();
		 for (MessageBean x : list) {
		 System.out.print(x.getId() + ",");
		 System.out.print(x.getMemberbean().getId() + ",");
		 System.out.print(x.getName() + ",");
		 System.out.print(x.getEmail() + ",");
		 System.out.print(x.getTime() + ",");
		 System.out.print(x.getContent() );
		 System.out.println();
		 }

	}

}
