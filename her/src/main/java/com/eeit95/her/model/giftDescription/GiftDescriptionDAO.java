package com.eeit95.her.model.giftDescription;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiftDescriptionDAO implements IGiftDescriptionDAO{
	private static final String INSERT_STMT ="INSERT INTO gift_description VALUES (?, ?, ?, ?)";
	private static final String UPDATE_STMT = 
			"UPDATE gift_description SET text=?, image=? WHERE giftId=? and g_order=?";
	private static final String DELETE_STMT  = 
			"DELETE FROM gift_description WHERE giftId=? and g_order=?";
	private static final String GET_ONE_STMT = 
			"SELECT giftId, g_order, text, image FROM gift_description WHERE giftId=? and g_order=?"; 
	private static final String GET_ALL_STMT = 
			"SELECT giftId, g_order, text, image FROM gift_description ORDER BY giftId";

	Connection conn = null;
	
	@Override
	public void getConnection() throws SQLException {
		String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=Her";
		conn = DriverManager.getConnection(connUrl, "sa", "sa123456");		
	}

	@Override
	public int insert(GiftDescriptionBean giftDesc) throws SQLException {
		int updateCount = 0;
		PreparedStatement pstmt = conn.prepareStatement(INSERT_STMT);
		pstmt.setString(1, giftDesc.getGiftId());
		pstmt.setInt(2, giftDesc.getG_order());
		pstmt.setString(3,giftDesc.getText());
		pstmt.setBytes(4, giftDesc.getImage());
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public int update(GiftDescriptionBean giftDesc) throws SQLException {
		int updateCount = 0;
		PreparedStatement pstmt = conn.prepareStatement(UPDATE_STMT);
		pstmt.setString(3, giftDesc.getGiftId());
		pstmt.setInt(4, giftDesc.getG_order());
		pstmt.setString(1,giftDesc.getText());
		pstmt.setBytes(2, giftDesc.getImage());
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public int delete(String giftId, int g_order) throws SQLException {
		int updateCount = 0;
		PreparedStatement pstmt = conn.prepareStatement(DELETE_STMT);
		pstmt.setString(1,giftId);
		pstmt.setInt(2,g_order);
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public GiftDescriptionBean findByPrimaryKey(String giftId, int g_order) throws SQLException {
		GiftDescriptionBean giftDesc = null;
		PreparedStatement pstmt = conn.prepareStatement(GET_ONE_STMT);
		pstmt.setString(1,giftId);
		pstmt.setInt(2,g_order);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			giftDesc = new GiftDescriptionBean();
			giftDesc.setGiftId(rs.getString("giftId"));
			giftDesc.setG_order(rs.getInt("g_order"));
			giftDesc.setText(rs.getString("text"));
			giftDesc.setImage(rs.getBytes("image"));
		}
		return giftDesc;
	}

	@Override
	public List<GiftDescriptionBean> getAll() throws SQLException {
		GiftDescriptionBean giftDesc = null;
		List<GiftDescriptionBean> giftDescs = new ArrayList<GiftDescriptionBean>();
		PreparedStatement pstmt = conn.prepareStatement(GET_ALL_STMT);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			giftDesc = new GiftDescriptionBean();
			giftDesc.setGiftId(rs.getString("giftId"));
			giftDesc.setG_order(rs.getInt("g_order"));
			giftDesc.setText(rs.getString("text"));
			giftDesc.setImage(rs.getBytes("image"));
			giftDescs.add(giftDesc);
		}
		return giftDescs;
	}

	@Override
	public void closeConn() throws SQLException {
		if (conn != null)
			conn.close();
	}
}