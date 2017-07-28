package com.eeit95.her.model.category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO{
	private static final String INSERT_STMT = "INSERT INTO category VALUES (?, ?)";
	private static final String UPDATE_STMT = "UPDATE category SET subName=? WHERE mainId=?";
	private static final String DELETE_STMT  = "DELETE FROM category WHERE mainId=?";
	private static final String GET_ONE_STMT = "SELECT mainId, id, subName FROM category WHERE id=?"; 
	private static final String GET_ALL_STMT = "SELECT mainId, id, subName FROM category ORDER BY mainId";
	
	Connection conn = null;
		
	@Override
	public void getConnection() throws SQLException {
		String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=Her";
		conn = DriverManager.getConnection(connUrl, "sa", "sa123456");
	}

	@Override
	public int insert(CategoryBean category) throws SQLException {
		int updateCount = 0;
		PreparedStatement pstmt = conn.prepareStatement(INSERT_STMT);
		pstmt.setInt(1, category.getMainId());
		pstmt.setString(2,category.getSubName() );
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public int update(CategoryBean category) throws SQLException {
		int updateCount = 0;
		PreparedStatement pstmt = conn.prepareStatement(UPDATE_STMT);
		pstmt.setString(1, category.getSubName());
		pstmt.setInt(2, category.getMainId());
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public int delete(int mainId) throws SQLException {
		int updateCount = 0;
		PreparedStatement pstmt = conn.prepareStatement(DELETE_STMT);
		pstmt.setInt(1, mainId);
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}
	@Override
	public CategoryBean findByPrimaryKey(int id) throws SQLException {
		CategoryBean category = null;
		PreparedStatement pstmt = conn.prepareStatement(GET_ONE_STMT);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			category = new CategoryBean();
			category.setMainId(rs.getInt("mainId"));
			category.setId(rs.getInt("id"));
			category.setSubName(rs.getString("subName"));
		}
		return category;
	}

	@Override
	public List<CategoryBean> getAll() throws SQLException {
		CategoryBean category = null;
		List<CategoryBean> categorys = new ArrayList<CategoryBean>();
		PreparedStatement pstmt = conn.prepareStatement(GET_ALL_STMT);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			category = new CategoryBean();
			category.setMainId(rs.getInt("mainId"));
			category.setId(rs.getInt("id"));
			category.setSubName(rs.getString("subName"));
			categorys.add(category);
		}
		return categorys;
	}

	@Override
	public void closeConn() throws SQLException {
		if (conn != null)
			conn.close();
	}

}