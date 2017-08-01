package com.eeit95.her.model.gift;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryMainDAO {
	
			public void getConnection() throws SQLException;
			public int insert(CategoryMainBean categoryMain) throws SQLException;
			public int update(CategoryMainBean categoryMain) throws SQLException;
			public int delete(int id) throws SQLException;
			public CategoryMainBean findByPrimaryKey(int id) throws SQLException;
			public List<CategoryMainBean> getAll() throws SQLException;
			public void closeConn() throws SQLException;
			
	}