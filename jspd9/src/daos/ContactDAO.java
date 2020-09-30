package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Contact;
import utils.ConnectionUtil;

public class ContactDAO {
	private static Connection con;
	private static PreparedStatement pst;
	private static Statement st;
	private static ResultSet rs;

	public static int addItem(Contact objAdd) {

		int result = 0;
		String sql = "INSERT INTO contact ( name, phone, web, gender, picture, content) VALUES ( ?, ?, ?, ?, ?, ?)";

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objAdd.getName());
			pst.setInt(2, objAdd.getPhone());
			pst.setString(3, objAdd.getWeb());
			pst.setString(4, objAdd.getGender());
			pst.setString(5, objAdd.getPicture());
			pst.setString(6, objAdd.getContent());
			result=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}

		return result;
	}
}
