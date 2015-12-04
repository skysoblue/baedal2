package store;

import java.util.List;

public interface StoreService {
	// 식당 검색
	public List<StoreVO> getStores(String catId);
	public String getStoreName(String storeId);
}
