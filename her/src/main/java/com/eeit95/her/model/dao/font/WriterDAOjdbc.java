package com.eeit95.her.model.dao.font;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.WriterBean;
import com.eeit95.her.model.font.WriterDAOInterface;

public class WriterDAOjdbc implements WriterDAOInterface {

	String url="jdbc:sqlserver://localhost:1433;databaseName=her";
	String username = "sa";
	String password = "sa123456";
	private static final String INSERT = "insert into writer (id,name,cover,description) "
			+ "values ( ?, ?, ?, ?)";
	private static final String UPDATE = "update writer set name=?,"
			+ "cover=?,description=? where id = ?";
	private static final String DELETE = "delete from writer where id = ?";
	private static final String SELECT = "select * from writer where id = ?";
	private static final String SELECT_ALL = "select * from writer";
	
	@Override
	public void insert(WriterBean writerBean) {
		try( Connection conn = DriverManager.getConnection(url,username,password); 
				PreparedStatement stmt = conn.prepareStatement(INSERT))  {
			
			if (writerBean != null) {
				stmt.setInt(1, writerBean.getId());
				stmt.setString(2, writerBean.getName());
				stmt.setBytes(3, writerBean.getCover());
				stmt.setString(4, writerBean.getDescription());
				int n = stmt.executeUpdate();
				System.out.println(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(WriterBean writerBean) {
		try( Connection conn = DriverManager.getConnection(url,username,password); 
				PreparedStatement stmt = conn.prepareStatement(UPDATE))  {
			
			if (writerBean != null) {
				stmt.setString(1, writerBean.getName());
				stmt.setBytes(2, writerBean.getCover());
				stmt.setString(3, writerBean.getDescription());
				stmt.setInt(4, writerBean.getId());
				int n = stmt.executeUpdate();
				System.out.println(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		try( Connection conn = DriverManager.getConnection(url,username,password); 
				PreparedStatement stmt = conn.prepareStatement(DELETE))  {
			
				stmt.setInt(1, id);
				int n = stmt.executeUpdate();
				System.out.println(n);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public WriterBean selectById(int id) {
		WriterBean bean = null;
		ResultSet rs = null;
		try( Connection conn = DriverManager.getConnection(url,username,password); 
				PreparedStatement stmt = conn.prepareStatement(SELECT))  {
				stmt.setInt(1, id);
				rs = stmt.executeQuery();
				
				if(rs.next()){
					bean = new WriterBean();
					bean.setId(rs.getInt("id"));
					bean.setName(rs.getString("name"));
					bean.setCover(rs.getBytes("cover"));
					bean.setDescription(rs.getString("description"));

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
	public List<WriterBean> selectAll() {
		List<WriterBean> list = null;
		ResultSet rs = null;
		try( Connection conn = DriverManager.getConnection(url,username,password);
			 PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL))  {
			rs = pstmt.executeQuery();
			
			list = new ArrayList<WriterBean>();
			while(rs.next()) {
				WriterBean bean = new WriterBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setCover(rs.getBytes("cover"));
				bean.setDescription(rs.getString("description"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		WriterDAOjdbc dao = new WriterDAOjdbc();
		
		List<WriterBean> test = null;
		test = dao.selectAll();
		for(WriterBean bean : test) {
			System.out.print(bean.getId()+",\t");
			System.out.print(bean.getName()+",\t");
			System.out.print(bean.getCover()+",\t");
			System.out.print(bean.getDescription() + "\n");
			
		}
	}

}
