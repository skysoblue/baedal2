package store;

import java.util.List;

public interface StoreService {
	// 식당 검색
	public List<StoreVO> getStoresBy(String catId);
}
