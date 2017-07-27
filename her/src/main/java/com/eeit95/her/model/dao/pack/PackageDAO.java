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

import com.eeit95.her.model.pack.PackageBean;
import com.eeit95.her.model.pack.PackageDAOInterface;

public class PackageDAO implements PackageDAOInterface {

	private static final String GET_PACKAGE_IDS = "SELECT id FROM [package] WHERE [memberId] = ? AND [status] = ?";

	private static final String SELECT_BY_ID = "SELECT * FROM [package] WHERE [id] = ?";

	private static final String INSERT = "INSERT INTO [package] VALUES(?, ?, ?, ?, ?,  ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?,  ?, ?)";

	private static final String UPDATE = "UPDATE [package] SET ";

	private static final String DELETE_BY_ID = "DELETE [package] WHERE [id] = ?";

	static Context context;
	static DataSource dataSource;
	
	

	public static void main(String[] args) {
		// selectById
		PackageDAO packageDAO = new PackageDAO();
		PackageBean packageBean1 = packageDAO.selectById("p01703150001");
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
			PackageBean packageBean2 = packageDAO.selectById(id);
			System.out.println(packageBean2);
		}
		
		// deleteById
		packageDAO.deleteById("p01707270001");
		PackageBean packageBean3 = packageDAO.selectById("p01707270001");
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
	
//	private static final String url = "jdbc:sqlserver://localhost:1433;DatabaseName=her";
//	private static final String user = "sa";
//	private static final String password = "sa123456";

	@Override
	public List<String> getPackageIds(String memberId, int status) {
		Connection conn;
		List<String> packageIds = new ArrayList<String>();
		try {
			conn = dataSource.getConnection();
//			conn = DriverManager.getConnection(url, user, password);
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
	public PackageBean selectById(String id) {
		Connection conn;
		PackageBean packageBean = null;
		try {
			conn = dataSource.getConnection();
//			conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				packageBean = new PackageBean();
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
				packageBean.setStatus(rs.getBoolean("status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return packageBean;
	}

	@Override
	public int insert(PackageBean packagebean) {
		Connection conn;
		int result = 0;
		
		try {
//			conn = DriverManager.getConnection(url, user, password);
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, packagebean.getId());
			pstmt.setString(2, packagebean.getName());
			pstmt.setString(3, packagebean.getMemberId());
			pstmt.setString(4, packagebean.getCardId());
			pstmt.setDouble(5, packagebean.getCardPrice());
			pstmt.setString(6, packagebean.getFontId());
			pstmt.setDouble(7, packagebean.getFontPrice());
			pstmt.setDouble(8, packagebean.getGiftSum());
			pstmt.setString(9, packagebean.getContent());
			pstmt.setString(10, packagebean.getRecipientId());
			pstmt.setString(11, packagebean.getRecipientName());
			pstmt.setString(12, packagebean.getRecipientPhone());
			pstmt.setString(13, packagebean.getRecipientCity());
			pstmt.setString(14, packagebean.getRecipientDistrict());
			pstmt.setString(15, packagebean.getRecipientAddr());
			pstmt.setDate(16, packagebean.getDateMailed());
			pstmt.setString(17, packagebean.getSenderName());
			pstmt.setString(18, packagebean.getSenderPhone());
			pstmt.setString(19, packagebean.getSenderCity());
			pstmt.setString(20, packagebean.getSenderDistrict());
			pstmt.setString(21, packagebean.getSenderAddr());
			pstmt.setBoolean(22, packagebean.getStatus());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(PackageBean packageBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(String id) {
		Connection conn = null;
		int result = 0;
		
		try {
//			conn = DriverManager.getConnection(url, user, password);
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
