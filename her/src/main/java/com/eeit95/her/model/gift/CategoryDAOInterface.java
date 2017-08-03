package com.eeit95.her.model.gift;
import java.util.*;

public interface CategoryDAOInterface {

	public void insert(CategoryBean categoryVO);
	public void update(CategoryBean categoryVO);
	public boolean delete(Integer id);
	public CategoryBean selectById(Integer id);
	public List<CategoryBean> selectByMainId(CategoryMainBean mainId);
	public List<CategoryBean> selectAll();
	
}