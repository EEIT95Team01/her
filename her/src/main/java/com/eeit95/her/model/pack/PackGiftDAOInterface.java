package com.eeit95.her.model.pack;

import java.util.List;

public interface PackGiftDAOInterface {
	public PackGiftBean insert(PackGiftBean packGiftBean);
    public PackGiftBean update(PackGiftBean packGiftBean);
    public boolean delete(String packId,String giftId);
    public List<PackGiftBean> selectByPackId(String packId);
    public List<PackGiftBean> selectAll();
}
