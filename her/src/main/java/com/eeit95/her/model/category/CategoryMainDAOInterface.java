package com.eeit95.her.model.category;

import java.util.*;

public interface CategoryMainDAOInterface {

	public CategoryMainBean insert(CategoryMainBean bean);
	public CategoryMainBean update(CategoryMainBean bean);
	public boolean delete(int id);
	public CategoryMainBean selectById(int id);
	public List<CategoryMainBean> selectAll();
	
}
