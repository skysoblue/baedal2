package order;

import java.util.List;

public class OrderServiceImpl implements OrderService{

	private static OrderService instance = new OrderServiceImpl();
	public static OrderService getInstance(){
		return instance;
	}
	OrderDAO dao = OrderDAO.getInstance();
	
	public int add(String userid){
		return dao.add(userid);
	}
	@Override
	public String searchPrices(String menuId) {
		String num = dao.searchPrices(menuId);
		String result = "";
		String temp = "";
		int j = 0;
		for (int i = num.length()-1; i >= 0; i--) {
			j++;
			if (j > 0) {
				if (j % 3 == 0) {
					String b = ",";
					b += num.substring(i, i+3);
					temp = b;
					b = result;
					result = temp;
					result +=b;
				}
				if (j+1 == num.length()) {
					String temp2 = num.substring(0, j%3+1);
					temp = temp2;
					temp2 = result;
					result = temp;
					result += temp2;
				}
			}
		}
			System.out.println("서치프라이스 임플 결과 : "+result);
		return result;
	}
	public String[] searchMember(String userid) {
		String[] temp = dao.searchMember(userid);
		return temp;
	}

	@Override
	public String searchMenu(String seq) {
		return dao.searchMenu(seq);
	}
	
}
