package com.eeit95.her.model.dao.font;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;

import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontDAOInterface;
import com.eeit95.her.model.img.dao.ImageBlob;


public class FontDAOjdbc implements FontDAOInterface {
	
	String url="jdbc:sqlserver://localhost:1433;databaseName=her";
	private static final String INSERT = "insert into font (id,name,price,writerId,cover,viewCount,salesCount,status) "
			+ "values ( ?,?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "update font set name=?,price=?,"
			+ "writerId=?,cover=?,viewCount=?,salesCount=?,status=? where id = ?";
	private static final String DELETE = "delete from font where id = ?";
	private static final String SELECT = "select * from font where id = ?";
	private static final String SELECT_ALL = "select * from font";

	@Override
	public void insert(FontBean fontBean) {
//		Connection conn=null;
//		PreparedStatement stmt = null;
		try( Connection conn = DriverManager.getConnection(url,"sa","sa123456"); 
				PreparedStatement stmt = conn.prepareStatement(INSERT))  {
			
			if (fontBean != null) {
				stmt.setString(1, fontBean.getId());
				stmt.setString(2, fontBean.getName());
				stmt.setInt(3, fontBean.getPrice());
				stmt.setInt(4, fontBean.getWriterId());
				stmt.setBlob(5, fontBean.getCover());
				stmt.setInt(6, fontBean.getViewCount());
				stmt.setInt(7, fontBean.getSalesCount());
				stmt.setBoolean(8, fontBean.isStatus());
				int n = stmt.executeUpdate();
				System.out.println(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(FontBean fontBean) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			session.saveOrUpdate(fontBean);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
		try( Connection conn = DriverManager.getConnection(url,"sa","sa123456"); 
				PreparedStatement stmt = conn.prepareStatement(UPDATE))  {
			
			if (fontBean != null) {
				stmt.setString(1, fontBean.getName());
				stmt.setInt(2, fontBean.getPrice());
				stmt.setInt(3, fontBean.getWriterId());
				stmt.setBlob(4, fontBean.getCover());
				stmt.setInt(5, fontBean.getViewCount());
				stmt.setInt(6, fontBean.getSalesCount());
				stmt.setBoolean(7, fontBean.isStatus());
				stmt.setString(8, fontBean.getId());
				int n = stmt.executeUpdate();
				System.out.println(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String id) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			FontDescriptionBean fontBean = new FontDescriptionBean();
//			fontBean.setid(id);
//			session.delete(fontBean);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
		try( Connection conn = DriverManager.getConnection(url,"sa","sa123456"); 
				PreparedStatement stmt = conn.prepareStatement(DELETE))  {
			
			if (id != null) {
				stmt.setString(1, id);
				int n = stmt.executeUpdate();
				System.out.println(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public FontBean findByPrimaryKey(String id) {
//		FontDescriptionBean fontBean = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			fontBean = (FontDescriptionBean) session.get(FontDescriptionBean.class, id);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			throw e;
//		}
		FontBean bean = null;
		ResultSet rs = null;
		try( Connection conn = DriverManager.getConnection(url,"sa","sa123456"); 
				PreparedStatement stmt = conn.prepareStatement(SELECT))  {
			
			if (id != null) {
				stmt.setString(1, id);
				rs = stmt.executeQuery();
				
				if(rs.next()){
					bean = new FontBean();
					bean.setId(rs.getString("id"));
					bean.setName(rs.getString("name"));
					bean.setPrice(rs.getInt("price"));
					bean.setWriterId(rs.getInt("writerId"));
					bean.setCover(rs.getBlob("cover"));
					bean.setViewCount(rs.getInt("viewCount"));
					bean.setSalesCount(rs.getInt("salesCount"));
					bean.setStatus(rs.getBoolean("status"));
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
	public List<FontBean> getAll() {
//		List<FontDescriptionBean> list = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			Query query = session.createQuery(GET_ALL_STMT);
//			list = query.list();
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
		List<FontBean> list = null;
		ResultSet rs = null;
		try( Connection conn = DriverManager.getConnection(url,"sa","sa123456");
			 PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL))  {
			rs = pstmt.executeQuery();
			
			list = new ArrayList<FontBean>();
			while(rs.next()) {
				FontBean bean = new FontBean();
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPrice(rs.getInt("price"));
				bean.setWriterId(rs.getInt("writerId"));
				bean.setCover(rs.getBlob("cover"));
				bean.setViewCount(rs.getInt("viewCount"));
				bean.setSalesCount(rs.getInt("salesCount"));
				bean.setStatus(rs.getBoolean("status"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		FontDAOjdbc dao = new FontDAOjdbc();

		FontBean fontBean = new FontBean();
		fontBean.setId("3");
		fontBean.setName("AAAA");
		fontBean.setPrice(123);
		fontBean.setWriterId(123);
		fontBean.setCover(ImageBlob.imgIn("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg"));
		fontBean.setViewCount(123456);
		fontBean.setSalesCount(7651);
		fontBean.setStatus(true);
		dao.update(fontBean);
//		dao.delete(2);
		List<FontBean> test = null;
		test = dao.getAll();
		for(FontBean bean : test) {
			System.out.print(bean.getId()+",\t");
			System.out.print(bean.getName()+",\t");
			System.out.print(bean.getPrice()+",\t");
			System.out.print(bean.getWriterId()+",\t");
			System.out.print(bean.getCover()+",\t");
			System.out.print(bean.getViewCount()+",\t");
			System.out.print(bean.getSalesCount()+",\t");
			System.out.print(bean.isStatus() + "\n");
			
		}
		
	}
}
