package com.eeit95.her.model.dao.gift;

import org.hibernate.*;
import com.eeit95.her.model.gift.GiftDescriptionDAOInterface;
import com.eeit95.her.model.gift.GiftDescriptionBean;
import com.eeit95.her.model.gift.GiftBean;
import hibernate.util.HibernateUtil;
import java.util.*;



public class GiftDescriptionHibernateDAO  implements GiftDescriptionDAOInterface{

	private static final String delete = 
			"delete from GiftDescriptionBean where giftId=? and orderNo=?";
	private static final String selectById = "from GiftDescriptionBean where giftId = ?";
	private static final String selectByNo = "from GiftDescriptionBean where orderNo = ?";
	private static final String selectAll = "from GiftDescriptionBean order by orderNo";
	
	@Override
	public void insert(GiftDescriptionBean giftDescriptionVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(giftDescriptionVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(GiftDescriptionBean giftDescriptionVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(giftDescriptionVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public boolean delete(GiftBean giftId, Integer orderNo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query =session.createQuery(delete);
			query.setParameter(0,giftId);
			query.setParameter(1, orderNo);
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
	public List<GiftDescriptionBean> selectById(GiftBean giftId) {
		List<GiftDescriptionBean> list = null;
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
	public List<GiftDescriptionBean> selectByNo(Integer orderNo) {
		List<GiftDescriptionBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(selectByNo);
			query.setParameter(0, orderNo);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return  list;
	}

	@Override
	public List<GiftDescriptionBean> selectAll() {
		List<GiftDescriptionBean> list = null;
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
		GiftDescriptionHibernateDAO dao = new GiftDescriptionHibernateDAO();
		//● 新增-1(Git測試OK)(不需要cascade="save-update" 或 cascade="all"的設定)(這是經常要用到的一般新增)
//		GiftBean gVO = new GiftBean();
//		gVO.setId("g01708020002"); //必須填入Gift已有的Id，否則會新增失敗。
//		GiftDescriptionBean giftDescriptionVO = new GiftDescriptionBean(); // Gift的POJO
//		giftDescriptionVO.setGiftId(gVO);
//		giftDescriptionVO.setOrderNo(3);
//		giftDescriptionVO.setText("廢物大雄");
//		giftDescriptionVO.setImage(null);
//		dao.insert(giftDescriptionVO);
		
		//● 修改-2(Git測試OK)(不需設定cascade="save-update" 或 cascade="all")(這是經常要用到的一般修改)
//		GiftBean gVO = new GiftBean();
//		gVO.setId("g01708020002");//【如果id不存在，則會修改失敗】
//		GiftDescriptionBean giftDescriptionBean = new GiftDescriptionBean(); // giftDescription的POJO
//		giftDescriptionBean.setGiftId(gVO);
//		giftDescriptionBean.setOrderNo(3);
//		giftDescriptionBean.setText("智障大雄");
//		giftDescriptionBean.setImage(null);
//		dao.update(giftDescriptionBean);	

		//●刪除-3 (Git測試OK)
//		GiftBean gVO = new GiftBean();
//		gVO.setId("g01708020002");//【如果id不存在，刪除不會有影響】
//		dao.delete(gVO,3);

		//● 查詢-4 selectById(Git測試OK)
//		GiftBean gVO = new GiftBean();
//		gVO.setId("g01708020001");//輸入id(String型別)
//		List<GiftDescriptionBean> giftDescriptionBean = dao.selectById(gVO); 
//		for (GiftDescriptionBean giftDescVO : giftDescriptionBean) {
//		System.out.print(giftDescVO.getGiftId().getId()+ ",");
//		System.out.print(giftDescVO.getOrderNo() + ",");
//		System.out.print(giftDescVO.getText() + ",");
//		System.out.print(giftDescVO.getImage() + ",");
//		System.out.println();
//		}
		
		//● 查詢-5 selectByNo(Git測試OK)
		List<GiftDescriptionBean> giftDescriptionBean = 
				dao.selectByNo(1);  //輸入orderNo的值，如果輸入的值尚未存在，則會搜尋不到。
		for (GiftDescriptionBean giftDescVO : giftDescriptionBean) {
		System.out.print(giftDescVO.getOrderNo() + ",");
		System.out.print(giftDescVO.getGiftId().getId()+ ",");
		System.out.print(giftDescVO.getText() + ",");
		System.out.print(giftDescVO.getImage() + ",");
		System.out.println();
		}

		//● 查詢-6 selectAll(Git測試OK)
//		List<GiftDescriptionBean> list = dao.selectAll();
//		for (GiftDescriptionBean giftDescVO : list) {
//		System.out.print(giftDescVO.getGiftId().getId()+ ",");
//		System.out.print(giftDescVO.getOrderNo() + ",");
//		System.out.print(giftDescVO.getText() + ",");
//		System.out.print(giftDescVO.getImage() + ",");
//		System.out.println();
//		}
	}
}