package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Category;
import utils.ConnectionUtil;

public class CategoryDAO {
	private Connection con;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	public ArrayList<Category> findAll(){
		ArrayList<Category> lists=new ArrayList<>();
		final String sql="select*from categories order by id desc";
		con=ConnectionUtil.getConnection();
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Category cat=new Category(rs.getInt("id"),rs.getString("name"));
				lists.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(rs,pst,con);
		}
		
		
		return lists;
	}
}
