package com.eeit95.her.model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.dao.gift.GiftTaghibernateDAO;
import com.eeit95.her.model.gift.GiftBean;
import com.eeit95.her.model.gift.GiftTagBean;
import com.eeit95.her.model.gift.GiftTagDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;
import com.eeit95.her.model.tag.TagBean;

@Service
public class GiftTagService {

	@Autowired
	private GiftTagDAOInterface giftTagDAOInterface;
	
	
	public List<GiftTagBean> insert(List<GiftTagBean> beans){
		return giftTagDAOInterface.insert(beans);
	}
	
	public boolean delete(GiftBean giftId, TagBean tagId) {
		return giftTagDAOInterface.delete(giftId, tagId);
	}
	
	public boolean deleteById(GiftBean giftId) {
		return giftTagDAOInterface.deleteById(giftId);
	}
	
	public boolean deleteByTagId(TagBean tagId) {
		return giftTagDAOInterface.deleteByTagId(tagId);
	}
	
	public List<GiftTagBean> selectById(GiftBean giftId){
		return giftTagDAOInterface.selectById(giftId);
	}
	
	public List<GiftTagBean> selectByTagId(TagBean tagId){
		return giftTagDAOInterface.selectByTagId(tagId);
	}
	
	public List<GiftTagBean> selectAll(){
		return giftTagDAOInterface.selectAll();
	}
	
	
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		GiftTaghibernateDAO dao = (GiftTaghibernateDAO) context.getBean("giftTaghibernateDAO");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			
		
		//● 新增單/多筆-1 insertMany(0808-SpringService測試OK)(利用SavaOrUpdate特性，取得Id再新增新的Id)
//		List<GiftTagBean> beans1 = new ArrayList<GiftTagBean>();
//		GiftBean gBean1 = new GiftBean();
//		gBean1.setId("g01701210001"); //必須填入Gift已有的Id，否則會新增失敗。
//		TagBean tBean1 = new TagBean();
//		tBean1.setId(1); //必須填入Tag已有的Id，否則會新增失敗。
//		GiftTagBean bean1 = new GiftTagBean();
//		bean1.setGiftId(gBean1);
//		bean1.setTagId(tBean1);
//		beans1.add(bean1);
//		
//		GiftBean gBean2 = new GiftBean();
//		gBean2.setId("g01701210001"); //必須填入Gift已有的Id，否則會新增失敗。
//		TagBean tBean2 = new TagBean();
//		tBean2.setId(2); //必須填入Tag已有的Id，否則會新增失敗。
//		GiftTagBean bean2 = new GiftTagBean();
//		bean2.setGiftId(gBean2);
//		bean2.setTagId(tBean2);
//		beans1.add(bean2);
//
//		dao.insert(beans1);

		//●刪除-2 delete(0808-SpringService測試OK)(必須同時符合giftId和tagId才能刪除)
//		GiftBean gBean = new GiftBean();
//		gBean.setId("g01701210001"); //【如果id不存在，刪除不會有影響】
//		TagBean tBean = new TagBean();
//		tBean.setId(5);
//		GiftTagBean bean = new GiftTagBean();
//		dao.delete(gBean,tBean);

		//●刪除-3 deleteById(0808-SpringService測試OK)
//		GiftBean gBean = new GiftBean();
//		gBean.setId("g01701210001"); //【如果id不存在，刪除不會有影響】
//		dao.deleteById(gBean);

		
		//●刪除-4 deleteByTagId(0808-SpringService測試OK)
//		TagBean tBean = new TagBean();//必須填入Gift已有的Id，否則會新增失敗。
//		tBean.setId(1);
//		dao.deleteByTagId(tBean);

		//● 查詢-5 selectById(0808-SpringService測試OK)
//		GiftBean gBean = new GiftBean();
//		gBean.setId("g01702210001");//輸入id(String型別)
//		List<GiftTagBean> beans = dao.selectById(gBean); 
//		for (GiftTagBean bean : beans) {
//		System.out.print(bean.getGiftId().getId()+ ",");
//		System.out.print(bean.getTagId().getId()+ ",");
//		System.out.println();
//		}
		
		//● 查詢-6 selectByTagId(0808-SpringService測試OK)
//		TagBean tBean = new TagBean();
//		tBean.setId(2);
//		List<GiftTagBean> beans = dao.selectByTagId(tBean); 
//		for (GiftTagBean bean : beans) {
//		System.out.print(bean.getGiftId().getId()+ ",");
//		System.out.print(bean.getTagId().getId() + ",");
//		System.out.print(bean.getTagId().getId() + ",");
//		System.out.println();
//		}		

		//● 查詢-7 selectAll(00808-SpringService測試OK)
//		List<GiftTagBean> Beans = dao.selectAll();
//		for (GiftTagBean bean : Beans) {
//		System.out.print(bean.getGiftId().getId() + ",");
//		System.out.print(bean.getTagId().getId() + ",");
//		System.out.println();
//		}
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException ex) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw ex;
		} finally {
			((ConfigurableApplicationContext) context).close();
		}

	}
}