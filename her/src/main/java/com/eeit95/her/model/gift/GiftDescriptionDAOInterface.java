package com.eeit95.her.model.gift;

import java.util.List;

public interface GiftDescriptionDAOInterface {
    
	public List<GiftDescriptionBean> insert(List<GiftDescriptionBean> beans);
	public boolean delete(GiftBean giftId, int orderNo);
	public List<GiftDescriptionBean> selectById(GiftBean giftId);
	public List<GiftDescriptionBean> selectByNo(int orderNo); 
	
}