package com.eeit95.her.model.member;

import java.util.List;

public interface HistoryDAOInterface {
	 public void insert(HistoryBean MemberBean);
     public List<HistoryBean> findByPrimaryKey(String memberid, String productid);
     public List<HistoryBean> findByMemberId (String memberid);
     public List<HistoryBean> findByProductId (String productid);
     public void delete(String memerId);
     public List<HistoryBean> getAll();
}
