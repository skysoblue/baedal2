package order;

import java.io.Serializable;

import global.SQL;

public class OrderVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userid, name, phone, addr, menuName, menuImg;
	private int price, orderSeq;
	private String catId;
	
	
	public int getOrderSeq() {
		return orderSeq;
	}
	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddr() {
		return addr;
	}
	public String getMenuName() {
		return menuName;
	}
	public String getMenuImg() {
		return menuImg;
	}
	public int getPrice() {
		return price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

	
	//	================Member====================

}
