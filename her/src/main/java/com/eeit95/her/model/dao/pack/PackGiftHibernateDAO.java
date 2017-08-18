package com.eeit95.her.model.dao.pack;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import com.eeit95.her.model.misc.SpringJavaConfiguration;
import com.eeit95.her.model.pack.PackGiftBean;
import com.eeit95.her.model.pack.PackGiftDAOInterface;


@Repository
public class PackGiftHibernateDAO implements PackGiftDAOInterface{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	private static final String delete = 
			"delete from PackGiftBean where packId=? and giftId=?";
	
	private static final String selectByPackId = 
			"from PackGiftBean where packId = ?";
	
	private static final String selectAll = 
			"from PackGiftBean order by packId";

	
	@Override
	public PackGiftBean insert(PackGiftBean bean) {
		Session session = this.getSession();
		if(bean != null){
			session.save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public PackGiftBean update(PackGiftBean bean) {
		Session session = this.getSession();
		PackGiftBean result = new PackGiftBean();
		if(result != null) {
			result.setPackId(bean.getPackId());
			result.setGiftId(bean.getGiftId());
			result.setGiftQuantity(bean.getGiftQuantity());
			session.update(result);
			return result;
		}
		return result;
	}

	@Override
	public boolean delete(String packId, String giftId) {
		Session session = this.getSession();
		Query result = null;
		result = session.createQuery("from PackGiftBean where packId = ?");
		result.setParameter(0, packId);
		if(result != null) {
			Query query = session.createQuery(delete);
			query.setParameter(0, packId);
			query.setParameter(1, giftId);
			System.out.println("刪除筆數:" + query.executeUpdate());
			return true;
		}
		return false;
	}

	@Override
	public List<PackGiftBean> selectByPackId(String packId) {
		List<PackGiftBean> result = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectByPackId);
		query.setParameter(0, packId);
		result = query.list();
		return result;
	}

	@Override
	public List<PackGiftBean> selectAll() {
		List<PackGiftBean> result = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectAll);
		result = query.list();
		return result;
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		PackGiftHibernateDAO dao = (PackGiftHibernateDAO) context.getBean("packGiftHibernateDAO");
		
		try {
			sessionFactory.getCurrentSession().beginTransaction();

		//● 新增-1 insert(0810測試成功)
//		PackGiftBean bean = new PackGiftBean();
//		bean.setPackId("p01703150001"); //必須填入[pack]已有的id，否則會新增失敗。
//		bean.setGiftId("g01704210002"); //必須填入[gift]已有的id，否則會新增失敗。
//		bean.setGiftQuantity(4);
//		dao.insert(bean);
		
		//● 修改-2 update(0810測試成功)
//		PackGiftBean bean = new PackGiftBean();	
//		bean.setPackId("p01703150001"); //必須填入[pack_gift]已有的packId，否則會變成新增。
//		bean.setGiftId("g01704210002"); //必須填入[pack_gift]已有的giftId，否則會變成新增。
//		bean.setGiftQuantity(811);
//		dao.update(bean);
			
		//●刪除-3 delete(0810測試成功)
//		dao.delete("p01703150001", "g01704210002");	
			
		//●查詢-4 selectByPackId(0810測試成功)
//		List<PackGiftBean> list = dao.selectByPackId("p01707200001");
//		for(PackGiftBean bean : list) {
//			System.out.print(bean.getPackId()+ ",");
//			System.out.print(bean.getGiftId()+ ",");
//			System.out.println(bean.getGiftQuantity());
//			System.out.println();
//		}
			
		//●查詢-6 selectAll(0810測試成功)			
		List<PackGiftBean>	list = dao.selectAll();
		for(PackGiftBean bean : list) {
		System.out.print(bean.getPackId()+ ",");
		System.out.print(bean.getGiftId()+ ",");
		System.out.println(bean.getGiftQuantity());
		System.out.println();
	}
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException ex) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw ex;
		} finally {
			((ConfigurableApplicationContext) context).close();
		}

	}

	}