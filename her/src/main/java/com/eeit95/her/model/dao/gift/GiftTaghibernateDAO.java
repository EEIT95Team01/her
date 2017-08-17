package com.eeit95.her.model.dao.gift;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.eeit95.her.model.gift.GiftTagDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;
import com.eeit95.her.model.tag.TagBean;
import com.eeit95.her.model.gift.GiftTagBean;
import com.eeit95.her.model.gift.GiftBean;

@Repository
public class GiftTaghibernateDAO implements GiftTagDAOInterface{
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	private static final String selectAll = "from GiftTagBean order by giftId";
	private static final String delete = "delete from GiftTagBean where giftId=? and tagId=?";
	private static final String deleteById = "delete from GiftTagBean where giftId=?";
	private static final String deleteByTagId = "delete from GiftTagBean where tagId=?";
	private static final String selectById = "from GiftTagBean where giftId = ?";
	private static final String selectByTagId = "from GiftTagBean where tagId = ?";
	
	
	@Override
	public List<GiftTagBean> insert(List<GiftTagBean> beans) {
		Session session = this.getSession();
		if(!beans.isEmpty()) {
			
			for(GiftTagBean bean : beans) {
				session.saveOrUpdate(bean);
			}
		}
		return beans;
	}

	@Override
	public boolean delete(String giftId, int tagId) {
		Session session = this.getSession();
		Query result = null;
		result = session.createQuery("from GiftTagBean where giftId=?");
		result.setParameter(0,giftId);
		if(result != null){
			Query query = session.createQuery(delete);
			query.setParameter(0,giftId);
			query.setParameter(1, tagId);
			System.out.println("刪除筆數:" + query.executeUpdate());
			return true;
		}			
			return false;
	}
	
	@Override
	public boolean deleteById(String giftId) {
		Session session = this.getSession();
		Query result = null;
		result = session.createQuery("from GiftTagBean where giftId= ? ");
		result.setParameter(0,giftId);
		if(result != null){
			Query query = session.createQuery(deleteById);
			query.setParameter(0,giftId);
			//query.executeUpdate();
			System.out.println("刪除筆數:" + query.executeUpdate());
			return true;
		}			
			return false;
	}
	
	@Override
	public boolean deleteByTagId(int tagId) {
		Session session = this.getSession();
		Query result = null;
		result = session.createQuery("from GiftTagBean where tagId=?");
		result.setParameter(0,tagId);
		if(result != null){
			Query query = session.createQuery(deleteByTagId);
			query.setParameter(0,tagId);
			System.out.println("刪除筆數:" + query.executeUpdate());
			return true;
		}			
			return false;
	}

	@Override
	public List<GiftTagBean> selectById(String giftId) {
		List<GiftTagBean> result = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectById);
		query.setParameter(0, giftId);
		result = query.list();
		return  result;
	}
	
	@Override
	public List<GiftTagBean> selectByTagId(int tagId) {
		List<GiftTagBean> result = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectByTagId);
		query.setParameter(0, tagId);
		result = query.list();
		return  result;
	}

	@Override
	public List<GiftTagBean> selectAll() {
		List<GiftTagBean> result = null;
		//session.beginTransaction();
		Session session = this.getSession();
		Query query = session.createQuery(selectAll);
		result = query.list();
		return result;
	}

	

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		GiftTaghibernateDAO dao = (GiftTaghibernateDAO) context.getBean("giftTaghibernateDAO");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			
		
			//● 新增單/多筆-1 insertMany(0808-SpringService測試OK)(利用SavaOrUpdate特性，取得Id再新增新的Id)
//			List<GiftTagBean> beans1 = new ArrayList<GiftTagBean>();
//			GiftBean gBean1 = new GiftBean();
//			gBean1.setId("g01701210001"); //必須填入Gift已有的Id，否則會新增失敗。
//			TagBean tBean1 = new TagBean();
//			tBean1.setId(1); //必須填入Tag已有的Id，否則會新增失敗。
//			GiftTagBean bean1 = new GiftTagBean();
//			bean1.setGiftId(gBean1);
//			bean1.setTagId(tBean1);
//			beans1.add(bean1);
//			
//			GiftBean gBean2 = new GiftBean();
//			gBean2.setId("g01701210001"); //必須填入Gift已有的Id，否則會新增失敗。
//			TagBean tBean2 = new TagBean();
//			tBean2.setId(2); //必須填入Tag已有的Id，否則會新增失敗。
//			GiftTagBean bean2 = new GiftTagBean();
//			bean2.setGiftId(gBean2);
//			bean2.setTagId(tBean2);
//			beans1.add(bean2);
//
//			dao.insert(beans1);

			//●刪除-2 delete(0808-SpringService測試OK)(必須同時符合giftId和tagId才能刪除)
//			GiftBean gBean = new GiftBean();
//			gBean.setId("g01701210001"); //【如果id不存在，刪除不會有影響】
//			TagBean tBean = new TagBean();
//			tBean.setId(5);
//			GiftTagBean bean = new GiftTagBean();
//			dao.delete(gBean,tBean);

			//●刪除-3 deleteById(0808-SpringService測試OK)
//			GiftBean gBean = new GiftBean();
//			gBean.setId("g01701210001"); //【如果id不存在，刪除不會有影響】
//			dao.deleteById(gBean);

			
			//●刪除-4 deleteByTagId(0808-SpringService測試OK)
//			TagBean tBean = new TagBean();//必須填入Gift已有的Id，否則會新增失敗。
//			tBean.setId(1);
//			dao.deleteByTagId(tBean);

			//● 查詢-5 selectById(0808-SpringService測試OK)
//			GiftBean gBean = new GiftBean();
//			gBean.setId("g01702210001");//輸入id(String型別)
//			List<GiftTagBean> beans = dao.selectById(gBean); 
//			for (GiftTagBean bean : beans) {
//			System.out.print(bean.getGiftId().getId()+ ",");
//			System.out.print(bean.getTagId().getId()+ ",");
//			System.out.println();
//			}
			
			//● 查詢-6 selectByTagId(0808-SpringService測試OK)
//			TagBean tBean = new TagBean();
//			tBean.setId(2);
//			List<GiftTagBean> beans = dao.selectByTagId(tBean); 
//			for (GiftTagBean bean : beans) {
//			System.out.print(bean.getGiftId().getId()+ ",");
//			System.out.print(bean.getTagId().getId() + ",");
//			System.out.print(bean.getTagId().getId() + ",");
//			System.out.println();
//			}		

			//● 查詢-7 selectAll(00808-SpringService測試OK)
//			List<GiftTagBean> Beans = dao.selectAll();
//			for (GiftTagBean bean : Beans) {
//			System.out.print(bean.getGiftId().getId() + ",");
//			System.out.print(bean.getTagId().getId() + ",");
//			System.out.println();
//			}
				
				sessionFactory.getCurrentSession().getTransaction().commit();
			} catch (RuntimeException ex) {
				sessionFactory.getCurrentSession().getTransaction().rollback();
				throw ex;
			} finally {
				((ConfigurableApplicationContext) context).close();
			}

		}
	}