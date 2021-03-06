package com.eeit95.her.model.advertisement;

import java.util.Date;
import java.util.List;

public interface AdvertisementDAOInterface {
	public AdvertisementBean insert(AdvertisementBean advertisementBean);
    public AdvertisementBean update(AdvertisementBean advertisementBean);
    public boolean delete(int id);
    public AdvertisementBean selectById(int id);
    public List<AdvertisementBean> select(int id,String name,Date selectBeginDate,Date selectEndDate);
    public List<AdvertisementBean> selectByDate(); 
    public List<AdvertisementBean> selectAll();
}
