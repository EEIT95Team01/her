package com.eeit95.her.model.tag.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.tag.TagBean;


public class TagDAOjdbc implements TagDAOinterface {

	private static final String selectById = "select * from [tag] where [id] = ?";
	private static final String selectAll = "select * from [tag]";
	private static final String Insert = "insert into [tag] values(?,?)";
	private static final String Update = "update [tag] set name=?,discount=? where id=? ";
	private static final String Delete = "delete from [tag] where [id] = ?";
	private static DataSource ds;
	private static Connection conn;

	// static{
	//
	// try {
	// Context context = new InitialContext();
	// ds= (DataSource)context.lookup("java:comp/env/jdbc/her");
	// result = new ArrayList<CardBean>();
	// } catch (NamingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }

	public static void main(String[] args) {
		TagDAOjdbc tdj = new TagDAOjdbc();
		TagBean bean= tdj.selectById((short)1);
		bean.setId((short)9);
		System.out.println("SELECT 一筆資料 & PRINT");
		System.out.println(bean);
		
		System.out.println("===================================================");
		
		// INSERT 一筆資料 & PRINT
		bean =tdj.insert(bean);
		System.out.println("INSERT 一筆資料 & PRINT");
		System.out.println(bean);
		
		System.out.println("===================================================");
		
		// UPDATE 一筆資料 & PRINT
		bean.setName("史奴比");
		tdj.update(bean);
		System.out.println("UPDATE 一筆資料 & PRINT");
		System.out.println(bean);
		
		System.out.println("===================================================");
		
		// DELETE 一筆資料 & PRINT
//		System.out.println("DELETE 一筆資料 & PRINT");
		System.out.println(tdj.delete((short)8));
		System.out.println(tdj.delete((short)9));
		System.out.println(tdj.delete((short)10));
		
		System.out.println("===================================================");
		
		// SELECT 所有資料 & PRINT
		List<TagBean> result=tdj.selectAll();
		System.out.println("SELECT 所有資料 & PRINT");
		for(TagBean bean1:result) {
			System.out.println(bean1);
		}
		
		
		
	}
	@Override
	public TagBean selectById(short id) {
		TagBean result = null;
		ResultSet rset = null;
		// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			// conn = ds.getConnection();
			PreparedStatement stmt= conn.prepareStatement(selectById);
			stmt.setShort(1, id);
			rset=stmt.executeQuery();
			if(rset.next()) {
				result = new TagBean();
				result.setId(rset.getShort("id"));
				result.setName(rset.getString("name"));
				result.setDiscount(rset.getLong("discount"));
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	@Override
	public TagBean insert(TagBean bean) {
		TagBean result = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
//			conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(Insert);
			
				if (bean != null) {
					
					stmt.setString(1, bean.getName());
					stmt.setLong(2, bean.getDiscount());
					

					int i = stmt.executeUpdate();
					if (i == 1) {
						result = bean;
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public TagBean update(TagBean bean) {
		TagBean result = null;
		try {
//			conn = ds.getConnection();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			PreparedStatement stmt = conn.prepareStatement(Update);
			stmt.setString(1, bean.getName());
			stmt.setLong(2, bean.getDiscount());
			stmt.setShort(3, bean.getId());
			
			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.selectById(bean.getId());
			} else {
				System.out.println("Not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean delete(short id) {
		try {
//			conn = ds.getConnection();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			PreparedStatement stmt = conn.prepareStatement(Delete);
			stmt.setShort(1, id);
			int i = stmt.executeUpdate();
			if (i == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<TagBean> selectAll() {
		List<TagBean> result = new ArrayList<TagBean>();
		TagBean bean = null;
		ResultSet rset = null;
		try {
			// conn = ds.getConnection();
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			PreparedStatement stmt = conn.prepareStatement(selectAll);
			rset = stmt.executeQuery();
			
			// System.out.println("test1");

			while (rset.next()) {
				// System.out.println("while");
				bean = new TagBean();
				bean.setId(rset.getShort("id"));
				bean.setName(rset.getString("name"));
				bean.setDiscount(rset.getLong("discount"));
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	

}
