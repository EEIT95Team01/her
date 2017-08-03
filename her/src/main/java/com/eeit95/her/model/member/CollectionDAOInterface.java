package com.eeit95.her.model.member;

import java.util.List;

public interface CollectionDAOInterface {
	 public void insert(CollectionBean collectionBean);
	 public void update(String memberId , String productId);
     public List<CollectionBean> findByPrimaryKey(String memberid, String productid);
     public List<CollectionBean> findByMemberId (String memberid);
     public List<CollectionBean> findByProductId (String productid);
     public void delete(String memerId);
     public List<CollectionBean> getAll();
}
