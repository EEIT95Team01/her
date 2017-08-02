package com.eeit95.her.model.gift;

import java.util.List;

public interface GiftDescriptionDAOInterface {
	        
	public void insert(GiftDescriptionBean giftDescriptionVO);
	public void update(GiftDescriptionBean giftDescriptionVO);
	public boolean delete(GiftBean giftId, Integer orderNo);
	public List<GiftDescriptionBean> selectById(GiftBean giftId);
	public List<GiftDescriptionBean> selectByNo(Integer orderNo); 
	public List<GiftDescriptionBean> selectAll();
	
}