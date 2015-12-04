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

public class MemberDAO extends DAO{
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<MemberVO> list = new ArrayList<MemberVO>();
	private MemberVO login = new MemberVO();
	
	private static MemberDAO instance = new MemberDAO();
	public MemberDAO() {
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
	public static MemberDAO getInstance() {
		return instance;
	}
		//--------------- 회원가입
		@Override
		public int insert(MemberVO o) {
			int result = 0;
			try {
				pstmt = conn.prepareStatement(o.insert());
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
		public MemberVO login(String userid, String pass) {
			try {
				pstmt = conn
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
	
		public List<MemberVO> selectAll() {
			List<MemberVO>temp = new ArrayList<MemberVO>();
			
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(login.selectAll());
				while (rs.next()) {
					MemberVO vo = new MemberVO();
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
		public MemberVO searchById(String userid) {
			String sql = "SELECT * FROM MEMBER WHERE USERID = '"+userid+"'";
			MemberVO member = new MemberVO();
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				System.out.println("디버깅");
				while (rs.next()) {
					
					member.setUserid(rs.getString("USERID"));
					member.setPassword(rs.getString("PASSWORD"));
					member.setName(rs.getString("NAME"));
					member.setPhone(rs.getString("PHONE"));
					member.setAddr(rs.getString("ADDR"));
					member.setBirth(rs.getString("BIRTH"));
					member.setQuestion(rs.getString("QUESTION"));
					member.setAnswer(rs.getString("ANSWER"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return member;
		}
		public List<MemberVO> searchById(String name, String birth) {
			List<MemberVO> list = new ArrayList<MemberVO>();
			
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(login.selectByID(name, birth));
				System.out.println("디버깅");
				while (rs.next()) {
					MemberVO result = new MemberVO();
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

		public String searchByPass(String userid, String question, String answer) {
			System.out.println("넘어온 아이디 : "+userid);
			System.out.println("넘어온 질문 : "+question);
			System.out.println("넘어온 답 : "+answer);
			String password = "";
			try {
				String sql = "SELECT PASSWORD FROM MEMBER WHERE USERID = ? AND QUESTION = ? AND ANSWER = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				pstmt.setString(2, question);
				pstmt.setString(3, answer);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					password = rs.getString("PASSWORD");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return password;
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
			MemberVO temp = new MemberVO();
			try {	
				stmt = conn.createStatement();
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