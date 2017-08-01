package com.eeit95.her.model.gift;

import java.sql.SQLException;
import java.util.List;

public interface IGiftTagDAO {

	public void getConnection() throws SQLException;
	public int insert(GiftTagBean gifTag) throws SQLException;
	public int update(GiftTagBean gifTag) throws SQLException;
	public int delete(String giftId, int tagId) throws SQLException;
	public GiftTagBean findByPrimaryKey(String giftId, int tagId) throws SQLException;
	public List<GiftTagBean> getAll() throws SQLException;
	public void closeConn() throws SQLException;
	
}