package com.eeit95.her.model.gift;

import java.sql.SQLException;
import java.util.List;
import com.eeit95.her.model.gift.GiftBean;

public interface IGiftDAO {
	public void getConnection() throws SQLException;
	public int insert(GiftBean gift) throws SQLException;
	public int update(GiftBean gift) throws SQLException;
	public int delete(String id) throws SQLException;
	public GiftBean findByPrimaryKey(String id) throws SQLException;
	public List<GiftBean> getAll() throws SQLException;
	public void closeConn() throws SQLException;
	
}