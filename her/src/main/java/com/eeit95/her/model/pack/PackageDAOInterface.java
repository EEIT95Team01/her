package com.eeit95.her.model.pack;

import java.util.List;

public interface PackageDAOInterface {
	
	public List<String> getPackageIds(String memberId, int status);
	
	public PackageBean selectById(String id);
	
	public int insert(PackageBean packagebean);
	
	public int update(PackageBean packageBean);
	
	public int deleteById(String id);
	
}
