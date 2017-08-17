package com.eeit95.her.model.category;
import java.util.*;

public interface CategoryDAOInterface {

	public CategoryBean insert(CategoryBean bean);
	public CategoryBean update(CategoryBean bean);
	public boolean delete(int id);
	public CategoryBean selectById(int id);
	public List<CategoryBean> selectByMainId(CategoryMainBean mainId);
	public List<CategoryBean> selectAll();
	
}