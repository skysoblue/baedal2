package Member;

import java.util.List;

public class MemberServiceImpl implements MemberService{
	MemberDAO dao = MemberDAO.getInstance();
	
	private static MemberServiceImpl instance = new MemberServiceImpl();
	public static MemberServiceImpl getInstance() {
		return instance;
	}
	@Override
	public void join(String id, String pass, String name, String phone, String addr, String birth,String que, String ans) {
		MemberVO vo = new MemberVO(id,pass,name,phone,addr,birth,que,ans);
		dao.insert(vo);
	}

	@Override
	public MemberVO login(String id, String pass) {
		return 	dao.login(id, pass);
	}
	@Override
	public MemberVO searchById(String userid) {
		System.out.println("디버깅");
		return  dao.searchById(userid);
	}

	@Override
	public List<MemberVO> searchById(String name, String birth) {
		System.out.println("디버깅");
		return  dao.searchById(name, birth);
	}

	public String searchByPass(String id, String que, String ans) {
		return dao.searchByPass(id, que ,ans);
	}

	@Override
	public boolean checkDupl(String userid) {
		boolean exist = false;
		if (dao.checkDupl(userid)) {
			exist = true;
		}else {
			exist = false;
		}
		
		return exist;
	}



}