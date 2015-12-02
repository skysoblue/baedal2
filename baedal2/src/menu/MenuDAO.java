package menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import global.Constants;
import global.DAO;

public class MenuDAO extends DAO {
	private Connection connection;
	private Statement stmt;
	private ResultSet rs;
	private MenuVO menu = new MenuVO();
	private static MenuDAO instance = new MenuDAO();

	public static MenuDAO getInstance() {
		return instance;
	}

	public MenuDAO() {
		try {
			/**
			 * 오라클 커넥션 connection = DatabaseFactory.getDatabase(Vendor.ORACLE,
			 * Constants.ORACLE_ID, Constants.ORACLE_PASSWORD) .getConnection();
			 */
			// HSQL 커넥션
			Class.forName(Constants.HSQL_DRIVER);
			connection = DriverManager.getConnection(Constants.HSQL_URL, Constants.HSQL_ID, Constants.HSQL_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void selectOrderMember() {
		// TODO Auto-generated method stub

	}

	public List<MenuVO> selectMenusBy(String storeId) {
		List<MenuVO> list = new ArrayList<MenuVO>();
		MenuVO menu = new MenuVO();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(menu.selectMenusBy(storeId));
			while (rs.next()) {
				menu.setMenuName(rs.getString("MENU_NAME"));
				list.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// === 가격을 넘겨주는 메소드 ====
	public int selectPrice(String menuName) {
		MenuVO temp = new MenuVO();
		int price = 0;
		try {
			String sql = "SELECT * FROM MENU WHERE MENU_NAME = '"+menuName+"'";
			
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				price = rs.getInt("PRICE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return price;
	}
	
	@Override
	public void selectOrderMenu() {
		

	}

	public String[] selectMenuImagesBy(int cateSeq) {
		// 카테고리별 메뉴이미지. 최대8개로 정 
		List<String> list = new ArrayList<String>();
		
		return null;
	}

}