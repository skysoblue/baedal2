package Member;

import java.util.List;

public interface MemberService {
	//회원가입
	
	public void join (String userid, String pass, String name, String phone, String addr, String birth, String que , String ans);
	
	// 로그인
	public MemberVO login(String userid, String pass); 
	
	
	// 아이디 찾기
	public MemberVO searchById(String userid);
	public List<MemberVO> searchById(String name, String birth);
	
	
	// 비밀번호 찾기
	
	public String searchByPass(String id, String que, String ans);
	
	
	// 중복 체크
	public boolean checkDupl(String userid);

	
// 	비번 변경
//	public String changePass(String id, String pass);

	
}
