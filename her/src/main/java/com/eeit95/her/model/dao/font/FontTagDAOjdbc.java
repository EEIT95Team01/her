package com.eeit95.her.model.dao.font;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontDescriptionBean;
import com.eeit95.her.model.font.FontTagBean;
import com.eeit95.her.model.font.FontTagDAOInterface;

public class FontTagDAOjdbc implements FontTagDAOInterface {

	String url = "jdbc:sqlserver://localhost:1433;databaseName=her";
	String username = "sa";
	String password = "sa123456";
	private static final String INSERT = "insert into font_tag (fontId,tagId) values ( ?, ?)";
	private static final String UPDATE = "update font_tag set tagId=? where fontId = ?";
	private static final String DELETE = "delete from font_tag where fontId = ? and tagId = ?";
	private static final String SELECT = "select * from font_tag where fontId = ? and tagId = ?";
	private static final String SELECT_ALL = "select * from font_tag";

	@Override
	public void insert(FontTagBean fontTagBean) {
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement stmt = conn.prepareStatement(INSERT)) {

			if (fontTagBean != null) {
				stmt.setString(1, fontTagBean.getFontId());
				stmt.setInt(2, fontTagBean.getTagId());
				int n = stmt.executeUpdate();
				System.out.println(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(FontTagBean fontTagBean) {
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement stmt = conn.prepareStatement(UPDATE)) {

			if (fontTagBean != null) {
				stmt.setInt(1, fontTagBean.getTagId());
				stmt.setString(2, fontTagBean.getFontId());
				int n = stmt.executeUpdate();
				System.out.println(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String fontId, int tagId) {
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement stmt = conn.prepareStatement(DELETE)) {

			if (fontId != null) {
				stmt.setString(1, fontId);
				stmt.setInt(2, tagId);
				int n = stmt.executeUpdate();
				System.out.println(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public FontTagBean selectById(String fontId, int tagId) {
		FontTagBean bean = null;
		ResultSet rs = null;
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement stmt = conn.prepareStatement(SELECT)) {

			if (fontId != null) {
				stmt.setString(1, fontId);
				stmt.setInt(2, tagId);
				rs = stmt.executeQuery();

				if (rs.next()) {
					bean = new FontTagBean();
					bean.setFontId(rs.getString("fontId"));
					bean.setTagId(rs.getInt("tagId"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return bean;
	}

	@Override
	public List<FontTagBean> selectAll() {
		List<FontTagBean> list = null;
		ResultSet rs = null;
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL)) {
			rs = pstmt.executeQuery();

			list = new ArrayList<FontTagBean>();
			while (rs.next()) {
				FontTagBean bean = new FontTagBean();
				bean.setFontId(rs.getString("fontId"));
				bean.setTagId(rs.getInt("tagId"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		FontTagDAOjdbc dao = new FontTagDAOjdbc();

		List<FontTagBean> test = null;
		test = dao.selectAll();
		for (FontTagBean bean : test) {
			System.out.print(bean.getFontId() + ",\t");
			System.out.print(bean.getTagId() + "\n");
		}
	}

}
