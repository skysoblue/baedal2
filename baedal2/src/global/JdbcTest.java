package global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	private static Connection conn;
	private static JdbcTest instance = new JdbcTest();
	private JdbcTest() {
		try {
			Class.forName(Constants.HSQL_DRIVER);
			conn = DriverManager.getConnection(
					Constants.HSQL_URL,
					Constants.HSQL_ID,
					Constants.HSQL_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static JdbcTest getInstance() {
		return instance;
	}
	public Connection getConnection() {
		return conn;
	}

	public static void main(String[] args) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            	int result = 0;
        		String sql = "SELECT * FROM MEMBER";
        		conn = JdbcTest.getInstance().getConnection();
        		if (conn == null) {
					System.out.println("커넥션이 널");
				}else{
					pstmt = conn.prepareStatement(sql);
				}
				rs = pstmt.executeQuery();
				System.out.println("결과 : "+result);
				String temp = null;
				while (rs.next()) {
					temp = rs.getString("USERID");
				}
				System.out.println("임시값 : "+temp);
        } catch (Exception e ) {
            System.out.println("HSQLDB 에러발생 !!");
            e.printStackTrace();
            return;
        } 
	}
	
}
