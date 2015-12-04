package menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import global.Constants;

public class MenuDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private MenuVO menu = new MenuVO();
	private static MenuDAO instance = new MenuDAO();

	public static MenuDAO getInstance() {
		return instance;
	}

	public MenuDAO() {
		try {
			/**
			 * 오라클 커넥션 conn = DatabaseFactory.getDatabase(Vendor.ORACLE,
			 * Constants.ORACLE_ID, Constants.ORACLE_PASSWORD) .getConnection();
			 */
			// HSQL 커넥션
			Class.forName(Constants.HSQL_DRIVER);
			conn = DriverManager.getConnection(Constants.HSQL_URL, Constants.HSQL_ID, Constants.HSQL_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MenuVO> selectMenus(String storeId) {
		List<MenuVO> list = new ArrayList<MenuVO>();
		String sql = "SELECT * FROM MENU ";
		try {
			pstmt = conn.prepareStatement(sql);
			/*pstmt.setString(1, storeId);*/
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MenuVO menu = new MenuVO();
				menu.setMenuId(rs.getString("MENU_ID"));
				menu.setMenuImg(rs.getString("MENU_IMG"));
				menu.setMenuName(rs.getString("MENU_NAME"));
				menu.setPrice(rs.getInt("PRICE"));
				list.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public String selectMenuName(String menuId) {
		String menuName = "";
		String sql = "SELECT MENU_NAME FROM MENU WHERE MENU_ID = '"+menuId+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				menuName = rs.getString("MENU_NAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuName;
	}

	// === 가격을 넘겨주는 메소드 ====
	public int selectPrice(String menuId) {
		int price = 0;
		try {
			String sql = "SELECT PRICE FROM MENU WHERE MENU_ID = '"+menuId+"'";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				price = rs.getInt("PRICE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return price;
	}
	

	public String[] selectMenuImagesBy(int cateSeq) {
		// 카테고리별 메뉴이미지. 최대8개로 정 
		List<String> list = new ArrayList<String>();
		
		return null;
	}

}