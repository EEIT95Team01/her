package com.eeit95.her.model.dao.card;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardDescriptionBean;
import com.eeit95.her.model.card.CardTagBean;
import com.eeit95.her.model.card.CardTagInterface;
import com.eeit95.her.model.tag.TagBean;

public class CardTagDAOjdbc implements CardTagInterface {
	private static final String selectBycardId = "select * from [card_tag] where [cardId] = ?";
	private static final String selectBytagId = "select * from [card_tag] where [tagId] = ?";
	private static final String insert = "insert into [card_tag] values(?,?)";
	private static final String deleteBycardId = "delete from [card_tag] where [cardId] = ?";
	private static final String deleteBytagId = "delete from [card_tag] where [tagId] = ?";
	private static final String delete="delete from [card_tag] where [cardId] = ? AND [tagId] = ?";
	private static final String selectAll = "select * from [card_tag]";
	private static DataSource ds;
	private static Connection conn;
	private static List<CardTagBean> result = new ArrayList<CardTagBean>();
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
		CardTagDAOjdbc cto= new CardTagDAOjdbc();
		//select cardId & print
//		System.out.println("select cardId & print");
//		List<CardTagBean> beans  = cto.selectBycardId("c01707280003");
//		for (CardTagBean bean:beans) {
//			System.out.println(bean);
//		}
//		System.out.println("========================================");
//		//select tagId & print
//		System.out.println("select tagId & print");
//		List<CardTagBean> beans1  = cto.selectBytagId((short) 9);
//		for (CardTagBean bean:beans1) {
//			System.out.println(bean);
//		}
//		
//		System.out.println("========================================");
//		//insert & print
//		System.out.println("insert & print");
//		for (CardTagBean bean:beans1) {
//			bean.setTagId((short)10);
//		}
//		cto.insert(beans1);
//		System.out.println("select tagId & print");
//		List<CardTagBean> beans2  = cto.selectBytagId((short) 10);
//		for (CardTagBean bean:beans2) {
//			System.out.println(bean);
//		}
//		System.out.println("========================================");
//		System.out.println(cto.delete("c01707280002",(short) 10));
//		beans  = cto.selectAll();
//		for (CardTagBean bean:beans) {
//			System.out.println(bean);
//		}
		System.out.println("========================================");
		System.out.println(cto.deleteBycardId("c01707280002"));
		List<CardTagBean> beans  = cto.selectAll();
		for (CardTagBean bean:beans) {
			System.out.println(bean);
		}
//		System.out.println("========================================");
//		System.out.println(cto.deleteBytagId((short) 9));
//		beans  = cto.selectAll();
//		for (CardTagBean bean:beans) {
//			System.out.println(bean);
//		}
	}

	@Override
	public List<CardTagBean> selectBycardId(String cardId) {
		result.clear();
		CardTagBean bean = null;
		ResultSet rset = null;
		// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			// conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(selectBycardId);
			stmt.setString(1, cardId);
			rset = stmt.executeQuery();
			while (rset.next()) {
				bean = new CardTagBean();
				bean.setCardId(rset.getString("cardId"));
				bean.setTagId(rset.getShort("tagId"));
				result.add(bean);
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
	public List<CardTagBean> selectBytagId(short tagId) {
		result.clear();
		CardTagBean bean = null;
		ResultSet rset = null;
		// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			// conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(selectBytagId);
			stmt.setShort(1, tagId);
			rset = stmt.executeQuery();
			while (rset.next()) {
				bean = new CardTagBean();
				bean.setCardId(rset.getString("cardId"));
				bean.setTagId(rset.getShort("tagId"));
				result.add(bean);
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
	public List<CardTagBean> insert(List<CardTagBean> beans) {
		try {
			// conn = ds.getConnection();

			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			PreparedStatement stmt = conn.prepareStatement(insert);
			for (CardTagBean bean : beans) {
				stmt.setString(1, bean.getCardId());
				stmt.setShort(2, bean.getTagId());
				stmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

	@Override
	public boolean deleteBycardId(String cardId) {
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			PreparedStatement stmt = conn.prepareStatement(deleteBycardId);
			stmt.setString(1, cardId);
			int i = stmt.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBytagId(short tagId) {
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			PreparedStatement stmt = conn.prepareStatement(deleteBytagId);

			stmt.setShort(1, tagId);
			int i = stmt.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(String cardId, short tagId) {
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			PreparedStatement stmt = conn.prepareStatement(delete);
			stmt.setString(1, cardId);
			stmt.setShort(2, tagId);
			int i = stmt.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<CardTagBean> selectAll() {
		result.clear();
		CardTagBean bean = null;
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
				bean = new CardTagBean();
				bean.setCardId(rset.getString("cardId"));
				bean.setTagId(rset.getShort("tagId"));
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
