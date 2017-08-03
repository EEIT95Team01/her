package com.eeit95.her.model.dao.member;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.eeit95.her.model.member.MemberBean;
import com.eeit95.her.model.member.MemberDAOInterface;
import com.eeit95.her.model.member.MessageBean;
import com.eeit95.her.model.member.RecipientBean;

import hibernate.util.HibernateUtil;

public class MemberHibernateDAO implements MemberDAOInterface {

	private static final String GET_ALL_STMT = "from MemberBean";

	@Override
	public void insert(MemberBean memberBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(memberBean);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	@Override
	public void update(MemberBean memberBean) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(memberBean);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			// 只要找某一筆的話↓
			MemberBean bean = (MemberBean) session.get(MemberBean.class, id);
			session.delete(bean);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	@Override
	public MemberBean findByPrimaryKey(String id) {
		MemberBean mb = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			// 只要找某一筆的話↓
			mb = (MemberBean) session.get(MemberBean.class, id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}

		return mb;
	}

	@Override
	public List<MemberBean> getAll() {
		List<MemberBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public Set<RecipientBean> getRecipientByMember(String id) {
		Set<RecipientBean> set = findByPrimaryKey(id).getRbs();
		return set;
	}

	@Override
	public Set<MessageBean> getMessageByMember(String id) {
		Set<MessageBean> set = findByPrimaryKey(id).getMbs();
		return set;
	}

	// 以下為測試程式
	public static void main(String[] args) {

		MemberHibernateDAO dao = new MemberHibernateDAO();

		// 新增
		// MemberBean bean = new MemberBean();
		// bean.setId("M000test");
		// bean.setEmail("0731test@google.com");
		// bean.setPassword("123");
		// bean.setName("米小鼠");
		// bean.setPhone("0912121212");
		// bean.setCity("台北");
		// bean.setDistrict("大安");
		// bean.setAddr("大安");
		// bean.setBirthday(java.sql.Date.valueOf("2017-7-31"));
		// dao.insert(bean);

		// 修改
		// MemberBean bean = new MemberBean();
		// bean.setId("M000test");
		// bean.setEmail("test0731@google.com");
		// bean.setPassword("123");
		// bean.setName("測試用0731");
		// bean.setPhone("0912121212");
		// bean.setCity("台北");
		// bean.setDistrict("大安");
		// bean.setAddr("大安");
		// bean.setBirthday(java.sql.Date.valueOf("2017-7-31"));
		// dao.update(bean);

		// 刪除(超級強大 小心使用)
		// dao.delete("M000test");

		// 找單筆會員
		// MemberBean mb = dao.findByPrimaryKey("m01704150001");
		// System.out.print(mb.getId()+ ",");
		// System.out.print(mb.getName()+",");
		// System.out.print(mb.getEmail());

		// 查詢全部會員
		// List<MemberBean> list2 = dao.getAll();
		// for (MemberBean mb : list2) {
		// System.out.print(mb.getId() + ",");
		// System.out.print(mb.getEmail() + ",");
		// System.out.print(mb.getName());
		// System.out.println();
		// }

		// --------------------------------------

		// 找單筆會員的連絡人
		// MemberBean mb = dao.findByPrimaryKey("m01704150001");
		// System.out.print(mb.getId()+ ",");
		// System.out.print(mb.getName()+",");
		// System.out.print(mb.getEmail());
		// System.out.println("\n----------------");
		// Set<RecipientBean> set = mb.getRbs();
		// for(RecipientBean x : set){
		// System.out.print(x.getId()+",");
		// System.out.print(x.getMemberbean().getId()+",");
		// System.out.print(x.getName()+",");
		// System.out.print(x.getPhone()+",");
		// System.out.print(x.getCity()+",");
		// System.out.print(x.getDistrict()+",");
		// System.out.print(x.getAddr());
		// System.out.println();
		// }

		// 查詢全部會員的 全部連絡人
		// List<MemberBean> list2 = dao.getAll();
		// for (MemberBean mb : list2) {
		// System.out.print(mb.getId() + ",");
		// System.out.print(mb.getEmail() + ",");
		// System.out.print(mb.getName());
		// System.out.println("\n-----------------");
		// Set<RecipientBean> set2 = mb.getRbs();
		// for (RecipientBean rb : set2) {
		// System.out.print(rb.getId() + ",");
		// System.out.print(rb.getName() + ",");
		// System.out.print(rb.getCity() + ",");
		// System.out.print(rb.getDistrict() + ",");
		// System.out.print(rb.getAddr() + ",");
		// System.out.print(rb.getPhone());
		// System.out.println();
		// }
		// System.out.println();
		// }

		// ----------------------------------------

		// 找單筆會員的留言
		// MemberBean mb = dao.findByPrimaryKey("m01704150001");
		// System.out.print(mb.getId()+ ",");
		// System.out.print(mb.getName()+",");
		// System.out.print(mb.getEmail());
		// System.out.println("\n----------------");
		// Set<MessageBean> set = mb.getMbs();
		// for(MessageBean x : set){
		// System.out.print(x.getId() + ",");
		// System.out.print(x.getMemberbean().getId() + ",");
		// System.out.print(x.getName() + ",");
		// System.out.print(x.getEmail() + ",");
		// System.out.print(x.getTime() + ",");
		// System.out.print(x.getContent() );
		// System.out.println();
		// }

		// 查詢全部會員的 留言
		// List<MemberBean> list2 = dao.getAll();
		// for (MemberBean mb : list2) {
		// System.out.print(mb.getId() + ",");
		// System.out.print(mb.getEmail() + ",");
		// System.out.print(mb.getName());
		// System.out.println("\n-----------------");
		// Set<MessageBean> set = mb.getMbs();
		// for(MessageBean x : set){
		// System.out.print(x.getId() + ",");
		// System.out.print(x.getMemberbean().getId() + ",");
		// System.out.print(x.getName() + ",");
		// System.out.print(x.getEmail() + ",");
		// System.out.print(x.getTime() + ",");
		// System.out.print(x.getContent() );
		// System.out.println();
		// }
		// System.out.println();
		// }

	}

}
