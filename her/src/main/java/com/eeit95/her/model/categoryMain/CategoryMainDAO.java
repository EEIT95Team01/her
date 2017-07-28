package com.eeit95.her.model.categoryMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryMainDAO  implements ICategoryMainDAO{
	private static final String INSERT_STMT  = "INSERT INTO category_main VALUES (?)";
	private static final String UPDATE_STMT  = "UPDATE category_main SET name=? WHERE id=?";
	private static final String DELETE_STMT  = "DELETE FROM category_main WHERE id=?";
	private static final String GET_ONE_STMT = "SELECT id, name FROM category_main WHERE id=?";
	private static final String GET_ALL_STMT = "SELECT id, name FROM category_main ORDER BY id";

	Connection conn = null;

	@Override
	public void getConnection() throws SQLException {
		String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=Her";
		conn = DriverManager.getConnection(connUrl, "sa", "sa123456");
	}

	@Override
	public int insert(CategoryMainBean category_Main) throws SQLException {
		int updateCount = 0;
		PreparedStatement pstmt = conn.prepareStatement(INSERT_STMT);
		pstmt.setString(1, category_Main.getName());
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public int update(CategoryMainBean category_Main) throws SQLException {
		int updateCount = 0;
		PreparedStatement pstmt = conn.prepareStatement(UPDATE_STMT);
		pstmt.setString(1, category_Main.getName());
		pstmt.setInt(2, category_Main.getId());
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public int delete(int id) throws SQLException {
		int updateCount = 0;
		PreparedStatement pstmt = conn.prepareStatement(DELETE_STMT);
		pstmt.setInt(1, id);
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public CategoryMainBean findByPrimaryKey(int id) throws SQLException {
		CategoryMainBean category_Main = null;
		PreparedStatement pstmt = conn.prepareStatement(GET_ONE_STMT);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			category_Main = new CategoryMainBean();
			category_Main.setId(rs.getInt("id"));
			category_Main.setName(rs.getString("name"));
		}
		return category_Main;
	}

	@Override
	public List<CategoryMainBean> getAll() throws SQLException {
		CategoryMainBean category_Main = null;
		List<CategoryMainBean> category_Mains = new ArrayList<CategoryMainBean>();
		PreparedStatement pstmt = conn.prepareStatement(GET_ALL_STMT);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			category_Main = new CategoryMainBean();
			category_Main.setId(rs.getShort("id"));
			category_Main.setName(rs.getString("name"));
			category_Mains.add(category_Main);
		}
		return category_Mains;
	}

	@Override
	public void closeConn() throws SQLException {
		if (conn != null)
			conn.close();
	}

}