package com.eeit95.her.model.gift;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDAO {
	public void getConnection() throws SQLException;
	public int insert(CategoryBean category) throws SQLException;
	public int update(CategoryBean category) throws SQLException;
	public int delete(int id) throws SQLException;
	public CategoryBean findByPrimaryKey(int id) throws SQLException;
	public List<CategoryBean> getAll() throws SQLException;
	public void closeConn() throws SQLException;
	
}