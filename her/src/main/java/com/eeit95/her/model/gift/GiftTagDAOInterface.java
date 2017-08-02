package com.eeit95.her.model.gift;

import java.util.List;

public interface GiftTagDAOInterface {
	
	public void insert(GiftTagBean giftTagVO);
	public boolean delete(GiftBean giftId, Integer tagId);
	public List<GiftTagBean> selectById(GiftBean giftId);
	public List<GiftTagBean> selectAll();
	
}