package com.eeit95.her.model.gift;

import java.sql.SQLException;
import java.util.List;

public interface IGiftDescriptionDAO {
	
	public void getConnection() throws SQLException;
	public int insert(GiftDescriptionBean giftDesc) throws SQLException;
	public int update(GiftDescriptionBean giftDesc) throws SQLException;
	public int delete(String giftId, int g_order) throws SQLException;
	public GiftDescriptionBean findByPrimaryKey(String giftId, int g_order) throws SQLException;
	public List<GiftDescriptionBean> getAll() throws SQLException;
	public void closeConn() throws SQLException;
	
}