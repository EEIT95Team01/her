package com.eeit95.her.model.dao.member;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.eeit95.her.model.member.AdminUserBean;
import com.eeit95.her.model.member.AdminUserDAO_interface;
import com.eeit95.her.model.member.MemberBean;
import com.eeit95.her.model.member.MemberDAO_interface;
import com.eeit95.her.model.member.RecipientBean;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Repository
public class AdminUserHibernateDAO implements AdminUserDAO_interface {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private static final String GET_ALL_ADMIN = "from AdminUserBean";
	private static final String GET_ADMIN_FROM_AUTHORITY = "from AdminUserBean where authorityId = ?";
	private static final String GET_ADMIN_FROM_USERNAME = "from AdminUserBean where username = ?";

	@Override
	public AdminUserBean insert(AdminUserBean adminBean) {

		List<AdminUserBean> list = this.getAll();
		for (AdminUserBean ab : list) {
			if (ab.getUsername().trim().equals(adminBean.getUsername().trim())) {
				System.out.println("有重複username！");
				return null;
			}
		}
		System.out.println("adminBean = "+adminBean);
		AdminUserBean ad = (AdminUserBean) this.getSession().save(adminBean);
		return ad;
	}

	@Override
	public AdminUserBean update(AdminUserBean adminBean) {
		// List<AdminBean> list = this.getAll();
		// for (AdminBean ab : list) {
		// if (ab.getUsername().trim().equals(adminBean.getUsername().trim())) {
		// ab.setPassword(adminBean.getPassword());
		// ab.setAuthorityId(adminBean.getAuthorityId());
		//
		// return ab;
		// }
		// }

		AdminUserBean ab = this.findByUsername(adminBean.getUsername());
		if (ab != null) {
			ab.setUsername(adminBean.getUsername());
			ab.setPassword(adminBean.getPassword());
			ab.setAuthorityId(adminBean.getAuthorityId());

			return ab;
		}
		return null;
	}

	@Override
	public List<AdminUserBean> getAll() {
		List<AdminUserBean> list = null;
		list = this.getSession().createQuery(GET_ALL_ADMIN).list();

		return list;
	}

	@Override
	public AdminUserBean findByUsername(String username) {
		Query query = this.getSession().createQuery(GET_ADMIN_FROM_USERNAME);
		query= query.setParameter(0, username.trim());
		
		List<AdminUserBean> list = query.list();
		if (list != null) {
			AdminUserBean ab = list.get(0);
			if(ab!=null){
				return ab;
			}				
		}

		return null;
		// if return null代表沒有這個username
	}

	@Override
	public List<AdminUserBean> findByAuthority(int authorityId) {
		List<AdminUserBean> list = null;
		Query query = this.getSession().createQuery(GET_ADMIN_FROM_AUTHORITY);
		list = query.setParameter(0, authorityId).list();

		return list;
		// if return null代表沒有這個權職代號
	}

	// 以下為測試程式
	public static void main(String[] args) {

		// ApplicationContext context = new
		// AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		// SessionFactory sessionFactory = (SessionFactory)
		// context.getBean("sessionFactory");
		//
		// AdminHibernateDAO dao =
		// (AdminHibernateDAO)context.getBean("memberHibernateDAO");
		//
		// MemberBean xbean = new MemberBean();
		// xbean.setId("M0806");
		// xbean.setEmail("testABC@iii.org");
		// xbean.setPassword("helloworld");
		// xbean.setName("Jack測試用");
		// xbean.setPhone("09123");
		// xbean.setCity("ox市");
		// xbean.setDistrict("xy區");
		// xbean.setAddr("你心裡");
		// xbean.setBirthday(java.sql.Date.valueOf("2012-12-31"));

		// //用email找ID
		// try {
		// sessionFactory.getCurrentSession().beginTransaction();
		//
		// String id = dao.findIdFromEmail(" xxx@abc.com");
		// sessionFactory.getCurrentSession().getTransaction().commit();
		//
		// System.out.println(id);
		// } catch (HibernateException e) {
		// sessionFactory.getCurrentSession().getTransaction().rollback();
		// e.printStackTrace();
		// }

		// GetAll (取全部會員)
		// try {
		// sessionFactory.getCurrentSession().beginTransaction();
		//
		// List<MemberBean> list= dao.getAll();
		//
		// sessionFactory.getCurrentSession().getTransaction().commit();
		// for(MemberBean x:list){
		// System.out.println(x);
		// }
		// } catch (HibernateException e) {
		// sessionFactory.getCurrentSession().getTransaction().rollback();
		// e.printStackTrace();
		// }

		// 查詢單筆會員資料
		// try{
		// sessionFactory.getCurrentSession().beginTransaction();
		//
		// MemberBean mb= dao.findByPrimaryKey("M123");
		//
		// sessionFactory.getCurrentSession().getTransaction().commit();
		//
		// System.out.println(mb);
		//
		// }catch(HibernateException e){
		// sessionFactory.getCurrentSession().getTransaction().rollback();
		// e.printStackTrace();
		// }

		// 新增會員
		// try {
		// sessionFactory.getCurrentSession().beginTransaction();
		// dao.insert("M0807", "xxx@abc.com", "abc");
		// sessionFactory.getCurrentSession().getTransaction().commit();
		// } catch (HibernateException e) {
		// sessionFactory.getCurrentSession().getTransaction().rollback();
		// e.printStackTrace();
		// }

		// 修改會員資料
		// try {
		// sessionFactory.getCurrentSession().beginTransaction();
		// MemberHibernateDAO dao = new MemberHibernateDAO(sessionFactory);
		// dao.update(xbean);
		// sessionFactory.getCurrentSession().getTransaction().commit();
		// } catch (HibernateException e) {
		// sessionFactory.getCurrentSession().getTransaction().rollback();
		// e.printStackTrace();
		// }

		// 刪除會員資料
		// try {
		// sessionFactory.getCurrentSession().beginTransaction();
		// MemberHibernateDAO dao = new MemberHibernateDAO(sessionFactory);
		// boolean x = dao.delete("M0806");
		// System.out.println(x);
		// sessionFactory.getCurrentSession().getTransaction().commit();
		// } catch (HibernateException e) {
		// sessionFactory.getCurrentSession().getTransaction().rollback();
		// e.printStackTrace();
		// }

		// ((ConfigurableApplicationContext) context).close();

	}

}
