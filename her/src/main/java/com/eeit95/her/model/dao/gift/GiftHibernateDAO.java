package com.eeit95.her.model.dao.gift;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import com.eeit95.her.model.gift.GiftDAOInterface;
import com.eeit95.her.model.gift.GiftBean;
import hibernate.util.HibernateUtil;
import java.util.*;

public class GiftHibernateDAO implements GiftDAOInterface{

//	private static int n = 0;
//	private static String type = null;
	
	private static final String delete = "delete from GiftBean where id=?";
	private static final String selectAll = "from GiftBean order by id";

	@Override
	public void insert(GiftBean giftVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(giftVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(GiftBean giftVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(giftVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public boolean delete(String id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		GiftBean result = null;
		try {
			result = (GiftBean) session.get(GiftBean.class, id);
			if(result != null) {
				Query query = session.createQuery(delete);
				query.setParameter(0, id);
				System.out.println("刪除筆數： " + query.executeUpdate());
				session.getTransaction().commit();
				return true;
			}
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return false;
	}

	@Override
	public GiftBean selectById(String id) {
		GiftBean giftVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			giftVO = (GiftBean) session.get(GiftBean.class, id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return giftVO;
	}
	
	@Override
	public List<GiftBean> selectAll() {
		List<GiftBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(selectAll);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	@Override
	public List<GiftBean> selectAll(int n,String type,String desc) {
		String Select_All_TopN = null;
		Select_All_TopN = 
				"from GiftBean where status = 1 ORDER BY " + type +" "+ desc;
		System.out.println(Select_All_TopN);
		List<GiftBean> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			if(n>0) {
			Query query=session.createQuery(Select_All_TopN);
			query.setMaxResults(n);
			result = query.list();
			session.getTransaction().commit();
			}else {
				Query query=session.createQuery(Select_All_TopN);
				result = query.list();
				session.getTransaction().commit();
			}
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}
	
	@Override
	public List<GiftBean> selectBetween(double lo, double hi) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<GiftBean> list = null;
		try {
			Criteria query = session.createCriteria(GiftBean.class);
			query.add(Restrictions.between("price", lo,hi));
			list = query.list();
			session.getTransaction().commit();
			
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
		return list;
	}

	
	

	public static void main(String[] args) {
		GiftHibernateDAO dao = new GiftHibernateDAO();
		
		//● 新增-1(Git測試OK)(不需要cascade="save-update" 或 cascade="all"的設定)(這是經常要用到的一般新增)
//		CategoryBean cVO = new CategoryBean();
//		cVO.setId(6); //必須填入Category已有的Id，否則會新增失敗。
//		GiftBean giftBean = new GiftBean(); // Gift的POJO
//		giftBean.setId("g01708020004");
//		giftBean.setName("IPhone8");
//		giftBean.setPrice(666);
//		giftBean.setCover(null);
//		giftBean.setViewCount(55);
//		giftBean.setSalesCount(234);
//		giftBean.setStatus(true);
//		giftBean.setManufacturer("D");
//		giftBean.setCost(333);
//		giftBean.setGpratio(222);
//		giftBean.setStock(111);
//		giftBean.setCategoryId(cVO);
//		dao.insert(giftBean);
		
		//● 修改-2(Git測試OK)(不需設定cascade="save-update" 或 cascade="all")(這是經常要用到的一般修改)
//		CategoryBean cVO = new CategoryBean();
//		cVO.setId(4);
//		GiftBean giftBean = new GiftBean(); // Gift的POJO
//		giftBean.setId("g01708020004");//【如果id不存在，則變成update】
//		giftBean.setName("魯夫的草帽");
//		giftBean.setPrice(111);
//		giftBean.setCover(null);
//		giftBean.setViewCount(22);
//		giftBean.setSalesCount(333);
//		giftBean.setStatus(true);
//		giftBean.setManufacturer("D");
//		giftBean.setCost(55);
//		giftBean.setGpratio(444);
//		giftBean.setStock(66);
//		giftBean.setCategoryId(cVO);
//		dao.update(giftBean);	

		//●刪除-3(測試OK)
//		dao.delete("g01708020004"); //輸入id(String型別)

		//● 查詢-4 selectById(Git測試OK)
//		GiftBean giftBean = dao.selectById("g01708020003"); //輸入id(String型別)
//		System.out.print(giftBean.getId() + ",");
//		System.out.print(giftBean.getName() + ",");
//		System.out.print(giftBean.getPrice() + ",");
//		System.out.print(giftBean.getCover() + ",");
//		System.out.print(giftBean.getViewCount() + ",");
//		System.out.print(giftBean.getSalesCount() + ",");
//		System.out.print(giftBean.isStatus() + ",");
//		System.out.print(giftBean.getManufacturer() + ",");
//		System.out.print(giftBean.getCost() + ",");
//		System.out.print(giftBean.getGpratio() + ",");
//		System.out.print(giftBean.getStock() + ",");
//		System.out.print(giftBean.getCategoryId().getId() + ",");
//		System.out.println("\n-----------------");		

		//● 查詢-5 selectAll(Git測試OK)
//		List<GiftBean> list = dao.selectAll();
//		for (GiftBean gVO : list) {
//		System.out.print(gVO.getId() + ",");
//		System.out.print(gVO.getName() + ",");
//		System.out.print(gVO.getPrice() + ",");
//		System.out.print(gVO.getCover() + ",");
//		System.out.print(gVO.getViewCount() + ",");
//		System.out.print(gVO.getSalesCount() + ",");
//		System.out.print(gVO.isStatus() + ",");
//		System.out.print(gVO.getManufacturer() + ",");
//		System.out.print(gVO.getCost() + ",");
//		System.out.print(gVO.getGpratio() + ",");
//		System.out.print(gVO.getStock() + ",");
//		System.out.print(gVO.getCategoryId().getId() + ",");
//		System.out.println();
//		}
		
//		//● 查詢 -6 SELECT TopN & PRINT(Git測試OK)
//		List<GiftBean> result = dao.selectAll(0,"viewCount","asc");
//		System.out.println("SELECT 所有資料 & PRINT");
//		for (GiftBean gVO : result) {
//			System.out.print(gVO.getId() + ",");
//			System.out.print(gVO.getName() + ",");
//			System.out.print(gVO.getPrice() + ",");
//			System.out.print(gVO.getCover() + ",");
//			System.out.print(gVO.getViewCount() + ",");
//			System.out.print(gVO.getSalesCount() + ",");
//			System.out.print(gVO.isStatus() + ",");
//			System.out.print(gVO.getManufacturer() + ",");
//			System.out.print(gVO.getCost() + ",");
//			System.out.print(gVO.getGpratio() + ",");
//			System.out.print(gVO.getStock() + ",");
//			System.out.print(gVO.getCategoryId().getId() + ",");
//			System.out.println();
//			}
		
//		//● 查詢 -7 SELECT 所有資料 & PRINT(Git測試OK)
		List<GiftBean> beans = dao.selectBetween(50	,100);
		System.out.println("SELECT Between & PRINT");
		for (GiftBean gVO : beans) {
			System.out.print(gVO.getId() + ",");
			System.out.print(gVO.getName() + ",");
			System.out.print(gVO.getPrice() + ",");
			System.out.print(gVO.getCover() + ",");
			System.out.print(gVO.getViewCount() + ",");
			System.out.print(gVO.getSalesCount() + ",");
			System.out.print(gVO.isStatus() + ",");
			System.out.print(gVO.getManufacturer() + ",");
			System.out.print(gVO.getCost() + ",");
			System.out.print(gVO.getGpratio() + ",");
			System.out.print(gVO.getStock() + ",");
			System.out.print(gVO.getCategoryId().getId() + ",");
			System.out.println();				
		}	
	
	}
}