package com.eeit95.her.model.dao.pack;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jpa.criteria.expression.function.AggregationFunction.SUM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import com.eeit95.her.model.misc.SpringJavaConfiguration;
import com.eeit95.her.model.pack.PackBean;
import com.eeit95.her.model.pack.PackDAOInterface;
import com.eeit95.her.model.pack.PackSelectBean;

@Repository
public class PackHibernateDAO implements PackDAOInterface{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	private String selectByMIdAndStatus = "from PackBean where memberId = ? and status = ?";

	
	@Override
	public List<PackBean> selectByMIdAndStatus(String memberId, int status){
		List<PackBean> result = null;
		Session session = this.getSession();
		//from PackBean where id = ? and status = ?	
		Query query = session.createQuery(selectByMIdAndStatus);
		query.setParameter(0, memberId);
		query.setParameter(1, status);
		result = query.list();
		return result;
	}

	@Override
	public PackBean selectById(String id) {
		return this.getSession().get(PackBean.class,id);
	}

	@Override
	public PackBean insert(PackBean bean) {
		Session session = this.getSession();
		if(bean != null){
			PackBean result = session.get(PackBean.class, bean.getId());
			if(result == null) {	
				session.save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public PackBean update(PackBean bean) {
		Session session = this.getSession();
		PackBean result = session.get(PackBean.class, bean.getId());
		if(result != null) {
			result.setId(bean.getId());
			result.setName(bean.getName());
			result.setMemberId(bean.getMemberId());
			result.setCardId(bean.getCardId());
			result.setCardPrice(bean.getCardPrice());
			result.setFontId(bean.getFontId());
			result.setFontPrice(bean.getFontPrice());
			result.setGiftSum(bean.getGiftSum());
			result.setSum(bean.getSum());
			result.setContent(bean.getContent());
			result.setRecipientId(bean.getRecipientId());
			result.setRecipientName(bean.getRecipientName());
			result.setRecipientPhone(bean.getRecipientPhone());
			result.setRecipientCity(bean.getRecipientCity());
			result.setRecipientDistrict(bean.getRecipientDistrict());
			result.setRecipientAddr(bean.getRecipientAddr());
			result.setDateMailed(bean.getDateMailed());
			result.setSenderName(bean.getSenderName());
			result.setSenderPhone(bean.getSenderPhone());
			result.setSenderCity(bean.getSenderCity());
			result.setSenderDistrict(bean.getSenderDistrict());
			result.setSenderAddr(bean.getSenderAddr());
			result.setStatus(bean.getStatus());	
		}
		return result;
	}

	@Override
	public boolean deleteById(String id) {
		Session session = this.getSession();
		PackBean bean = (PackBean) session.get(PackBean.class, id);
		if(bean != null) {
			session.delete(bean);
			return true;
		}
	return false;
}
	@Override
	public List<PackBean> selectAllFM(PackSelectBean packSelectBean){
		List<PackBean> result = null;
		Session session = this.getSession();
		
		Criteria criteria = session.createCriteria(PackBean.class);
		if(packSelectBean.getId() != null && packSelectBean.getId().length() !=0) {
			criteria.add(Restrictions.eq("id", packSelectBean.getId()));
		}
		
		String name = packSelectBean.getName();
		if(name != null) {
			criteria.add(Restrictions.like("name", "%"+ name + "%"));
		}
		
		if(packSelectBean.getMemberId() != null && packSelectBean.getMemberId().length() !=0) {
			criteria.add(Restrictions.eq("memberId", packSelectBean.getMemberId()));
		}
		
		criteria.add(Restrictions.between("sum", packSelectBean.getLowPrice(), packSelectBean.getHighPrice()));
		
		if(packSelectBean.getBeginDate() != null) {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    String s = sdf.format(packSelectBean.getBeginDate());
		    System.out.println(s);
		    java.sql.Date selectBegin = java.sql.Date.valueOf(s);
			
			criteria.add(Restrictions.ge("dateMailed", selectBegin));
		}
		
		if(packSelectBean.getEndDate() != null) {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    String s = sdf.format(packSelectBean.getEndDate());
		    System.out.println(s);
		    java.sql.Date selectEnd = java.sql.Date.valueOf(s);
			
			criteria.add(Restrictions.le("dateMailed", selectEnd));
		}
		
		if(packSelectBean.getStatus() == 1) {
			  criteria.add(Restrictions.eq("status",1));
		 }else if(packSelectBean.getStatus() == 2) {
			  criteria.add(Restrictions.eq("status",2));
		 }else if(packSelectBean.getStatus() == 3) {
			  criteria.add(Restrictions.eq("status",3));
		 }
		
		result = criteria.list();
		return result;
	}
	
	@Override
	 public String getNewId() {
	  Session session = this.getSession();
	  SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
	  String newNo = "p"+df.format(new Date()).substring(1, 8);
	  System.out.println("newNo = "+newNo);
	  String temp2= null;  
	  String temp3= null;
	  Query query = session.createSQLQuery("SELECT top 1 p.id from pack as p order by id desc");
	  String no = (String) query.uniqueResult();
	  String temp =no.substring(1, 8);
	  System.out.println("temp = " +temp);
	  if(temp.equalsIgnoreCase(df.format(new Date()).substring(1, 8))) {
	   temp2=no.substring(no.length()-4);
	   System.out.println("temp2 = " +temp2);
	   int no2=Integer.parseInt(temp2);
	   temp3 = newNo+("000"+(no2+1)).substring(("000"+(no2+1)).length()-4);
	   System.out.println("temp3 = " +temp3);
	  }else {
	   temp3 = newNo+"0001";
	   System.out.println("temp3 = " +temp3);
	  }
	  return temp3;
	 }

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		PackHibernateDAO dao = (PackHibernateDAO) context.getBean("packHibernateDAO");
		
		try {
			sessionFactory.getCurrentSession().beginTransaction();

			//● 新增-1 insert(0809測試OK-sum欄位建議不要用加總回傳，由前端計算好獨立回傳一個值，另DateMailed暫時改為String簡易測試)
//			PackBean bean = new PackBean();
//			bean.setId("p01708090001");
//			bean.setName("包裹7");
//			bean.setMemberId("m01707150001");
//			bean.setCardId("c01706010001");
//			bean.setCardPrice(168.88);
//			bean.setFontId("f01705110001");
//			bean.setFontPrice(0.0);
//			bean.setGiftSum(9487.94);
//			bean.setSum(12345.28);
//			bean.setContent("天啊!包裹的欄位好多啊~~");
//			bean.setRecipientId("r01704150002");
//			bean.setRecipientName("今天是付清節的隔一天");
//			bean.setRecipientPhone("0987654321");
//			bean.setRecipientCity("三藩市");
//			bean.setRecipientDistrict("活屍禁區");
//			bean.setRecipientAddr("綠島的梅花路");
//			bean.setDateMailed("2017-08-09");
//			bean.setSenderName("巧虎");
//			bean.setSenderPhone("0975312468");
//			bean.setSenderCity("是不市");
//			bean.setSenderDistrict("廁所蛆區");
//			bean.setSenderAddr("不知道甚麼路");
//			bean.setStatus(1);
//			dao.insert(bean);			
			
			//● 修改-2 update(0809測試OK-sum欄位建議不要用加總回傳，由前端計算好獨立回傳一個值，另DateMailed暫時改為String簡易測試)
//			PackBean bean = new PackBean();
//			bean.setId("p01708090001"); 
//			bean.setName("包裹7-1");
//			bean.setMemberId("m01707150001");
//			bean.setCardId("c01706010001");
//			bean.setCardPrice(168.88);
//			bean.setFontId("f01705110001");
//			bean.setFontPrice(0.0);
//			bean.setGiftSum(9487.94);
//			bean.setSum(12345.28);
//			bean.setContent("天啊!包裹的欄位好多啊~~");
//			bean.setRecipientId("r01704150002");
//			bean.setRecipientName("今天是付清節的隔一天");
//			bean.setRecipientPhone("0987654321");
//			bean.setRecipientCity("三藩市");
//			bean.setRecipientDistrict("活屍禁區");
//			bean.setRecipientAddr("綠島的梅花路");
//			bean.setDateMailed("2017-08-09");
//			bean.setSenderName("巧虎");
//			bean.setSenderPhone("0975312468");
//			bean.setSenderCity("是不市");
//			bean.setSenderDistrict("廁所蛆區");
//			bean.setSenderAddr("不知道甚麼路");
//			bean.setStatus(1);
//			dao.update(bean);			
			
			//● 刪除-3 deleteById(0809測試OK)
//			dao.deleteById("p01708090001");
			
			//● 查詢-4 selectById(0809測試OK)
//			PackBean bean = dao.selectById("p01708090001");
//			System.out.println(bean.getId());
//			System.out.println(bean.getName());
//			System.out.println(bean.getMemberId());
//			System.out.println(bean.getCardId());
//			System.out.println(bean.getCardPrice());
//			System.out.println(bean.getFontId());
//			System.out.println(bean.getFontPrice());
//			System.out.println(bean.getGiftSum());
//			System.out.println(bean.getSum());
//			System.out.println(bean.getContent());
//			System.out.println(bean.getRecipientId());
//			System.out.println(bean.getRecipientName());
//			System.out.println(bean.getRecipientPhone());
//			System.out.println(bean.getRecipientCity());
//			System.out.println(bean.getRecipientDistrict());
//			System.out.println(bean.getRecipientAddr());
//			System.out.println(bean.getDateMailed());
//			System.out.println(bean.getSenderName());
//			System.out.println(bean.getSenderPhone());
//			System.out.println(bean.getSenderCity());
//			System.out.println(bean.getSenderDistrict());
//			System.out.println(bean.getSenderAddr());
//			System.out.println(bean.getStatus());
			
			//● 查詢-5 selectWithBetween(0809測試OK)(查詢 String / double 型別的資料)
			//※同一測試程式只要給予符合"column"欄位的數值型別(如整數或小數)，即可正常執行查詢。
//			List<PackBean> list = dao.selectWithBetween("dateMailed", "2017-06-10","2017-06-30", "desc");
//			System.out.println("\n-----------------");
//			for(PackBean bean : list) {
//			System.out.print(bean.getId() + ",");
//			System.out.print(bean.getName() + ",");
//			System.out.print(bean.getMemberId() + ",");
//			System.out.print(bean.getCardId() + ",");
//			System.out.print(bean.getCardPrice() + ",");
//			System.out.print(bean.getFontId() + ",");
//			System.out.print(bean.getFontPrice() + ",");
//			System.out.print(bean.getGiftSum() + ",");
//			System.out.print(bean.getSum() + ",");
//			System.out.print(bean.getContent() + ",");
//			System.out.print(bean.getRecipientId() + ",");
//			System.out.print(bean.getRecipientName() + ",");
//			System.out.print(bean.getRecipientPhone() + ",");
//			System.out.print(bean.getRecipientCity() + ",");
//			System.out.print(bean.getRecipientDistrict() + ",");
//			System.out.print(bean.getRecipientAddr() + ",");
//			System.out.print(bean.getDateMailed() + ",");
//			System.out.print(bean.getSenderName() + ",");
//			System.out.print(bean.getSenderPhone() + ",");
//			System.out.print(bean.getSenderCity() + ",");
//			System.out.print(bean.getSenderDistrict() + ",");
//			System.out.print(bean.getSenderAddr() + ",");
//			System.out.println(bean.getStatus());
//			System.out.println("-------------");
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