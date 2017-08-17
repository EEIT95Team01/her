package com.eeit95.her.model.gift;

import java.util.List;
import com.eeit95.her.model.tag.TagBean;

public interface GiftTagDAOInterface {

	public List<GiftTagBean> insert(List<GiftTagBean> beans);
	public boolean delete(String giftId, int tagId);
	public boolean deleteById(String giftId);
	public boolean deleteByTagId(int tagId);
	public List<GiftTagBean> selectById(String giftId);
	public List<GiftTagBean> selectByTagId(int tagId);
	public List<GiftTagBean> selectAll();
	
}