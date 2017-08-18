package com.eeit95.her.model.pack;

import java.util.List;

public interface PackDAOInterface {
	
	public List<PackBean> selectByMIdAndStatus(String memberId, int status);
	
	public PackBean selectById(String id);
	
	public PackBean insert(PackBean bean);
	
	public PackBean update(PackBean bean);
	
	public boolean deleteById(String id);
	
	public List<PackBean> selectAllFM(PackSelectBean packSelectBean);
	
	public String getNewId();
	
}
