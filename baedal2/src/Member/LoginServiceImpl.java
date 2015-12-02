package Member;

import java.util.List;

public class LoginServiceImpl implements LoginService{
	LoginDAO dao = LoginDAO.getInstance();
	
	private static LoginServiceImpl instance = new LoginServiceImpl();
	public static LoginServiceImpl getInstance() {
		return instance;
	}
	@Override
	public void join(String id, String pass, String name, String phone, String addr, String birth,String que, String ans) {
		LoginVO vo = new LoginVO(id,pass,name,phone,addr,birth,que,ans);
		dao.insert(vo);
	}

	@Override
	public LoginVO login(String id, String pass) {
		return 	dao.login(id, pass);
	}

	@Override
	public List<LoginVO> searchById(String name, String birth) {
		System.out.println("디버깅");
		return  dao.searchById(name, birth);
	}

	public List<LoginVO> searchByPass(String id, String que, String ans) {
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