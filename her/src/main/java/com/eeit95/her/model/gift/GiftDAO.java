package com.eeit95.her.model.gift;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.eeit95.her.model.gift.GiftDAO;

public class GiftDAO implements IGiftDAO {
	private static final String INSERT_STMT = 
			"INSERT INTO gift VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = 
			"UPDATE gift SET name=?, price=?, cover=?, viewCount=?, salesCount=?, status=?, "
			+ "manufacturer=?, cost=?, gpratio=?, stock=?, categoryId=? WHERE id=?";
	private static final String DELETE_STMT  = 
			"DELETE FROM gift WHERE id=?";
	private static final String GET_ONE_STMT = 
			"SELECT id, name, price, cover, viewCount, salesCount, status, "
			+ "manufacturer, cost, gpratio, stock, categoryId FROM gift WHERE id=?"; 
	private static final String GET_ALL_STMT = 
			"SELECT id, name, price, cover, viewCount, salesCount, status, "
			+ "manufacturer, cost, gpratio, stock, categoryId FROM gift ORDER BY id";

	Connection conn = null;
	
	@Override
	public void getConnection() throws SQLException {
		String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=Her";
		conn = DriverManager.getConnection(connUrl, "sa", "sa123456");
	}

	@Override
	public int insert(GiftBean gift) throws SQLException {
		int updateCount = 0;
		PreparedStatement pstmt = conn.prepareStatement(INSERT_STMT);
		pstmt.setString(1, gift.getId());
		pstmt.setString(2, gift.getName());
		pstmt.setFloat(3,gift.getPrice());
		pstmt.setBytes(4, gift.getCover());
		pstmt.setInt(5, gift.getViewCount());
		pstmt.setInt(6, gift.getSalesCount());
		pstmt.setBoolean(7, gift.isStatus());
		pstmt.setString(8, gift.getManufacturer());
		pstmt.setFloat(9, gift.getCost());
		pstmt.setFloat(10, gift.getGpratio());
		pstmt.setInt(11, gift.getStock());
		pstmt.setInt(12, gift.getCategoryId());
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public int update(GiftBean gift) throws SQLException {
		int updateCount = 0;
		PreparedStatement pstmt = conn.prepareStatement(UPDATE_STMT);
		pstmt.setString(1, gift.getName());
		pstmt.setFloat(2,gift.getPrice());
		pstmt.setBytes(3, gift.getCover());
		pstmt.setInt(4, gift.getViewCount());;
		pstmt.setInt(5, gift.getSalesCount());
		pstmt.setBoolean(6, gift.isStatus());
		pstmt.setString(7, gift.getManufacturer());
		pstmt.setFloat(8, gift.getCost());
		pstmt.setFloat(9, gift.getGpratio());
		pstmt.setInt(10, gift.getStock());
		pstmt.setInt(11, gift.getCategoryId());
		pstmt.setString(12, gift.getId());
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public int delete(String id) throws SQLException {
		int updateCount = 0;
		PreparedStatement pstmt = conn.prepareStatement(DELETE_STMT);
		pstmt.setString(1, id);
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public GiftBean findByPrimaryKey(String id) throws SQLException {
		GiftBean gift = null;
		PreparedStatement pstmt = conn.prepareStatement(GET_ONE_STMT);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			gift = new GiftBean();
			gift.setId(rs.getString("id"));
			gift.setName(rs.getString("name"));
			gift.setPrice(rs.getFloat("price"));
			gift.setCover(rs.getBytes("cover"));
			gift.setViewCount(rs.getInt("viewCount"));
			gift.setSalesCount(rs.getInt("salesCount"));
			gift.setStatus(rs.getBoolean("status"));
			gift.setManufacturer(rs.getString("manufacturer"));
			gift.setCost(rs.getFloat("cost"));
			gift.setGpratio(rs.getFloat("gpratio"));
			gift.setStock(rs.getInt("stock"));
			gift.setCategoryId(rs.getInt("categoryId"));
		}
		return gift;
	}

	@Override
	public List<GiftBean> getAll() throws SQLException {
		GiftBean gift = null;
		List<GiftBean> gifts = new ArrayList<GiftBean>();
		PreparedStatement pstmt = conn.prepareStatement(GET_ALL_STMT);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			gift = new GiftBean();
			gift.setId(rs.getString("id"));
			gift.setName(rs.getString("name"));
			gift.setPrice(rs.getFloat("price"));
			gift.setCover(rs.getBytes("cover"));
			gift.setViewCount(rs.getInt("viewCount"));
			gift.setSalesCount(rs.getInt("salesCount"));
			gift.setStatus(rs.getBoolean("status"));
			gift.setManufacturer(rs.getString("manufacturer"));
			gift.setCost(rs.getFloat("cost"));
			gift.setGpratio(rs.getFloat("gpratio"));
			gift.setStock(rs.getInt("stock"));
			gift.setCategoryId(rs.getInt("categoryId"));
			gifts.add(gift);
		}
		return gifts;
	}

	@Override
	public void closeConn() throws SQLException {
		if (conn != null)
			conn.close();		
	}
}