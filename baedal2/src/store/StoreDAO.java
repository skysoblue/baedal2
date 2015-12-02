package store;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import global.Constants;
import global.DAO;

public class StoreDAO extends DAO{
	
	private Connection connection;
	private Statement stmt;
	private ResultSet rs;
	
	
	private static StoreDAO instance = new StoreDAO();
	public static StoreDAO getInstance() {
		return instance;
	}
	
	public StoreDAO() {
		 try {
				/**
				 * 오라클 커넥션
				 * connection = DatabaseFactory.getDatabase(Vendor.ORACLE,
				 *               Constants.ORACLE_ID, 
				 *               Constants.ORACLE_PASSWORD)
				 *               .getConnection();
				 */
				// HSQL 커넥션
				Class.forName(Constants.HSQL_DRIVER);
				connection = DriverManager.getConnection(
						Constants.HSQL_URL,
						Constants.HSQL_ID,
						Constants.HSQL_PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public List<StoreVO> selectStoresBy(String catId){
		List<StoreVO> list = new ArrayList<StoreVO>();
		String sql = "SELECT * FROM STORE"
				+ " WHERE CAT_ID = '"+ catId+"'";
		try {
			rs = connection.createStatement().executeQuery(sql);
			while (rs.next()) {
				StoreVO temp = new StoreVO();
				temp.setStoreId(rs.getString("STORE_ID"));
				temp.setStoreName(rs.getString("STORE_NAME"));
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
		

	@Override
	public void selectOrderMember() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectOrderMenu() {
		// TODO Auto-generated method stub
		
	}


}
