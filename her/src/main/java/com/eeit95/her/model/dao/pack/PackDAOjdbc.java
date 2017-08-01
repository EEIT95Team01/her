package com.eeit95.her.model.dao.pack;

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

import com.eeit95.her.model.pack.PackBean;
import com.eeit95.her.model.pack.PackDAOInterface;

public class PackDAOjdbc implements PackDAOInterface {

	private static final String GET_PACKAGE_IDS = "SELECT id FROM [package] WHERE [memberId] = ? AND [status] = ?";

	private static final String SELECT_BY_ID = "SELECT * FROM [package] WHERE [id] = ?";

	private static final String INSERT = "INSERT INTO [package] VALUES(?, ?, ?, ?, ?,  ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?,  ?, ?)";

	private static final String UPDATE = "UPDATE [package] SET ";

	private static final String DELETE_BY_ID = "DELETE [package] WHERE [id] = ?";

	static Context context;
	static DataSource dataSource;
	
	

	public static void main(String[] args) {
		// selectById
		PackDAOjdbc packageDAO = new PackDAOjdbc();
		PackBean packageBean1 = packageDAO.selectById("p01703150001");
		if (packageBean1 != null) {
			System.out.println(packageBean1);
		} else {
			System.out.println("not found");
		}
		
		// insert
		packageBean1.setId("p01707270001");
		packageDAO.insert(packageBean1);
		
		// getPackageIds
		List<String> packageIds = packageDAO.getPackageIds("m01701150001", 1);
		for(String id : packageIds) {
			PackBean packageBean2 = packageDAO.selectById(id);
			System.out.println(packageBean2);
		}
		
		// deleteById
		packageDAO.deleteById("p01707270001");
		PackBean packageBean3 = packageDAO.selectById("p01707270001");
		if (packageBean3 != null) {
			System.out.println(packageBean1);
		} else {
			System.out.println("not found");
		}
		
	}

	static {
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/her");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getPackageIds(String memberId, int status) {
		Connection conn;
		List<String> packageIds = new ArrayList<String>();
		try {
			conn = dataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(GET_PACKAGE_IDS);
			pstmt.setString(1, memberId);
			pstmt.setInt(2, status);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String packageId = rs.getString("id");
				
				packageIds.add(packageId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return packageIds;
	}

	@Override
	public PackBean selectById(String id) {
		Connection conn;
		PackBean packageBean = null;
		try {
			conn = dataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				packageBean = new PackBean();
				packageBean.setId(rs.getString("id"));
				packageBean.setName(rs.getString("name"));
				packageBean.setMemberId(rs.getString("memberId"));
				packageBean.setCardId(rs.getString("cardId"));
				packageBean.setCardPrice(rs.getDouble("cardPrice"));
				packageBean.setFontId(rs.getString("fontId"));
				packageBean.setFontPrice(rs.getDouble("fontPrice"));
				packageBean.setGiftSum(rs.getDouble("giftSum"));
				packageBean.setSum(rs.getDouble("sum"));
				packageBean.setContent(rs.getString("content"));
				packageBean.setRecipientId(rs.getString("recipientId"));
				packageBean.setRecipientName(rs.getString("recipientName"));
				packageBean.setRecipientPhone(rs.getString("recipientPhone"));
				packageBean.setRecipientCity(rs.getString("recipientCity"));
				packageBean.setRecipientDistrict(rs.getString("recipientDistrict"));
				packageBean.setRecipientAddr(rs.getString("recipientAddr"));
				packageBean.setDateMailed(rs.getDate("dateMailed"));
				packageBean.setSenderName(rs.getString("senderName"));
				packageBean.setSenderPhone(rs.getString("senderPhone"));
				packageBean.setSenderCity(rs.getString("senderCity"));
				packageBean.setSenderDistrict(rs.getString("senderDistrict"));
				packageBean.setSenderAddr(rs.getString("senderAddr"));
				packageBean.setStatus(rs.getInt("status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return packageBean;
	}

	@Override
	public PackBean insert(PackBean packBean) {
		Connection conn;
		PackBean packBeanResult = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, packBean.getId());
			pstmt.setString(2, packBean.getName());
			pstmt.setString(3, packBean.getMemberId());
			pstmt.setString(4, packBean.getCardId());
			pstmt.setDouble(5, packBean.getCardPrice());
			pstmt.setString(6, packBean.getFontId());
			pstmt.setDouble(7, packBean.getFontPrice());
			pstmt.setDouble(8, packBean.getGiftSum());
			pstmt.setString(9, packBean.getContent());
			pstmt.setString(10, packBean.getRecipientId());
			pstmt.setString(11, packBean.getRecipientName());
			pstmt.setString(12, packBean.getRecipientPhone());
			pstmt.setString(13, packBean.getRecipientCity());
			pstmt.setString(14, packBean.getRecipientDistrict());
			pstmt.setString(15, packBean.getRecipientAddr());
			pstmt.setDate(16, packBean.getDateMailed());
			pstmt.setString(17, packBean.getSenderName());
			pstmt.setString(18, packBean.getSenderPhone());
			pstmt.setString(19, packBean.getSenderCity());
			pstmt.setString(20, packBean.getSenderDistrict());
			pstmt.setString(21, packBean.getSenderAddr());
			pstmt.setInt(22, packBean.getStatus());
			
			if(pstmt.executeUpdate() == 1) {
				packBeanResult = packBean;
			};
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return packBeanResult;
	}

	@Override
	public PackBean update(PackBean packageBean) {

		return null;
	}

	@Override
	public int deleteById(String id) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE_BY_ID);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
