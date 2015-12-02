package menu;

import java.util.List;

public interface MenuService {

	// 멤버 검색..
	public void getOrderMember();

	// 메뉴검색..
	public void getOrderMenu();

	// 가격을 넘겨줘
	public int getPrice(String menuId);

	// 상품이미지를 호출
	public List<MenuVO> getMenusBy(String storeId);

	public String[] getProfileImages();


}