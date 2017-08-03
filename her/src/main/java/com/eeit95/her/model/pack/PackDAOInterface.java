package com.eeit95.her.model.pack;

import java.util.List;

public interface PackDAOInterface {
	
	public List<PackBean> selectByMIdAndStatus(String memberId, int status);
	
	public PackBean selectById(String id);
	
	public List<PackBean> selectWithBetween(String column, Double low, Double high, String ascOrDesc);
	
	public List<PackBean> selectWithBetween(String column, String low, String high, String ascOrDesc);
	
	public PackBean insert(PackBean packagebean);
	
	public PackBean update(PackBean packageBean);
	
	public boolean deleteById(String id);
	
}
