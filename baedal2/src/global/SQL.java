package global;

import java.util.List;

public interface SQL {
	/**
	 * executeUpdate : DML 중에 테이블의 데이터값이 변형됨
	 */
//	public String insert();		// 추가
//	public String login();		// 로그인
//
//	/**
//	 * executeQuery : DML 중에 테이블의 데이터값이 변형되지 않음 
//	 */
//	public String selectByID(String name, String birth, String name2, String birth2);		// ID 찾기
//	public String selectByPass(String userid, String que, String ans, String userid2, String que2, String ans2);	// pass 찾기
//	
//	
//	
//	public String selectCate();				// 카테고리 조회
//	public String selectStore();			// 식당 조회
//	public String selectMenu();				// 메뉴 조회
//	
//	public String selectOrderMember();			// 주문 페이지 회원정보 호출
//	public String selectOrderMenu();			// 주문 페이지 메뉴정보 호출
	
	
	/**
	 * 쿼리 스타일
	 */
	public String make(String s);		// SQL타입의 파라미터로 변환

	

}
