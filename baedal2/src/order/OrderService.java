package order;

import java.util.List;

public interface OrderService {
// 	주문 회원 정보 호출
//	public LoginVO searchOrderMember();
	
// 	주문내용 가격 찾기.
	public int add(String userid);
	public String searchPrices(String seq);	
	public String[] searchMember(String seq);
	public String searchMenu(String userid);
	
}
