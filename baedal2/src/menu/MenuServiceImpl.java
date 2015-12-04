package menu;

import java.util.ArrayList;
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
   public List<MenuVO> getMenus(String storeId) {
	   return dao.selectMenus(storeId);
   }


   @Override
   public int getPrice(String menu) {
      return dao.selectPrice(menu);
   }

	@Override
	public String getMenuName(String storeId) {
		return dao.selectMenuName(storeId);
	}
	
	@Override
	public String[] getProfileImages() {
		// TODO Auto-generated method stub
		return null;
	}


}