package store;

import java.util.List;

public class StoreServiceImpl implements StoreService{
	private static StoreService instance = new StoreServiceImpl();
	private StoreServiceImpl() {}
	public static StoreService getInstance(){return instance;}
	StoreDAO dao = StoreDAO.getInstance();
	@Override
	public List<StoreVO> getStores(String catId) {
		return dao.selectStores(catId);
	}
	@Override
	public String getStoreName(String storeId) {
		String storeName = dao.selectStoreName(storeId);
		System.out.println("식당이름 : "+storeName);
		return storeName;
	}

}
