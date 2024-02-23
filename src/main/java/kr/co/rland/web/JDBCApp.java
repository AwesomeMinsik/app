package kr.co.rland.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class JDBCApp {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		int menus;
//		----------예제1------------------------------------------------------
//		{
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("메뉴 검색 프로그램");
//			System.out.print("메뉴명 입력: ");
//			String user = scanner.nextLine();
//
//			Class.forName("oracle.jdbc.OracleDriver");
//			String url = "jdbc:oracle:thin:@db.newlecture.com:1521/xepdb1";
//			String sql = "select * from menu WHERE KOR_NAME like '" + user + "%'";
//			Connection con = DriverManager.getConnection(url, "RLAND", "0530");
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(sql);
////		rs.next();
//		--------축약버전--------
//		DriverManager
//		.getConnection(url)
//		.createStatement()
//		.executeQuery(sql)
//		.next();
//		------------------------
//			int count = 0; //출력되는 메뉴가 총 몇개인지 테스트용도
//
//			while (rs.next()) {
////			System.out.print(++count+" " );
////			System.out.print(rs.getString("ID")+" "+rs.getString("KOR_NAME")+" "+rs.getString("PRICE"));
////			String t = rs.getString("ENG_NAME");
////			System.out.print(rs.getString("KOR_NAME")+" ");
////			System.out.print(rs.getString("PRICE")+" ");
////			System.out.println();
//				Menu menu = new Menu(rs.getInt("ID"), rs.getString("kor_name"), rs.getString("eng_name"),
//						rs.getString("img"), rs.getInt("price"), rs.getInt("like"));
//				System.out.printf("%-5s%-10s%-5s\n", "아이디", "메뉴명", "가격");
//				System.out.printf("%-8d%-10s%-5d\n", rs.getInt("ID"), rs.getString("kor_name"), rs.getInt("price"));
////			System.out.println(menu.toString());
//			}
//		}
		
//		----------예제2------------------------------------------------------
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("회원 검색 프로그램");
			System.out.print("검색 분류\n한글명(1) 영문명(2) 가격(3): ");
			int index = Integer.parseInt(scanner.nextLine());
			System.out.print("검색어 입력: ");
			String query = scanner.nextLine();

			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@db.newlecture.com:1521/xepdb1";
			String sql = null;
			if (index==1) 
				sql = "select * from menu WHERE KOR_NAME like '%" + query + "%'";
			else if (index==2) 
				sql = "select * from menu WHERE ENG_NAME like '%" + query + "%'";
			else if (index==3) 
				sql = "select * from menu WHERE PRICE IN("+ query + ")";
			else { 
				System.out.println("잘못된 분류값 입력");
				return;
			}
			
			
//			switch (index) {
//			case 1:
//			{
//				sql = "select * from menu WHERE KOR_NAME like '" + user + "%'";
//				break;
//			}
//			case 2:
//			{
//				sql = "select * from menu WHERE ENG_NAME like '" + user + "%'";
//				break;
//			}
//			case 3:
//			{
//				sql = "select * from menu WHERE PRICE IN("+ user + ")";
//				break;
//			}
//
//			default:
//				System.out.println("잘못된 분류타입");
//				break;
//			}
//			String sql = "select * from menu WHERE KOR_NAME like '" + user + "%'";
			Connection con = DriverManager.getConnection(url, "RLAND", "0530");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
//		rs.next();
			int count = 0;

			while (rs.next()) {
//			System.out.print(++count+" " );
//			System.out.print(rs.getString("ID")+" "+rs.getString("KOR_NAME")+" "+rs.getString("PRICE"));
//			String t = rs.getString("ENG_NAME");
//			System.out.print(rs.getString("KOR_NAME")+" ");
//			System.out.print(rs.getString("PRICE")+" ");
//			System.out.println();
//				Menu menu = new Menu(rs.getInt("ID"), rs.getString("kor_name"), rs.getString("eng_name"),
//						rs.getString("img"), rs.getInt("price"), rs.getInt("like"));
//				System.out.printf("%-5s%-20s%-10s\n", "아이디", "메뉴명", "가격");
//				System.out.printf("%-8d%-20s%-10d\n", rs.getInt("ID"), rs.getString("kor_name"), rs.getInt("price"));
//			System.out.println(menu.toString());
			}
		}
		
//		----------예제3------------------------------------------------------
		{
			
		}
		
	}
}
