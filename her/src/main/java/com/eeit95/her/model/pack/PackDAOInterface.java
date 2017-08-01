package com.eeit95.her.model.pack;

import java.util.List;

public interface PackDAOInterface {
	
	public List<PackBean> selectByMIdAndStatus(String memberId, int status);
	
	public PackBean selectById(String id);
	
	public PackBean insert(PackBean packagebean);
	
	public PackBean update(PackBean packageBean);
	
	public int deleteById(String id);
	
}
