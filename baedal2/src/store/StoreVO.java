package store;

import java.io.Serializable;

import global.SQL;

public class StoreVO implements Serializable, SQL{
	private static final long serialVersionUID = 1L;
	private String storeId;
	private String storeName;
	private String catId;
	
	public StoreVO() {}
	
	public StoreVO(String storeId, String storeName, String catId) {
		this.storeId = storeId;
		this.storeName = storeName;
		this.catId = catId;
	}
	public String getStoreId() {
		return storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public String getCatId() {
		return catId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	

	
//	=================식당 검색==================

	@Override
	public String toString() {
		return "상점들 [아이디=" + storeId + ", 상호명=" + storeName + ", 카테고리=" + catId + "]";
	}

	public String selectStore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String make(String s) {
		// TODO Auto-generated method stub
		return null;
	}


}

