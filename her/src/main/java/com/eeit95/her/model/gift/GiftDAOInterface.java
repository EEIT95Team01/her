package com.eeit95.her.model.gift;

import java.util.List;

public interface GiftDAOInterface {

	public void insert(GiftBean giftVO);
	public void update(GiftBean giftVO);
	public boolean delete(String id);
	public GiftBean selectById(String id);
	public List<GiftBean> selectAll();
	public List<GiftBean> selectAll(int n,String type,String desc); 
	public abstract List <GiftBean> selectBetween(double lo,double hi);
}