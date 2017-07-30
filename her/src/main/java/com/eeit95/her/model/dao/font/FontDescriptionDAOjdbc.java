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
import com.eeit95.her.model.font.FontDescriptionDAOInterface;

public class FontDescriptionDAOjdbc implements FontDescriptionDAOInterface {

	String url = "jdbc:sqlserver://localhost:1433;databaseName=her";
	String username = "sa";
	String password = "sa123456";
	private static final String INSERT = "insert into font_description (fontId,order,text,image) "
			+ "values ( ?, ?, ?, ?)";
	private static final String UPDATE = "update font_description set order=?,text=?,"
			+ "image=? where fontId = ?";
	private static final String DELETE = "delete from font_description where fontId = ? and order = ?";
	private static final String SELECT = "select * from font_description where fontId = ? and order = ?";
	private static final String SELECT_ALL = "select * from font_description";
	
	@Override
	public void insert(FontDescriptionBean fontDescriptionBean) {
		try( Connection conn = DriverManager.getConnection(url,username,password); 
				PreparedStatement stmt = conn.prepareStatement(INSERT))  {
			
			if (fontDescriptionBean != null) {
				stmt.setString(1, fontDescriptionBean.getFontId());
				stmt.setInt(2, fontDescriptionBean.getOrder());
				stmt.setString(3, fontDescriptionBean.getText());
				stmt.setBytes(4, fontDescriptionBean.getImage());
				int n = stmt.executeUpdate();
				System.out.println(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(FontDescriptionBean fontDescriptionBean) {
		try( Connection conn = DriverManager.getConnection(url,username,password); 
				PreparedStatement stmt = conn.prepareStatement(UPDATE))  {
			
			if (fontDescriptionBean != null) {
				stmt.setInt(1, fontDescriptionBean.getOrder());
				stmt.setString(2, fontDescriptionBean.getText());
				stmt.setBytes(3, fontDescriptionBean.getImage());
				stmt.setString(4, fontDescriptionBean.getFontId());
				int n = stmt.executeUpdate();
				System.out.println(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String fontId, int order) {
		try( Connection conn = DriverManager.getConnection(url,username,password); 
				PreparedStatement stmt = conn.prepareStatement(DELETE))  {
			
			if (fontId != null) {
				stmt.setString(1, fontId);
				stmt.setInt(2, order);
				int n = stmt.executeUpdate();
				System.out.println(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public FontDescriptionBean selectById(String fontId, int order) {
		FontDescriptionBean bean = null;
		ResultSet rs = null;
		try( Connection conn = DriverManager.getConnection(url,username,password); 
				PreparedStatement stmt = conn.prepareStatement(SELECT))  {
			
			if (fontId != null) {
				stmt.setString(1, fontId);
				stmt.setInt(2, order);
				rs = stmt.executeQuery();
				
				if(rs.next()){
					bean = new FontDescriptionBean();
					bean.setFontId(rs.getString("fontId"));
					bean.setOrder(rs.getInt("order"));
					bean.setText(rs.getString("text"));
					bean.setImage(rs.getBytes("image"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
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
	public List<FontDescriptionBean> selectAll() {
		List<FontDescriptionBean> list = null;
		ResultSet rs = null;
		try( Connection conn = DriverManager.getConnection(url,username,password);
			 PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL))  {
			rs = pstmt.executeQuery();
			
			list = new ArrayList<FontDescriptionBean>();
			while(rs.next()) {
				FontDescriptionBean bean = new FontDescriptionBean();
				bean.setFontId(rs.getString("fontId"));
				bean.setOrder(rs.getInt("order"));
				bean.setText(rs.getString("text"));
				bean.setImage(rs.getBytes("image"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		
		FontDescriptionDAOjdbc dao = new FontDescriptionDAOjdbc();
		
		List<FontDescriptionBean> test = null;
		test = dao.selectAll();
		for(FontDescriptionBean bean : test) {
			System.out.print(bean.getFontId()+",\t");
			System.out.print(bean.getOrder()+",\t");
			System.out.print(bean.getText()+",\t");
			System.out.print(bean.getImage() + "\n");
			
		}

	}

}
