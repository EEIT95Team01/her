package com.eeit95.her.model.dao.font;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;

import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontDAOInterface;


public class FontDAOjdbc implements FontDAOInterface {
	
	String url="jdbc:sqlserver://localhost:1433;databaseName=team01";
	private static final String INSERT = "insert into font (fontName,fontPrice,writerNo,fontCover,fontViewCount,fontSalesCount,fontStatus) "
			+ "values ( ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "update font set fontName=?,fontPrice=?,"
			+ "writerNo=?,fontCover=?,fontViewCount=?,fontSalesCount=?,fontStatus=? where fontId = ?";
	private static final String DELETE = "delete from font where fontId = ?";
	private static final String SELECT = "select * from font where fontId = ?";

	@Override
	public void insert(FontBean fontBean) {
//		Connection conn=null;
//		PreparedStatement stmt = null;
		try( Connection conn = DriverManager.getConnection(url,"sa","P@ssw0rd"); 
				PreparedStatement stmt = conn.prepareStatement(INSERT))  {
			
			if (fontBean != null) {
				stmt.setString(1, fontBean.getFontName());
				stmt.setInt(2, fontBean.getFontPrice());
				stmt.setInt(3, fontBean.getWriterNo());
				stmt.setBlob(4, fontBean.getFontCover());
				stmt.setInt(5, fontBean.getFontViewCount());
				stmt.setInt(6, fontBean.getFontSalesCount());
				stmt.setBoolean(7, fontBean.isFontStatus());
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
		try( Connection conn = DriverManager.getConnection(url,"sa","P@ssw0rd"); 
				PreparedStatement stmt = conn.prepareStatement(UPDATE))  {
			
			if (fontBean != null) {
				stmt.setString(1, fontBean.getFontName());
				stmt.setInt(2, fontBean.getFontPrice());
				stmt.setInt(3, fontBean.getWriterNo());
				stmt.setBlob(4, fontBean.getFontCover());
				stmt.setInt(5, fontBean.getFontViewCount());
				stmt.setInt(6, fontBean.getFontSalesCount());
				stmt.setBoolean(7, fontBean.isFontStatus());
				stmt.setInt(8, fontBean.getFontId());
				int n = stmt.executeUpdate();
				System.out.println(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Integer fontId) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			FontDescriptionBean fontBean = new FontDescriptionBean();
//			fontBean.setFontId(fontId);
//			session.delete(fontBean);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
		try( Connection conn = DriverManager.getConnection(url,"sa","P@ssw0rd"); 
				PreparedStatement stmt = conn.prepareStatement(DELETE))  {
			
			if (fontId != null) {
				stmt.setInt(1, fontId);
				int n = stmt.executeUpdate();
				System.out.println(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public FontBean findByPrimaryKey(Integer fontId) {
//		FontDescriptionBean fontBean = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			fontBean = (FontDescriptionBean) session.get(FontDescriptionBean.class, fontId);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			throw e;
//		}
		try( Connection conn = DriverManager.getConnection(url,"sa","P@ssw0rd"); 
				PreparedStatement stmt = conn.prepareStatement(SELECT))  {
			
			if (fontId != null) {
				stmt.setInt(1, fontId);
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()){
					FontBean bean = new FontBean();
					bean.setFontId(rs.getInt("fontId"));
					bean.setFontNo(rs.getString("fontNo"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
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
		return null;
	}

	public static void main(String[] args) {
		FontDAOjdbc dao = new FontDAOjdbc();

		FontBean fontBean = new FontBean();
		fontBean.setFontId(3);
		fontBean.setFontName("gggg");
		fontBean.setFontPrice(123);
		fontBean.setWriterNo(123);
		fontBean.setFontCover(null);
		fontBean.setFontViewCount(123456);
		fontBean.setFontSalesCount(7651);
		fontBean.setFontStatus(true);
		dao.update(fontBean);
		dao.delete(2);
	}
}
