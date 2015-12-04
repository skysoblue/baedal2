package order;

import java.io.Serializable;

import global.SQL;

public class OrderVO implements Serializable{
	private static final long serialVersionUID = 1L;
	public static String USERID, CAT_ID, MENU_ID, STORE_ID;
	private int seq;
	private String userid, catId, menuId, storeId;
	public int getSeq() {
		return seq;
	}
	public String getUserid() {
		return userid;
	}
	public String getCatId() {
		return catId;
	}
	public String getMenuId() {
		return menuId;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
}
