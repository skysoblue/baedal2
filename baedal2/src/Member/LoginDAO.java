package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import global.Constants;
import global.DAO;

public class LoginDAO extends DAO{
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<LoginVO> list = new ArrayList<LoginVO>();
	private LoginVO login = new LoginVO();
	
	private static LoginDAO instance = new LoginDAO();
	public LoginDAO() {
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
	public static LoginDAO getInstance() {
		return instance;
	}
		//--------------- 회원가입
		@Override
		public int insert(LoginVO o) {
			int result = 0;
			try {
				pstmt = connection.prepareStatement(o.insert());
				pstmt.setString(1, o.getUserid());
				pstmt.setString(2, o.getPassword());
				pstmt.setString(3, o.getName());
				pstmt.setString(4, o.getPhone());
				pstmt.setString(5, o.getAddr());
				pstmt.setString(6, o.getBirth());
				pstmt.setString(7, o.getQuestion());
				pstmt.setString(8, o.getAnswer());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		/**
		 * @see 로그인
		 * @return 로그인객체
		 * @param 아이디, 비번
		 */
		public LoginVO login(String userid, String pass) {
			try {
				pstmt = connection
						.prepareStatement("SELECT * FROM MEMBER WHERE USERID = ? AND PASSWORD = ?");
				pstmt.setString(1, userid);
				pstmt.setString(2, pass);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					do {
						System.out.println("******************TRUE********************* ");
						login.setUserid(rs.getString("USERID"));
						login.setPassword(rs.getString("PASSWORD"));
						login.setName(rs.getString("NAME"));
						login.setPhone(rs.getString("PHONE"));
						login.setAddr(rs.getString("ADDR"));
						login.setBirth(rs.getString("BIRTH"));
						login.setQuestion(rs.getString("QUESTION"));
						login.setAnswer(rs.getString("ANSWER"));
					
					} while (rs.next());
					
				} else {
				}
					
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return login;
		}		
	
		public List<LoginVO> selectAll() {
			List<LoginVO>temp = new ArrayList<LoginVO>();
			
			try {
				stmt = connection.createStatement();
				rs = stmt.executeQuery(login.selectAll());
				while (rs.next()) {
					LoginVO vo = new LoginVO();
					vo.setUserid(rs.getString("USERID"));
					vo.setPassword(rs.getString("PASSWORD"));
					vo.setName(rs.getString("NAME"));
					vo.setPhone(rs.getString("PHONE"));
					vo.setAddr(rs.getString("ADDR"));
					vo.setBirth(rs.getString("BIRTH"));
					vo.setQuestion(rs.getString("QUESTION"));
					vo.setAnswer(rs.getString("ANSWER"));
					temp.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return temp;
			
		}

		public List<LoginVO> searchById(String name, String birth) {
			List<LoginVO> list = new ArrayList<LoginVO>();
			
			try {
				stmt = connection.createStatement();
				rs = stmt.executeQuery(login.selectByID(name, birth));
				System.out.println("디버깅");
				while (rs.next()) {
					LoginVO result = new LoginVO();
					result.setUserid(rs.getString("USERID"));
					result.setPassword(rs.getString("PASSWORD"));
					result.setName(rs.getString("NAME"));
					result.setPhone(rs.getString("PHONE"));
					result.setAddr(rs.getString("ADDR"));
					result.setBirth(rs.getString("BIRTH"));
					result.setQuestion(rs.getString("QUESTION"));
					result.setAnswer(rs.getString("ANSWER"));
					list.add(result);

					/* list.add(result); */
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("디버깅");
			return list;
		}

		public List<LoginVO> searchByPass(String id, String que, String ans) {
			List<LoginVO> list = new ArrayList<LoginVO>();
			try {
				stmt = connection.createStatement();
				rs = stmt.executeQuery(login.selectByPass(id, que, ans));
				while (rs.next()) {
					LoginVO result = new LoginVO();
					result.setUserid(rs.getString("USERID"));
					result.setPassword(rs.getString("PASSWORD"));
					result.setName(rs.getString("NAME"));
					result.setPhone(rs.getString("PHONE"));
					result.setAddr(rs.getString("ADDR"));
					result.setBirth(rs.getString("BIRTH"));
					result.setQuestion(rs.getString("QUESTION"));
					result.setAnswer(rs.getString("ANSWER"));
					list.add(result);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return list;
		}
		@Override
		public void selectOrderMember() {
			
		}
		@Override
		public void selectOrderMenu() {
			
		}
		public boolean checkDupl(String id) {
			// 저장되어 있는 아이디 값과 내가 입력한 아이디값을 비교,

			boolean exist = false;
			LoginVO temp = new LoginVO();
			try {	
				stmt = connection.createStatement();
				rs = stmt.executeQuery(login.checkID(id));
				
				while (rs.next()) { 
					if (rs.getString("userid") != null) {
						exist = true;				
					} else {
						exist = false;
					}
				}
				System.out.println(exist);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return exist;
		}




}