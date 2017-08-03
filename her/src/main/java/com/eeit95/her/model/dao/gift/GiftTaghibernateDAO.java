package com.eeit95.her.model.dao.gift;

import org.hibernate.*;
import hibernate.util.HibernateUtil;
import java.util.*;
import com.eeit95.her.model.gift.GiftTagDAOInterface;
import com.eeit95.her.model.gift.GiftTagBean;
import com.eeit95.her.model.gift.GiftBean;

//GiftTag沒有設定修改功能(標籤tag不需要用修改功能，實務上只需要刪除再新增即可)
public class GiftTaghibernateDAO implements GiftTagDAOInterface{
	
	private static final String selectAll = "from GiftTagBean order by giftId";
	private static final String delete = "delete from GiftTagBean where giftId=? and tagId=?";
	private static final String selectById = "from GiftTagBean where giftId = ?";
	@Override
	public void insert(GiftTagBean giftTagVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(giftTagVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public boolean delete(GiftBean giftId, Integer tagId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query =session.createQuery(delete);
			query.setParameter(0,giftId);
			query.setParameter(1, tagId);
			if(query.executeUpdate()>0){
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
	public List<GiftTagBean> selectById(GiftBean giftId) {
		List<GiftTagBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(selectById);
			query.setParameter(0, giftId);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return  list;
	}

	@Override
	public List<GiftTagBean> selectAll() {
		List<GiftTagBean> list = null;
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

	

	public static void main(String[] args) {
		
		GiftTaghibernateDAO dao = new GiftTaghibernateDAO();
		
		//● 新增-1 (Git測試OK)(不需要cascade="save-update" 或 cascade="all"的設定)(這是經常要用到的一般新增)
//		GiftBean gVO = new GiftBean();
//		gVO.setId("g01708020001"); //必須填入Gift已有的Id，否則會新增失敗。
//		GiftTagBean giftTagVO = new GiftTagBean(); // GiftTag的POJO
//		giftTagVO.setGiftId(gVO);
//		giftTagVO.setTagId(4);
//		dao.insert(giftTagVO);

		//●刪除-2 (Git測試OK)
//		GiftBean gVO = new GiftBean();
//		gVO.setId("g01708020001"); //【如果id不存在，刪除不會有影響】
//		dao.delete(gVO,6);

		//● 查詢-3 selectById(Git測試OK)
//		GiftBean gVO = new GiftBean();
//		gVO.setId("g01708020002");//輸入id(String型別)
//		List<GiftTagBean> giftTagVOs = dao.selectById(gVO); 
//		for (GiftTagBean giftTagVO : giftTagVOs) {
//		System.out.print(giftTagVO.getGiftId().getId()+ ",");
//		System.out.print(giftTagVO.getTagId() + ",");
//		System.out.println();
//		}	

		//● 查詢-4 getAll(Git測試OK)
		List<GiftTagBean> list = dao.selectAll();
		for (GiftTagBean gtVO : list) {
		System.out.print(gtVO.getGiftId().getId() + ",");
		System.out.print(gtVO.getTagId() + ",");
			System.out.println();
		}

	}
}