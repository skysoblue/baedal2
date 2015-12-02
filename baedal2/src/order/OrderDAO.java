package order;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import global.Constants;
import global.DAO;
import global.DatabaseFactory;
import global.Vendor;

public class OrderDAO extends DAO{
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	OrderVO order = new OrderVO();
	
	private static OrderDAO instance = new OrderDAO();
	public static OrderDAO getInstance() {
		return instance;
	}
	
	public OrderDAO() {
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
	public int add(String userid){
		String sql = "INSERT INTO ORDERS(ORDER_SEQ,USERID)VALUES( NEXT VALUE FOR SEQ, ?)";
		int result = 0;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int selectOrdersById(String userid) {
		String sql = "SELECT ORDER_SEQ FROM ORDERS WHERE USERID = ?";
		int orderSeq = 0;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				orderSeq = rs.getInt("ORDER_SEQ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderSeq;
	}

	@Override
	public void selectOrderMenu() {
	
		
	}
	//=================================//
	
	public String searchPrices(String seq) {
		String result = "";
		String sql = "";
		try {
			rs = connection.createStatement().executeQuery(sql);
			while (rs.next()) {
				result = rs.getString("price");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(result+"테이블 비교 결과 가격");
		return result;
	}
	
	public String[] searchMember(String userid) {
		String[] result = new String[4];
		String sql = "";
		try {
			rs = connection.createStatement().executeQuery(sql);
			while (rs.next()) {
				result[0] = rs.getString("userid");
				result[1] = rs.getString("name");
				result[2] = rs.getString("phone");
				result[3] = rs.getString("addr");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String searchMenu(String seq) {
		String result = "";
		String sql = "";
		try {
			rs = connection.createStatement().executeQuery(sql);
			while(rs.next()){
				result = rs.getString("food_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void selectOrderMember() {
		// TODO Auto-generated method stub
		
	}


}
