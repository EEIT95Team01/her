package com.eeit95.her.model.dao.gift;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import com.eeit95.her.model.gift.GiftDescriptionDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;
import com.eeit95.her.model.gift.GiftDescriptionBean;
import com.eeit95.her.model.gift.GiftBean;
import java.util.*;


@Repository
public class GiftDescriptionHibernateDAO  implements GiftDescriptionDAOInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();

	}
	
	
	private static final String delete = 
			"delete from GiftDescriptionBean where giftId=?";
	private static final String selectById = "from GiftDescriptionBean where giftId = ?";
	private static final String selectByNo = "from GiftDescriptionBean where orderNo = ?";
//	private static final String selectAll = "from GiftDescriptionBean order by orderNo";
	
	@Override
	public List<GiftDescriptionBean> insert(List<GiftDescriptionBean> beans) {
		Session session = this.getSession();
			if(beans != null) {
				for(GiftDescriptionBean bean : beans) {
					session.save(bean);
				}
			}
			return beans;
	}

	@Override
	public boolean delete(String giftId) {
		Session session = this.getSession();
		if(giftId != null){
			Query query =session.createQuery(delete);
			query.setParameter(0,giftId);
			int i = query.executeUpdate();
			if(i > 0) {
				System.out.println("刪除筆數:" + i);
				return true;
			}
		}				
			return false;
	}

	@Override
	public List<GiftDescriptionBean> selectById(String giftId) {
		List<GiftDescriptionBean> result = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectById);
		query.setParameter(0, giftId);
		result = query.list();
		return  result;
	}
	
	@Override
	public List<GiftDescriptionBean> selectByNo(int orderNo) {
		List<GiftDescriptionBean> list = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectByNo);
		query.setParameter(0, orderNo);
		list = query.list();
		return  list;
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		GiftDescriptionHibernateDAO dao = 
				(GiftDescriptionHibernateDAO) context.getBean("giftDescriptionHibernateDAO");

		try {
			sessionFactory.getCurrentSession().beginTransaction();

			//● 新增多筆-1 insertMany(0807-Spring測試OK)
//			GiftBean gBean1 = new GiftBean();
//			gBean1.setId("g01702210001");//輸入id(String型別)
//			List<GiftDescriptionBean> gdBeans = dao.selectById(gBean1); 
//			for (GiftDescriptionBean gdBean : gdBeans) {
//			System.out.print(gdBean.getGiftId().getId()+ ",");
//			System.out.print(gdBean.getOrderNo() + ",");
//			System.out.print(gdBean.getText() + ",");
//			System.out.print(gdBean.getImage() + ",");
//			System.out.println();
//			}
//			List<GiftDescriptionBean> gdBeans1 = new ArrayList<GiftDescriptionBean>();
//			GiftBean gBean2 = new GiftBean();//利用select取得多筆資料再重新insert進去。(測試用)
//			gBean2.setId("g01702210001");	 //必須填入Gift已有的Id，否則會新增失敗。
//			GiftDescriptionBean gdBean1 = new GiftDescriptionBean();
//			gdBean1.setGiftId(gBean2);
//			gdBean1.setOrderNo(3);
//			gdBeans1.add(gdBean1);
//			GiftDescriptionBean gdBean2 = new GiftDescriptionBean();
//			gdBean2.setGiftId(gBean2);
//			gdBean2.setOrderNo(4);
//			gdBeans1.add(gdBean2);
//			
//			dao.insert(gdBeans1);	

			//●刪除-2 (0807-Spring測試OK)
//			GiftBean gBean = new GiftBean();
//			gBean.setId("g01701210002");//【如果id不存在，刪除不會有影響】
//			if(dao.delete(gBean,1) == true) {
//				System.out.println("刪除成功");
//			}else {
//				System.out.println("刪除失敗，請檢查資料庫有無此筆資料");
//			}
			
			//● 查詢-3 selectById(0807-Spring測試OK)
//			GiftBean gBean = new GiftBean();
//			gBean.setId("g01701210001");//輸入id(String型別)
//			List<GiftDescriptionBean> gdBeans = dao.selectById(gBean); 
//			for (GiftDescriptionBean gdBean : gdBeans) {
//			System.out.print(gdBean.getGiftId().getId()+ ",");
//			System.out.print(gdBean.getOrderNo() + ",");
//			System.out.print(gdBean.getText() + ",");
//			System.out.print(gdBean.getImage() + ",");
//			System.out.println();
//			}
		
			//● 查詢-4 selectByNo(0807-Spring測試OK)
//			List<GiftDescriptionBean> gdBeans = dao.selectByNo(1);  //輸入orderNo的值，如果輸入的值尚未存在，則會搜尋不到。
//			for (GiftDescriptionBean gdBean : gdBeans) {
//			System.out.print(gdBean.getOrderNo() + ",");
//			System.out.print(gdBean.getGiftId().getId()+ ",");
//			System.out.print(gdBean.getText() + ",");
//			System.out.print(gdBean.getImage() + ",");
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