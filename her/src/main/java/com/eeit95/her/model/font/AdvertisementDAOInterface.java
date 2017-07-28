package com.eeit95.her.model.font;

import java.util.List;

public interface AdvertisementDAOInterface {
	public void insert(AdvertisementBean advertisementBean);
    public void update(AdvertisementBean advertisementBean);
    public void delete(int id);
    public AdvertisementBean selectById(int id);
    public List<AdvertisementBean> selectByDate(); 
    public List<AdvertisementBean> selectAll();
}
