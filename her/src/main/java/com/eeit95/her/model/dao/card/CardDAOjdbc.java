package com.eeit95.her.model.dao.card;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardDAOInterface;

public class CardDAOjdbc implements CardDAOInterface {
	private static int n = 2;
	private static String type = null;
	private static final String Select_By_ID = "select*from card where id=?";
	private static String Select_All_TopN = "SELECT TOP " + n
			+ " * FROM [card] WHERE [status] = 1 ORDER BY "	+ type + " DESC";
	private static final String Insert = "insert into card values(?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String Update = "update card set name=?,price=?,cover=?,viewCount=?,"
			+ "salesCount=?,status=?,manufacturer=?,cost=?,gpratio=?,stock=?,maxWordCount=?" + " where id=? ";
	private static final String Select_All = "select*from card";
	private static final String Delete = "delete from card where id=?";
	private static DataSource ds;
	private static Connection conn;
	private static List<CardBean> result = new ArrayList<CardBean>();

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

		CardDAOjdbc cdj = new CardDAOjdbc();
		
		// SELECT 一筆資料 & PRINT
		CardBean bean =cdj.selectById("c01706010001");
		System.out.println("SELECT 一筆資料 & PRINT");
		System.out.println(bean);
		
		System.out.println("===================================================");
		
		// INSERT 一筆資料 & PRINT
		bean.setId("c01707280001");
		bean =cdj.insert(bean);
		System.out.println("INSERT 一筆資料 & PRINT");
		System.out.println(bean);
		
		System.out.println("===================================================");
		
		// UPDATE 一筆資料 & PRINT
		bean.setName("史奴比");
		cdj.update(bean);
		System.out.println("UPDATE 一筆資料 & PRINT");
		System.out.println(bean);
		
		System.out.println("===================================================");
		
		// DELETE 一筆資料 & PRINT
		System.out.println("DELETE 一筆資料 & PRINT");
		System.out.println(cdj.delete("c01707280001"));
		
		System.out.println("===================================================");
		
		// SELECT 所有資料 & PRINT
		result=cdj.selectAll();
		System.out.println("SELECT 所有資料 & PRINT");
		for(CardBean bean1:result) {
			System.out.println(bean1);
		}
		
	}

	@Override

	public List<CardBean> selectAll(int n, String type) {
		PreparedStatement stmt;
		Select_All_TopN = "SELECT TOP " + n
				+ " * FROM [card] WHERE [status] = 1 ORDER BY "
				+ type + " DESC";
		System.out.println(Select_All_TopN);
		try {
			// conn = ds.getConnection();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			result.clear();
			stmt = conn.prepareStatement(Select_All_TopN);
			// stmt.setInt(1, n);
			// stmt.setString(1, type);
			ResultSet rset = stmt.executeQuery();
			while (rset.next()) {
				CardBean bean = new CardBean();
				bean.setId(rset.getString("id"));
				bean.setName(rset.getString("name"));
				bean.setPrice(rset.getLong("price"));
				bean.setCover(rset.getBytes("cover"));
				bean.setViewCount(rset.getInt("viewCount"));
				bean.setSalesCount(rset.getInt("salesCount"));
				bean.setStatus(rset.getBoolean("status"));
				bean.setManufacturer(rset.getString("manufacturer"));
				bean.setCost(rset.getLong("cost"));
				bean.setGpratio(rset.getLong("gpratio"));
				bean.setStock(rset.getShort("stock"));
				bean.setMaxWordCount(rset.getShort("maxWordCount"));

				result.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<CardBean> selectAll() {

		try {
			// conn = ds.getConnection();
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			PreparedStatement stmt = conn.prepareStatement(Select_All);
			ResultSet rset = stmt.executeQuery();
			result.clear();
			// System.out.println("test1");

			while (rset.next()) {
				// System.out.println("while");
				CardBean bean = new CardBean();
				bean.setId(rset.getString("id"));
				bean.setName(rset.getString("name"));
				bean.setPrice(rset.getLong("price"));
				bean.setCover(rset.getBytes("cover"));
				bean.setViewCount(rset.getInt("viewCount"));
				bean.setSalesCount(rset.getInt("salesCount"));
				bean.setStatus(rset.getBoolean("status"));
				bean.setManufacturer(rset.getString("manufacturer"));
				bean.setCost(rset.getLong("cost"));
				bean.setGpratio(rset.getLong("gpratio"));
				bean.setStock(rset.getShort("stock"));
				bean.setMaxWordCount(rset.getShort("maxWordCount"));
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public CardBean selectById(String id) {
		CardBean result = null;
		ResultSet rset = null;
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
//			conn = ds.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(Select_By_ID);
			stmt.setString(1, id);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new CardBean();
				result.setId(rset.getString("id"));
				result.setName(rset.getString("name"));
				result.setPrice(rset.getLong("price"));
				result.setCover(rset.getBytes("cover"));
				result.setViewCount(rset.getInt("viewCount"));
				result.setSalesCount(rset.getInt("salesCount"));
				result.setStatus(rset.getBoolean("status"));
				result.setManufacturer(rset.getString("manufacturer"));
				result.setCost(rset.getLong("cost"));
				result.setGpratio(rset.getLong("gpratio"));
				result.setStock(rset.getShort("stock"));
				result.setMaxWordCount(rset.getShort("maxWordCount"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public CardBean insert(CardBean bean) {
		CardBean result = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
//			conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(Insert);
			
				if (bean != null) {
					stmt.setString(1, bean.getId());
					stmt.setString(2, bean.getName());
					stmt.setLong(3, bean.getPrice());
					stmt.setBytes(4, bean.getCover());
					stmt.setInt(5, bean.getViewCount());
					stmt.setInt(6, bean.getSalesCount());
					stmt.setBoolean(7, bean.getStatus());
					stmt.setString(8, bean.getManufacturer());
					stmt.setLong(9, bean.getCost());
					stmt.setLong(10, bean.getGpratio());
					stmt.setShort(11, bean.getStock());
					stmt.setShort(12, bean.getMaxWordCount());

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
	public CardBean update(CardBean bean) {
		CardBean result = null;
		try {
//			conn = ds.getConnection();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			PreparedStatement stmt = conn.prepareStatement(Update);
			stmt.setString(1, bean.getName());
			stmt.setLong(2, bean.getPrice());
			stmt.setBytes(3, bean.getCover());
			stmt.setInt(4, bean.getViewCount());
			stmt.setInt(5, bean.getSalesCount());
			stmt.setBoolean(6, bean.getStatus());
			stmt.setString(7, bean.getManufacturer());
			stmt.setLong(8, bean.getCost());
			stmt.setLong(9, bean.getGpratio());
			stmt.setShort(10, bean.getStock());
			stmt.setShort(11, bean.getMaxWordCount());
			stmt.setString(12, bean.getId());
			
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
	public boolean delete(String id) {
		try {
//			conn = ds.getConnection();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			PreparedStatement stmt = conn.prepareStatement(Delete);

			if (id != null) {
				stmt.setString(1, id);
				int i = stmt.executeUpdate();
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
