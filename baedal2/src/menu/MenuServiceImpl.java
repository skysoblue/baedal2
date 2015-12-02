package menu;

import java.util.List;

public class MenuServiceImpl implements MenuService{
   MenuDAO dao = MenuDAO.getInstance();
   
   private static MenuServiceImpl instance = new MenuServiceImpl();
   public static MenuServiceImpl getInstance(){
      return instance;
   }
   
   @Override
   public void getOrderMember() {
      // TODO Auto-generated method stub
   }

   @Override
   public void getOrderMenu() {
      // TODO Auto-generated method stub
      
   }


   @Override
   public int getPrice(String menu) {
      return dao.selectPrice(menu);
   }

	@Override
	public List<MenuVO> getMenusBy(String storeId) {
		return dao.selectMenusBy(storeId);
	}
	
	@Override
	public String[] getProfileImages() {
		// TODO Auto-generated method stub
		return null;
	}


}