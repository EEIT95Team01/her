package com.eeit95.her.model.dao.member;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.eeit95.her.model.member.MemberBean;
import com.eeit95.her.model.member.MemberDAO_interface;
import com.eeit95.her.model.member.RecipientBean;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Repository
public class MemberHibernateDAO implements MemberDAO_interface {
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private static final String GET_ALL_STMT = "from MemberBean";
	private static final String GET_ID_FROM_EMAIL = "from MemberBean where email = ?";

	
	@Override
	public MemberBean insert(MemberBean memberBean) {
		List<MemberBean> AllList;
		AllList = this.getAll();
		for (MemberBean x : AllList) {
			// 確認email有沒有重複
			if (x.getEmail().trim().equals(memberBean.getEmail().trim())) {
				System.out.println("email重複");
				return null;
			}
		}
		
		this.getSession().save(memberBean);
		
		return memberBean;
		
	}

	// 測試用(未來正式版會把ID拿掉(因為ID自動生成))
	@Override
	public MemberBean insert(String id, String email, String password) {
		List<MemberBean> AllList;
		MemberBean mb = new MemberBean();
		AllList = this.getAll();
		for (MemberBean x : AllList) {
			// 確認email有沒有重複
			if (x.getEmail().trim().equals(email.trim())) {
				System.out.println("email重複");
				return null;
			}
		}
		mb.setId(id);
		mb.setEmail(email);
		mb.setPassword(password);
		this.getSession().save(mb);
		
		return mb;
	}
	// 正式用
//	@Override
//	public MemberBean insert(String email, String password) {
//		List<MemberBean> AllList, list;
//		MemberBean mb = new MemberBean();
//		AllList = this.getAll();
//		for (MemberBean x : AllList) {
//			// 確認email有沒有重複
//			if (x.getEmail().trim().equals(email.trim())) {
//				return null;
//			}
//		}
//		mb.setEmail(email);
//		mb.setPassword(password);
//		this.getSession().save(mb);
//		
//		return mb;
//	}

	@Override
	public MemberBean update(MemberBean memberBean) {
		if (memberBean != null) {
			MemberBean mb = (MemberBean) this.getSession().get(MemberBean.class, memberBean.getId());
			if (mb != null) {
				mb.setEmail(memberBean.getEmail());
				mb.setPassword(memberBean.getPassword());
				mb.setName(memberBean.getName());
				mb.setPhone(memberBean.getPhone());
				mb.setCity(memberBean.getCity());
				mb.setDistrict(memberBean.getDistrict());
				mb.setAddr(memberBean.getAddr());
				mb.setBirthday(memberBean.getBirthday());			
				this.getSession().save(mb);
				return mb;
			}
		}
		return null;
	}

	@Override
	public boolean delete(String id) {
		MemberBean mb = this.getSession().get(MemberBean.class, id);
		if (mb != null) {
			sessionFactory.getCurrentSession().delete(mb);
			return true;
		}
		return false;
	}

	@Override
	public MemberBean findByPrimaryKey(String id) {
		MemberBean mb = this.getSession().get(MemberBean.class, id);
		if (mb != null) {
			return mb;
		}
		return null;
	}

	@Override
	public String findIdFromEmail(String email) {
		MemberBean mb;
		String id;
		Query query = this.getSession().createQuery(GET_ID_FROM_EMAIL);
		query = query.setParameter(0, email.trim());

		List<MemberBean> list = query.list();

		if (list != null) {
			try {
				mb = list.get(0);
				if (mb != null) {
					id = mb.getId();
					return id;
				}
			} catch (IndexOutOfBoundsException e) {
				return "Not Our Member";
			}
		}
		return "Not Our Member";

	}

	@Override
	public List<MemberBean> getAll() {
		List<MemberBean> list = null;
		list = this.getSession().createQuery(GET_ALL_STMT).list();

		return list;
	}


	
	@Override
	public String getNewId() {
		Session session = this.getSession();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
		String newsNo = "m" + df.format(new Date()).substring(1, 8);
		System.out.println("newsNo = " + newsNo);
		String temp2 = null;
		String temp3 = null;
		Query query = session.createSQLQuery("SELECT top 1 m.id from member as m order by id desc");
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

	// 以下為測試程式
//	public static void main(String[] args) {
//
//		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		
//		MemberHibernateDAO dao = (MemberHibernateDAO)context.getBean("memberHibernateDAO");
//
//		MemberBean xbean = new MemberBean();
//		xbean.setId("M0806");
//		xbean.setEmail("testABC@iii.org");
//		xbean.setPassword("helloworld");
//		xbean.setName("Jack測試用");
//		xbean.setPhone("09123");
//		xbean.setCity("ox市");
//		xbean.setDistrict("xy區");
//		xbean.setAddr("你心裡");
//		xbean.setBirthday(java.sql.Date.valueOf("2012-12-31"));
//
//		// //用email找ID
//		 try {
//		 sessionFactory.getCurrentSession().beginTransaction();
//		
//		 String id = dao.findIdFromEmail("   xxx@abc.com");
//		 sessionFactory.getCurrentSession().getTransaction().commit();
//		
//		 System.out.println(id);
//		 } catch (HibernateException e) {
//		 sessionFactory.getCurrentSession().getTransaction().rollback();
//		 e.printStackTrace();
//		 }
//
//		// GetAll (取全部會員)
//		// try {
//		// sessionFactory.getCurrentSession().beginTransaction();
//		//
//		// List<MemberBean> list= dao.getAll();
//		//
//		// sessionFactory.getCurrentSession().getTransaction().commit();
//		// for(MemberBean x:list){
//		// System.out.println(x);
//		// }
//		// } catch (HibernateException e) {
//		// sessionFactory.getCurrentSession().getTransaction().rollback();
//		// e.printStackTrace();
//		// }
//
//		// 查詢單筆會員資料
//		// try{
//		// sessionFactory.getCurrentSession().beginTransaction();
//		//
//		// MemberBean mb= dao.findByPrimaryKey("M123");
//		//
//		// sessionFactory.getCurrentSession().getTransaction().commit();
//		//
//		// System.out.println(mb);
//		//
//		// }catch(HibernateException e){
//		// sessionFactory.getCurrentSession().getTransaction().rollback();
//		// e.printStackTrace();
//		// }
//
//		// 新增會員
////		try {
////			sessionFactory.getCurrentSession().beginTransaction();
////			dao.insert("M0807", "xxx@abc.com", "abc");
////			sessionFactory.getCurrentSession().getTransaction().commit();
////		} catch (HibernateException e) {
////			sessionFactory.getCurrentSession().getTransaction().rollback();
////			e.printStackTrace();
////		}
//
//		// 修改會員資料
//		// try {
//		// sessionFactory.getCurrentSession().beginTransaction();
//		// MemberHibernateDAO dao = new MemberHibernateDAO(sessionFactory);
//		// dao.update(xbean);
//		// sessionFactory.getCurrentSession().getTransaction().commit();
//		// } catch (HibernateException e) {
//		// sessionFactory.getCurrentSession().getTransaction().rollback();
//		// e.printStackTrace();
//		// }
//
//		// 刪除會員資料
//		// try {
//		// sessionFactory.getCurrentSession().beginTransaction();
//		// MemberHibernateDAO dao = new MemberHibernateDAO(sessionFactory);
//		// boolean x = dao.delete("M0806");
//		// System.out.println(x);
//		// sessionFactory.getCurrentSession().getTransaction().commit();
//		// } catch (HibernateException e) {
//		// sessionFactory.getCurrentSession().getTransaction().rollback();
//		// e.printStackTrace();
//		// }
//
//		((ConfigurableApplicationContext) context).close();
//
//	}

}
