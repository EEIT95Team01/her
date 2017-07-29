package com.eeit95.her.model.dao.card;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.collections.ResettableIterator;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardDescriptionBean;
import com.eeit95.her.model.card.CardDescriptionDAOInterface;

public class CardDescriptionDAOjdbc implements CardDescriptionDAOInterface {
	private static final String Select_By_Id = "select * from [card_description] where [cardId] = ?";
	private static final String Insert = "insert into [card_description] values(?,?,?,?)";
	private static final String Delete = "delete from [card_description] where id=?";
	private static DataSource ds;
	private static Connection conn;
	private static List<CardDescriptionBean> result = new ArrayList<CardDescriptionBean>();

	// static{
	// try {
	// Context context = new InitialContext();
	// ds= (DataSource)context.lookup("java:comp/env/jdbc/her");
	// result = new ArrayList<CardBean>();
	// } catch (NamingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	public static void main(String[] args) {

	}

	@Override
	public List<CardDescriptionBean> selectById(String cardId) {
		try {
			// conn = ds.getConnection();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			PreparedStatement stmt = conn.prepareStatement(Select_By_Id);
			stmt.setString(1, cardId);
			ResultSet rest = stmt.executeQuery();
			while (rest.next()) {
				CardDescriptionBean bean = new CardDescriptionBean();
				bean.setCardId(rest.getString("cardId"));
				bean.setOrder(rest.getShort("order"));
				bean.setText(rest.getString("text"));
				bean.setImage(rest.getBytes("image"));

				result.add(bean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List <CardDescriptionBean> insert(List <CardDescriptionBean> beans) {
		try {
			// conn = ds.getConnection();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
			PreparedStatement stmt = conn.prepareStatement(Insert);
			for(CardDescriptionBean bean:beans) {
				stmt.setString(1,bean.getCardId());
				stmt.setShort(2,bean.getOrder());
				stmt.setString(3,bean.getText());
				stmt.setBytes(4,bean.getImage());
			}

				int i = stmt.executeUpdate();
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteById(String cardId) {
		try{
		conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=her", "sa", "sa123456");
		PreparedStatement stmt = conn.prepareStatement(Delete);

		if (cardId != null) {
			stmt.setString(1, cardId);
			int i = stmt.executeUpdate();
			return true;
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;

	}
}