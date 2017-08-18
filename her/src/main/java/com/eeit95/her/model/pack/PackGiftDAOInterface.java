package com.eeit95.her.model.pack;

import java.util.List;

public interface PackGiftDAOInterface {
	
    public PackGiftBean insert(PackGiftBean bean);
    public PackGiftBean update(PackGiftBean bean);
    public boolean delete(String packId,String giftId);
    public List<PackGiftBean> selectByPackId(String packId);
    public List<PackGiftBean> selectAll();

}
