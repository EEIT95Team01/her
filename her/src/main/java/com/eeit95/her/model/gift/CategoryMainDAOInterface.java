package com.eeit95.her.model.gift;

import java.util.*;

public interface CategoryMainDAOInterface {

	public void insert(CategoryMainBean categoryMainVO);
	public void update(CategoryMainBean categoryMainVO);
	public boolean delete(Integer id);
	public CategoryMainBean selectById(Integer id);
	public List<CategoryMainBean> selectAll();
	
}
