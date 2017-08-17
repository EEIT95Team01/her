package com.eeit95.her.model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.dao.gift.GiftDescriptionHibernateDAO;
import com.eeit95.her.model.gift.GiftBean;
import com.eeit95.her.model.gift.GiftDescriptionBean;
import com.eeit95.her.model.gift.GiftDescriptionDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Service
public class GiftDescriptionService {

	@Autowired
	private GiftDescriptionDAOInterface giftDescriptionDAOInterface;
	
	public List<GiftDescriptionBean> insert(List<GiftDescriptionBean> beans){
		return giftDescriptionDAOInterface.insert(beans);
	}
	
	public boolean delete(GiftBean giftId, int orderNo) {
		return giftDescriptionDAOInterface.delete(giftId, orderNo);
	}
	
	public List<GiftDescriptionBean> selectById(GiftBean giftId){
		return giftDescriptionDAOInterface.selectById(giftId);
	}
	
	public List<GiftDescriptionBean> selectByNo(int orderNo){
		return giftDescriptionDAOInterface.selectByNo(orderNo);
	}
	
	
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		GiftDescriptionHibernateDAO dao = 
				(GiftDescriptionHibernateDAO) context.getBean("giftDescriptionHibernateDAO");

		try {
			sessionFactory.getCurrentSession().beginTransaction();

		//● 新增多筆-1 insertMany(0808-SpringService測試OK)
//		List<GiftDescriptionBean> gdBeans1 = new ArrayList<GiftDescriptionBean>();
//		GiftBean gBean2 = new GiftBean();//利用select取得多筆資料再重新insert進去。(測試用)
//		gBean2.setId("g01702210001");	 //必須填入Gift已有的Id，否則會新增失敗。
//		GiftDescriptionBean gdBean1 = new GiftDescriptionBean();
//		gdBean1.setGiftId(gBean2);
//		gdBean1.setOrderNo(5);
//		gdBeans1.add(gdBean1);
//		GiftDescriptionBean gdBean2 = new GiftDescriptionBean();
//		gdBean2.setGiftId(gBean2);
//		gdBean2.setOrderNo(6);
//		gdBeans1.add(gdBean2);
//		dao.insert(gdBeans1);	

		//●刪除-2 (0808-SpringService測試OK)
//		GiftBean gBean = new GiftBean();
//		gBean.setId("g01702210001");//【如果id不存在，刪除不會有影響】
//		if(dao.delete(gBean,5) == true) {
//			System.out.println("刪除成功");
//		}else {
//			System.out.println("刪除失敗，請檢查資料庫有無此筆資料");
//		}
			
		//● 查詢-3 selectById(0808-SpringService測試OK)
//		GiftBean gBean = new GiftBean();
//		gBean.setId("g01704210002");//輸入id(String型別)
//		List<GiftDescriptionBean> gdBeans = dao.selectById(gBean); 
//		for (GiftDescriptionBean gdBean : gdBeans) {
//		System.out.print(gdBean.getGiftId().getId()+ ",");
//		System.out.print(gdBean.getOrderNo() + ",");
//		System.out.print(gdBean.getText() + ",");
//		System.out.print(gdBean.getImage() + ",");
//		System.out.println();
//		}
		
		//● 查詢-4 selectByNo(0808-SpringService測試OK)
//		List<GiftDescriptionBean> gdBeans = dao.selectByNo(1);  //輸入orderNo的值，如果輸入的值尚未存在，則會搜尋不到。
//		for (GiftDescriptionBean gdBean : gdBeans) {
//		System.out.print(gdBean.getOrderNo() + ",");
//		System.out.print(gdBean.getGiftId().getId()+ ",");
//		System.out.print(gdBean.getText() + ",");
//		System.out.print(gdBean.getImage() + ",");
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