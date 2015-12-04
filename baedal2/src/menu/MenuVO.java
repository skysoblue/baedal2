package menu;

import java.io.Serializable;

import global.SQL;

public class MenuVO implements Serializable, SQL {

	private static final long serialVersionUID = 1L;
	private String menuId;
	private String menuName;
	private String menuImg;
	private int price;
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMenuId() {
		return menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public String getMenuImg() {
		return menuImg;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}

	public String selectMenusBy(String storeId) {
		String qurey = "SELECT * FROM MENU WHERE STORE_ID = " + make(storeId);
		return qurey;
	}

	// =========== 가격 검색 ======================

	public String selectPrice(int menuSeq) {
		String qurey = "select price from store_menu s inner join menu m " + "on s.menu_seq = m.menu_seq "
				+ "where s.menu_seq = " + menuSeq;
		return qurey;
	}

	@Override
	public String make(String s) {
		return "'" + s + "'";
	}
}