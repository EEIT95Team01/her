package com.eeit95.her.model.gift;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiftTagDAO implements IGiftTagDAO{

	private static final String INSERT_STMT ="INSERT INTO gift_tag VALUES (?, ?)";
	private static final String UPDATE_STMT = 
			"UPDATE gift_tag SET tagId=? WHERE giftId=?";
	private static final String DELETE_STMT  = 
			"DELETE FROM gift_tag WHERE giftId=? and tagId=?";
	private static final String GET_ONE_STMT = 
			"SELECT giftId, tagId FROM gift_tag WHERE giftId=? and tagId=?"; 
	private static final String GET_ALL_STMT = 
			"SELECT giftId, tagId FROM gift_tag ORDER BY giftId";

	Connection conn = null;
	
	@Override
	public void getConnection() throws SQLException {
		String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=Her";
		conn = DriverManager.getConnection(connUrl, "sa", "sa123456");		
	}

	@Override
	public int insert(GiftTagBean gifTag) throws SQLException {
		int updateCount = 0;
		PreparedStatement pstmt = conn.prepareStatement(INSERT_STMT);
		pstmt.setString(1, gifTag.getGiftId());
		pstmt.setInt(2, gifTag.getTagId());
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public int update(GiftTagBean gifTag) throws SQLException {
		int updateCount = 0;
		PreparedStatement pstmt = conn.prepareStatement(UPDATE_STMT);
		pstmt.setInt(1, gifTag.getTagId());
		pstmt.setString(2, gifTag.getGiftId());
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public int delete(String giftId, int tagId) throws SQLException {
		int updateCount = 0;
		PreparedStatement pstmt = conn.prepareStatement(DELETE_STMT);
		pstmt.setString(1, giftId);
		pstmt.setInt(2, tagId);
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public GiftTagBean findByPrimaryKey(String giftId, int tagId) throws SQLException {
		GiftTagBean giftTag = null;
		PreparedStatement pstmt = conn.prepareStatement(GET_ONE_STMT);
		pstmt.setString(1,giftId);
		pstmt.setInt(2,tagId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			giftTag = new GiftTagBean();
			giftTag.setGiftId(rs.getString("giftId"));
			giftTag.setTagId(rs.getInt("tagId"));
		}
		return giftTag;
	}

	@Override
	public List<GiftTagBean> getAll() throws SQLException {
		GiftTagBean giftTag = null;
		List<GiftTagBean> giftTags = new ArrayList<GiftTagBean>();
		PreparedStatement pstmt = conn.prepareStatement(GET_ALL_STMT);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			giftTag = new GiftTagBean();
			giftTag.setGiftId(rs.getString("giftId"));
			giftTag.setTagId(rs.getInt("tagId"));
			giftTags.add(giftTag);
		}
		return giftTags;
	}

	@Override
	public void closeConn() throws SQLException {
		if (conn != null)
			conn.close();
	}
}