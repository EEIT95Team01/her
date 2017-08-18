package com.eeit95.her.model.pack;

import java.util.List;

public interface PackStatusDAOInterface {
	
	public PackStatusBean selectByPackStatus(int packStatus);
	
	public List<PackStatusBean> selectAll();
}
