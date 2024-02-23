package kr.co.rland.web.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.rland.web.entity.Menu;

public class JDBCMenuRepository implements MenuRepository{

	public List<Menu> findAll() {
		List<Menu> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@db.newlecture.com:1521/xepdb1";
			String sql = "select * from menu";
			Connection con = DriverManager.getConnection(url, "RLAND", "0530");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setId(rs.getInt("ID"));
				menu.setKorName(rs.getString("kor_name"));
				menu.setEngName(rs.getString("eng_name"));
				menu.setImg(rs.getString("img"));
				menu.setPrice(rs.getInt("price"));
				menu.setLike(rs.getBoolean("like"));
				menu.setRegDate(rs.getDate("reg_date"));
				list.add(menu);
//				System.out.println(menu.toString());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Menu findById(int id) {
		Menu menu = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@db.newlecture.com:1521/xepdb1";
			String sql = "SELECT * FROM MENU WHERE ID="+id;
			Connection con = DriverManager.getConnection(url, "RLAND", "0530");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				menu = new Menu();
				menu.setId(rs.getInt("ID"));
				menu.setKorName(rs.getString("kor_name"));
				menu.setEngName(rs.getString("eng_name"));
				menu.setImg(rs.getString("img"));
				menu.setPrice(rs.getInt("price"));
				menu.setLike(rs.getBoolean("like"));
				menu.setRegDate(rs.getDate("reg_date"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return menu;
	}

}
