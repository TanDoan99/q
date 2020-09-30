package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.News;
import utils.ConnectionUtil;

public class NewsDAO {
	private Connection con;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ArrayList<News> tinTuc(int cat_id) {
		ArrayList<News> listNews = new ArrayList<News>();
		final String sql = "select * from news where cat_id = ?";
		con = ConnectionUtil.getConnection();

		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, cat_id);
			rs = pst.executeQuery();
			while (rs.next()) {
				News index = new News(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getString("description"), rs.getString("detail"), rs.getString("created_at"),
						rs.getInt("cat_id"));
				listNews.add(index);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}

		return listNews;
	}
	public ArrayList<News> listTinTuc() {
		ArrayList<News> listTin = new ArrayList<News>();
		final String sql = "select * from news";
		con = ConnectionUtil.getConnection();

		try {
			st = con.createStatement();
			
			rs = st.executeQuery(sql);
			while (rs.next()) {
				News listIndex = new News(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getString("description"), rs.getString("detail"), rs.getString("created_at"),
						rs.getInt("cat_id"));
				listTin.add(listIndex);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, st, con);
		}

		return listTin;
	}
	public News listDetail(int id) {
		News list = null;
		final String sql = "select * from news where id=?";
		con = ConnectionUtil.getConnection();

		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				 list = new News(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getString("description"), rs.getString("detail"), rs.getString("created_at"),
						rs.getInt("cat_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}

		return list;
	}
}
