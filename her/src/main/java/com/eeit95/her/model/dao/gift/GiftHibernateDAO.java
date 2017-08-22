package com.eeit95.her.model.dao.gift;

import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import com.eeit95.her.model.gift.GiftDAOInterface;

import com.eeit95.her.model.gift.GiftSelectBean;
import com.eeit95.her.model.misc.SpringJavaConfiguration;
import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardSelectAllBean;
import com.eeit95.her.model.category.CategoryBean;
import com.eeit95.her.model.gift.GiftBean;

import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class GiftHibernateDAO implements GiftDAOInterface{
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	
	private static final String selectAll = "from GiftBean ";

	@Override
	public GiftBean insert(GiftBean bean) {
		Session session = this.getSession();
		if(bean != null){
			GiftBean result = session.get(GiftBean.class, bean.getId());
			if(result == null){
				session.save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public GiftBean update(GiftBean bean) {
		Session session = this.getSession();
		GiftBean result = session.get(GiftBean.class,bean.getId());
		if(result != null){
			result.setId(bean.getId());
			result.setName(bean.getName());
			result.setPrice(bean.getPrice());
			result.setCover(bean.getCover());
			result.setViewCount(bean.getViewCount());
			result.setSalesCount(bean.getSalesCount());
			result.setStatus(bean.isStatus());
			result.setManufacturer(bean.getManufacturer());
			result.setCost(bean.getCost());
			result.setGpratio(bean.getGpratio());
			result.setStock(bean.getStock());
		}
		return result;
	}

	@Override
	public boolean delete(String id) {
		Session session = this.getSession();
		GiftBean bean = (GiftBean) session.get(GiftBean.class, id);
			if(bean != null) {
				session.delete(bean);
				return true;
			}
		return false;
	}

	@Override
	public GiftBean selectById(String id) {
		return this.getSession().get(GiftBean.class, id);
	}
	
	@Override
	public List<GiftBean> selectAll(String column, String ascOrDesc) {
		List<GiftBean> result = null;
		Session session = this.getSession();
			//selectAll = "from GiftBean "
			Query query = session.createQuery(selectAll);
			if(column != null) {
				if(ascOrDesc == "desc") {
					query = session.createQuery
							(selectAll + " order by " + column + " " + ascOrDesc);
				}else {
					query = session.createQuery
							(selectAll + " order by " + column + " " + " asc");
				}
			}
			result = query.list();
			return result;
		}


	@Override
	public List<GiftBean> selectTopN(int n,String column,String ascOrDesc) {
		
		List<GiftBean> result = null;
		Session session = this.getSession();;
			if(n>0) {
			String selectTopN = "from GiftBean where status = 1 order by "+ column + " " + ascOrDesc;
			Query query=session.createQuery(selectTopN);
			query.setMaxResults(n);
			result = query.list();
			}else {
				Query query=session.createQuery(selectAll);
				result = query.list();
			}
		return result;
	}
	
	@Override
	public List<GiftBean> selectWithBetween(String column, double lo, double hi, String ascOrDesc) {
		Session session = this.getSession();
		List<GiftBean> result = null;
		Criteria query = session.createCriteria(GiftBean.class);
		query.add(Restrictions.between(column, lo,hi));
		query.add(Restrictions.eq("status", true));
			if(ascOrDesc.equalsIgnoreCase("desc")){
				query.addOrder(Order.desc(column));
			}else {
				query.addOrder(Order.asc(column));
			} 
			result = query.list();
			return result;
	}
	
	@Override
	public List<GiftBean> selectWithBetween(String column, int lo, int hi, String ascOrDesc) {
		Session session = this.getSession();
		List<GiftBean> result = null;
		Criteria query = session.createCriteria(GiftBean.class);
		query.add(Restrictions.between(column, lo,hi));
		query.add(Restrictions.eq("status", true));
		if(ascOrDesc.equalsIgnoreCase("desc")){
			query.addOrder(Order.desc(column));
		}else {
			query.addOrder(Order.asc(column));
		} 
		result = query.list();
		return result;
	}
	
	
	@Override
	 public List <GiftBean> selectAllFC
		(String name, double loPrice, double hiPrice, int loSaleCount, int hiSaleCount, 
				String manufacturer, CategoryBean categoryId,String ascOrDesc, String column) {
		List<GiftBean> result = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(GiftBean.class);
		  if ("desc".equalsIgnoreCase(ascOrDesc)) {
		   criteria.addOrder(Order.desc(column));
		  } else {
		   criteria.addOrder(Order.asc(column));
		  }
		  if (name != null) {
		   criteria.add(Restrictions.like("name", "%name%"));
		  }
		  criteria.add(Restrictions.between("price", loPrice, hiPrice));
		  criteria.add(Restrictions.between("salesCount", loSaleCount, hiSaleCount));
		  if(manufacturer != null) {
			  criteria.add(Restrictions.like("manufacturer", "%manufacturer%"));
		  }
		  if(categoryId != null) {
			  criteria.add(Restrictions.idEq(categoryId));
		  }
		  result = criteria.list();
		  return result;
		 }
	
	@Override
	 public List <GiftBean> selectAllFM(GiftSelectBean giftSelectBean){
		List<GiftBean> list = null;
		System.out.println(giftSelectBean);
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(GiftBean.class);

		if (giftSelectBean.getId() != null &&giftSelectBean.getId().length()!=0) {
			System.out.println("GET　ＣａｒｄＩＤ～～");
			criteria.add(Restrictions.eq("id", giftSelectBean.getId()));
		} else {
			// criteria.add(Restrictions.eq("status", cardSelectBean.getStatus()));
			String name = giftSelectBean.getName();
			if (giftSelectBean.getName() != null && giftSelectBean.getName().trim().length() != 0) {
				criteria.add(Restrictions.like("name", "%" + name + "%"));
			}
			criteria.add(Restrictions.between("price", giftSelectBean.getLowPrice(), giftSelectBean.getHighPrice()));
			criteria.add(Restrictions.between("cost", giftSelectBean.getLowCost(), giftSelectBean.getHighCost()));
		}

		list = criteria.list();
		
		
//		List<GiftBean> result = null;
//		Session session = this.getSession();
//		Criteria criteria = session.createCriteria(GiftBean.class);
//		  if (giftSelectBean.getId() != null && giftSelectBean.getId().length() != 0) {
//				criteria.add(Restrictions.eq("id", giftSelectBean.getId()));
//		  }else {
//		  
//		  String name = giftSelectBean.getName();
//		  if (name != null && giftSelectBean.getName().trim().length() != 0) {
//			  	criteria.add(Restrictions.like("name", "%"+ name + "%"));
//		  }
//
//		  criteria.add(Restrictions.between("price", giftSelectBean.getLowPrice(), giftSelectBean.getHighPrice()));
//		  criteria.add(Restrictions.between("cost", giftSelectBean.getLowCost(), giftSelectBean.getHighCost()));
//		  
//		  String manufacturer = giftSelectBean.getManufacturer();
//		  if(manufacturer != null && giftSelectBean.getManufacturer().trim().length() != 0) {
//			  	criteria.add(Restrictions.like("manufacturer", "%" + manufacturer + "%"));
//		  }
//		  
//		  if(giftSelectBean.getStatus() == 0) {
//			  criteria.add(Restrictions.eq("status",0));
//		  }else if(giftSelectBean.getStatus() == 1) {
//			  criteria.add(Restrictions.eq("status",1));
//		  }}
//
//		  
//		  result = criteria.list();
		return list;
		 }	
	
	@Override
	 public String getNewId() {
	  Session session = this.getSession();
	  SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
	  String newsNo = "g"+df.format(new Date()).substring(1, 8);
	  System.out.println("newsNo = "+newsNo);
	  String temp2= null;  
	  String temp3= null;
	  Query query = session.createSQLQuery("SELECT top 1 g.id from gift as g order by id desc");
	  String no = (String) query.uniqueResult();
	  String temp =no.substring(1, 8);
	  System.out.println("temp = " +temp);
	  if(temp.equalsIgnoreCase(df.format(new Date()).substring(1, 8))) {
	   temp2=no.substring(no.length()-4);
	   System.out.println("temp2 = " +temp2);
	   int no2=Integer.parseInt(temp2);
	   temp3 = newsNo+("000"+(no2+1)).substring(("000"+(no2+1)).length()-4);
	   System.out.println("temp3 = " +temp3);
	  }else {
	   temp3 = newsNo+"0001";
	   System.out.println("temp3 = " +temp3);
	  }
	  return temp3;
	 }



//	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		GiftHibernateDAO dao = (GiftHibernateDAO) context.getBean("giftHibernateDAO");
//		
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//		
//		//● 新增-1(0807-Spring測試OK)(不需要cascade="save-update" 或 cascade="all"的設定)(這是經常要用到的一般新增)
//		CategoryBean cBean = new CategoryBean();
//		cBean.setId(6); //必須填入Category已有的Id，否則會新增失敗。
//		GiftBean gBean = new GiftBean(); // Gift的POJO
//		gBean.setId("g01708080002");
//		gBean.setName("IPhone9");
//		gBean.setPrice(1666);
//		gBean.setCover(null);
//		gBean.setViewCount(155);
//		gBean.setSalesCount(1234);
//		gBean.setStatus(true);
//		gBean.setManufacturer("D");
//		gBean.setCost(1333);
//		gBean.setGpratio(1222);
//		gBean.setStock(1111);
//		gBean.setCategoryId(cBean);
//		try {
//			dao.insert(gBean);
//			System.out.println("新增成功");
//		} catch (Exception e1) {
//			System.out.println("新增失敗");
//		}
//		
//		//● 修改-2(0807-Spring測試OK)(不需設定cascade="save-update" 或 cascade="all")(這是經常要用到的一般修改)
////		CategoryBean cBean = new CategoryBean();
////		cBean.setId(4);
////		GiftBean gBean = new GiftBean(); // Gift的POJO
////		gBean.setId("g01708070001");//【如果id不存在，則變成update】
////		gBean.setName("ASUS ZenFone10");
////		gBean.setPrice(1110);
////		gBean.setCover(null);
////		gBean.setViewCount(220);
////		gBean.setSalesCount(3330);
////		gBean.setStatus(true);
////		gBean.setManufacturer("D");
////		gBean.setCost(550);
////		gBean.setGpratio(4440);
////		gBean.setStock(660);
////		gBean.setCategoryId(cBean);
////		dao.update(gBean);
//
//		//●刪除-3(0807-Spring測試OK)//輸入id(String型別)
////		if(dao.delete("g01708070001") == true) {
////			System.out.println("刪除成功");
////		}else{
////			System.out.println("刪除失敗");
////		}; 
//
//		//● 查詢-4 selectById(0807-Spring測試OK)
////		GiftBean giftBean = dao.selectById("g01706210002"); //輸入id(String型別)
////		System.out.println("\n-----------------");
////		System.out.print(giftBean.getId() + ",");
////		System.out.print(giftBean.getName() + ",");
////		System.out.print(giftBean.getPrice() + ",");
////		System.out.print(giftBean.getCover() + ",");
////		System.out.print(giftBean.getViewCount() + ",");
////		System.out.print(giftBean.getSalesCount() + ",");
////		System.out.print(giftBean.isStatus() + ",");
////		System.out.print(giftBean.getManufacturer() + ",");
////		System.out.print(giftBean.getCost() + ",");
////		System.out.print(giftBean.getGpratio() + ",");
////		System.out.print(giftBean.getStock() + ",");
////		System.out.print(giftBean.getCategoryId().getId() + ",");
////		System.out.println("\n-----------------");
//
//		//● 查詢-5 selectAll(0807-Spring測試OK)
//		//依上架時間/熱銷度/價格查詢(利用order by "欄位名稱" 排序(asc/desc，預設為升冪))
////		String column = "price";
////		String ascOrDesc = null;//未給值預設為null，採升冪排序。
////		List<GiftBean> list = dao.selectAll(column, ascOrDesc);
////		System.out.println("\n-----------------");
////		for (GiftBean gVO : list) {
////		System.out.print(gVO.getId() + ",");
////		System.out.print(gVO.getName() + ",");
////		System.out.print(gVO.getPrice() + ",");
////		System.out.print(gVO.getCover() + ",");
////		System.out.print(gVO.getViewCount() + ",");
////		System.out.print(gVO.getSalesCount() + ",");
////		System.out.print(gVO.isStatus() + ",");
////		System.out.print(gVO.getManufacturer() + ",");
////		System.out.print(gVO.getCost() + ",");
////		System.out.print(gVO.getGpratio() + ",");
////		System.out.print(gVO.getStock() + ",");
////		System.out.print(gVO.getCategoryId().getId() + ",");
////		System.out.println();
////		System.out.println("\n-----------------");
////		}
//		
//		//● 查詢 -6 selectTopN(測試NG)
////		List<GiftBean> list = dao.selectTopN(3, "cost", "asc");
////		System.out.println("\n-----------------");
////		for (GiftBean bean : list) {
////			System.out.print(bean.getId() + ",");
////			System.out.print(bean.getName() + ",");
////			System.out.print(bean.getPrice() + ",");
////			System.out.print(bean.getCover() + ",");
////			System.out.print(bean.getViewCount() + ",");
////			System.out.print(bean.getSalesCount() + ",");
////			System.out.print(bean.isStatus() + ",");
////			System.out.print(bean.getManufacturer() + ",");
////			System.out.print(bean.getCost() + ",");
////			System.out.print(bean.getGpratio() + ",");
////			System.out.print(bean.getStock() + ",");
////			System.out.print(bean.getCategoryId().getId() + ",");
////			System.out.println();
////			System.out.println("\n-----------------");
////			}
//		
////		//● 查詢 -7 selectWithBetween(0807-Spring測試OK)(查詢 int / double 型別的資料)
//		//※同一測試程式只要給予符合"column"欄位的數值型別(如整數或小數)，即可正常執行查詢。
////		List<GiftBean> list = dao.selectWithBetween("cost",10.0,500.0,"asc");
////		System.out.println("\n-----------------");
////		for (GiftBean gVO : list) {
////			System.out.print(gVO.getId() + ",");
////			System.out.print(gVO.getName() + ",");
////			System.out.print(gVO.getPrice() + ",");
////			System.out.print(gVO.getCover() + ",");
////			System.out.print(gVO.getViewCount() + ",");
////			System.out.print(gVO.getSalesCount() + ",");
////			System.out.print(gVO.isStatus() + ",");
////			System.out.print(gVO.getManufacturer() + ",");
////			System.out.print(gVO.getCost() + ",");
////			System.out.print(gVO.getGpratio() + ",");
////			System.out.print(gVO.getStock() + ",");
////			System.out.print(gVO.getCategoryId().getId() + ",");
////			System.out.println();
////			System.out.println("\n-----------------");
////		}	
//		
//		//● 查詢 -8 selectAllFC(0807測試NG-只找到空陣列[])
////		CategoryBean cBean = new CategoryBean(); 
////		cBean.setId(2);
////		List <GiftBean> selectAllFC = dao.selectAllFC
////				("日本", 1.0, 10000.0, 1, 100000, null, null, "desc", "price");
////		for (GiftBean gVO : selectAllFC) {
////			System.out.print(gVO.getId() + ",");
////			System.out.print(gVO.getName() + ",");
////			System.out.print(gVO.getPrice() + ",");
////			System.out.print(gVO.getCover() + ",");
////			System.out.print(gVO.getViewCount() + ",");
////			System.out.print(gVO.getSalesCount() + ",");
////			System.out.print(gVO.isStatus() + ",");
////			System.out.print(gVO.getManufacturer() + ",");
////			System.out.print(gVO.getCost() + ",");
////			System.out.print(gVO.getGpratio() + ",");
////			System.out.print(gVO.getStock() + ",");
////			System.out.print(gVO.getCategoryId().getId() + ",");
////			System.out.print(gVO.getCategoryId().getSubName());
////			System.out.println();				
////		}
////		System.out.println(selectAllFC);
//			
//			
//			//● 查詢 -9 selectAllFC(0807測試NG-java.lang.Integer cannot be cast to java.lang.Double)
////		List <GiftBean> selectAllFM = dao.selectAllFM(null, "日本", 1.0, 10000.0, 1, 100000, 1, 100000,
////				null, 1.0, 100000.0, 1.0, 100000.0, 1, 100000, null, null, "id", 1);
////		for (GiftBean gVO : selectAllFM) {
////			System.out.print(gVO.getId() + ",");
////			System.out.print(gVO.getName() + ",");
////			System.out.print(gVO.getPrice() + ",");
////			System.out.print(gVO.getCover() + ",");
////			System.out.print(gVO.getViewCount() + ",");
////			System.out.print(gVO.getSalesCount() + ",");
////			System.out.print(gVO.isStatus() + ",");
////			System.out.print(gVO.getManufacturer() + ",");
////			System.out.print(gVO.getCost() + ",");
////			System.out.print(gVO.getGpratio() + ",");
////			System.out.print(gVO.getStock() + ",");
////			System.out.print(gVO.getCategoryId().getId() + ",");
////			System.out.print(gVO.getCategoryId().getSubName());
////			System.out.println();				
////		}
////		System.out.println(selectAllFM);
//
//		sessionFactory.getCurrentSession().getTransaction().commit();
//		} catch (RuntimeException ex) {
//			sessionFactory.getCurrentSession().getTransaction().rollback();
//			throw ex;
//		} finally {
//			((ConfigurableApplicationContext) context).close();
//		}
//
//	}
}