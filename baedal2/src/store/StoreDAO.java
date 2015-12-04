package store;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import global.Constants;
import global.DAO;

public class StoreDAO {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	private static StoreDAO instance = new StoreDAO();
	public static StoreDAO getInstance() {
		return instance;
	}
	
	public StoreDAO() {
		 try {
				/**
				 * 오라클 커넥션
				 * conn = DatabaseFactory.getDatabase(Vendor.ORACLE,
				 *               Constants.ORACLE_ID, 
				 *               Constants.ORACLE_PASSWORD)
				 *               .getConnection();
				 */
				// HSQL 커넥션
				Class.forName(Constants.HSQL_DRIVER);
				conn = DriverManager.getConnection(
						Constants.HSQL_URL,
						Constants.HSQL_ID,
						Constants.HSQL_PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public List<StoreVO> selectStores(String catId){
		List<StoreVO> list = new ArrayList<StoreVO>();
		try {
			String sql = "SELECT * FROM STORE WHERE CAT_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, catId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StoreVO temp = new StoreVO();
				temp.setStoreId(rs.getString("STORE_ID"));
				temp.setStoreName(rs.getString("STORE_NAME"));
				temp.setCatId(rs.getString("CAT_ID"));
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("가게리스트 출력 : "+list);
		return list;
	}
		

	public String selectStoreName(String storeId) {
		String sql = "SELECT STORE_NAME FROM STORE WHERE STORE_ID = ?";
		String storeName = "";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, storeId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				storeName = rs.getString("STORE_NAME");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return storeName;
	}
}
