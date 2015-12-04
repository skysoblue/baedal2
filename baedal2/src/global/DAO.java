package global;

import Member.MemberVO;

public abstract class DAO {
	public int insert (MemberVO o){return 0;}{}
	public MemberVO searchById (String name, String birth, String findName, String findBirth){return null;}
	public MemberVO searchByPass (String id, String que, String ans, String id2, String que2, String ans2){return null;}
	
	public abstract void selectOrderMember();
	public abstract void selectOrderMenu();

	
}
