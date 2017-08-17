package com.eeit95.her.model.dao.member;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eeit95.her.model.member.CollectionBean;
import com.eeit95.her.model.member.CollectionDAO_interface;

@Repository
public class CollectionHibernateDAO implements CollectionDAO_interface {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private static final String GET_ALL_COLLECTION = "from CollectionBean where memberId  = ? order by addTime desc";
	private static final String GET_ALL_CARD_COLLECTION = "from CollectionBean where memberId  = ? and productId like 'c%' order by addTime desc";
	private static final String GET_ALL_FONT_COLLECTION = "from CollectionBean where memberId  = ? and productId like 'f%' order by addTime desc";
	private static final String GET_ALL_GIFT_COLLECTION = "from CollectionBean where memberId  = ? and productId like 'g%' order by addTime desc";
	@Override
	public CollectionBean insert(String memberId , String productId) {
		
		long dateTime = System.currentTimeMillis();
		CollectionBean cb = new CollectionBean();
		// 取出某個會員的collection
		List<CollectionBean> list = this.allCollection(memberId);
		if (list == null) {
			cb.setMemberId(memberId);
			cb.setProductId(productId);
			cb.setAddTime(new java.sql.Timestamp(dateTime));
			this.getSession().save(cb);
			return cb;
		} else {
			for (CollectionBean x : list) {
				if (productId.trim().equals(x.getProductId().trim())) {
					// 代表有相同商品已在collection裡
					return null;
				}
			}
		}
		
		cb.setMemberId(memberId);
		cb.setProductId(productId);
		cb.setAddTime(new java.sql.Timestamp(dateTime));
		this.getSession().save(cb);
		return cb;

	}

//	// 其實不知道要這個幹嘛
//	@Override
//	public CollectionBean update(CollectionBean collectionBean) {
//		String productId = collectionBean.getProductId();
//		// 取出某個會員的collection
//		List<CollectionBean> list = this.allCollection(collectionBean.getMemberId());
//		for (CollectionBean x : list) {
//			if (productId.trim().equals(x.getProductId().trim())) {
//				x.setAddTime(collectionBean.getAddTime());
//				this.getSession().update(x);
//				return x;
//			}
//		}
//
//		return null;
//	}

	@Override
	public Boolean delete(String memberId , String productId) {
		// 取出某個會員的collection
		List<CollectionBean> list = this.allCollection(memberId);
		for (CollectionBean x : list) {
			if (productId.trim().equals(x.getProductId().trim())) {
				this.getSession().delete(x);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<CollectionBean> allCollection(String memberId) {
		List<CollectionBean> list;
		Query query = this.getSession().createQuery(GET_ALL_COLLECTION);
		query = query.setParameter(0, memberId);
		list = query.list();

		if (list != null) {
			return list;
		} else {
			// 沒有查詢到or查詢失敗
			return null;
		}
	}

	@Override
	public List<CollectionBean> allCardCollection(String memberId) {
		List<CollectionBean> list;
		Query query = this.getSession().createQuery(GET_ALL_CARD_COLLECTION);
		query = query.setParameter(0, memberId);
		list = query.list();

		if (list != null) {
			return list;
		} else {
			// 沒有查詢到or查詢失敗
			return null;
		}
	}

	@Override
	public List<CollectionBean> allFontCollection(String memberId) {
		List<CollectionBean> list;
		Query query = this.getSession().createQuery(GET_ALL_FONT_COLLECTION);
		query = query.setParameter(0, memberId);
		list = query.list();

		if (list != null) {
			return list;
		} else {
			// 沒有查詢到or查詢失敗
			return null;
		}
	}

	@Override
	public List<CollectionBean> allGiftCollection(String memberId) {
		List<CollectionBean> list;
		Query query = this.getSession().createQuery(GET_ALL_GIFT_COLLECTION);
		query = query.setParameter(0, memberId);
		list = query.list();

		if (list != null) {
			return list;
		} else {
			// 沒有查詢到or查詢失敗
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
}
