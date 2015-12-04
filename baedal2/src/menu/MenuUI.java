package menu;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import global.StdDimention;
import order.OrderUI;
import order.OrderVO;
import store.StoreService;
import store.StoreServiceImpl;
import store.StoreVO;

public class MenuUI extends JFrame implements ActionListener {
//   public static void main(String[] args) {
//      MenuUI ui = new MenuUI();
//      }

   private static final long serialVersionUID = 1L;

   Canvas Canvas;
   JPanel panelNorthImg, panelSouthImg, panelNorthBtn, panelSouthBtn;
   JLabel lblBN, lblImg1, lblImg2,lblImg3,lblImg4,lblImg5,lblImg6,lblImg7,lblImg8;
   JButton btnget1, btnget2, btnget3, btnget4, btnget5, btnget6, btnget7, btnget8;
   JMenu menu;
   JMenuBar bar;
   BufferedReader in;
   List<JButton> btns;
   MenuService service = MenuServiceImpl.getInstance(); 
   MenuVO[] menus = new MenuVO[8];
   List<MenuVO> list = new ArrayList<MenuVO>();
	MenuService menuService = MenuServiceImpl.getInstance();
   MenuDAO dao = new MenuDAO();
   OrderVO order = new OrderVO();
   
   public MenuUI() {
      init();
   }

   private void init() {
      // 부품준비!
	  list = menuService.getMenus(OrderVO.STORE_ID);
	  menus = list.toArray(new MenuVO[list.size()]);
      this.setTitle("배달의 기수");
      this.setLayout(new GridLayout(4, 1)); //4 = 4행 1열?
      btns = new ArrayList<JButton>();
      panelNorthImg = new JPanel();
      panelNorthBtn = new JPanel();
      panelSouthImg = new JPanel();
      panelSouthBtn = new JPanel();
      
    /*  String[] arr = service.getProfileImages();
      for (int i = 0; i < arr.length; i++) {
	//	arr[i] = 
	}*/
      
      URL imageGo1 = getClass().getClassLoader().getResource("images/menu_"+menus[0].getMenuId()+".png");
      ImageIcon icon1 = new ImageIcon(imageGo1);
      URL imageGo2 = getClass().getClassLoader().getResource("images/menu_"+menus[1].getMenuId()+".png");
      ImageIcon icon2 = new ImageIcon(imageGo2);
      URL imageGo3 = getClass().getClassLoader().getResource("images/menu_"+menus[2].getMenuId()+".png");
      ImageIcon icon3 = new ImageIcon(imageGo3);
      URL imageGo4 = getClass().getClassLoader().getResource("images/menu_"+menus[3].getMenuId()+".png");
      ImageIcon icon4 = new ImageIcon(imageGo4);
      URL imageGo5 = getClass().getClassLoader().getResource("images/menu_"+menus[4].getMenuId()+".png");
      ImageIcon icon5 = new ImageIcon(imageGo5);
      URL imageGo6 = getClass().getClassLoader().getResource("images/menu_"+menus[5].getMenuId()+".png");
      ImageIcon icon6 = new ImageIcon(imageGo6);
      URL imageGo7 = getClass().getClassLoader().getResource("images/menu_"+menus[6].getMenuId()+".png");
      ImageIcon icon7 = new ImageIcon(imageGo7);
      URL imageGo8 = getClass().getClassLoader().getResource("images/menu_"+menus[7].getMenuId()+".png");
      ImageIcon icon8 = new ImageIcon(imageGo8);
   
      lblImg1 = new JLabel(icon1);
      lblImg2 = new JLabel(icon2);
      lblImg3 = new JLabel(icon3);
      lblImg4 = new JLabel(icon4);
      lblImg5 = new JLabel(icon5);
      lblImg6 = new JLabel(icon6);
      lblImg7 = new JLabel(icon7);
      lblImg8 = new JLabel(icon8);
      
      btnget1 = new JButton("담기");
      btnget2 = new JButton("담기");
      btnget3 = new JButton("담기");
      btnget4 = new JButton("담기");
      btnget5 = new JButton("담기");
      btnget6 = new JButton("담기");
      btnget7 = new JButton("담기");
      btnget8 = new JButton("담기");
      // 조합!
      
      
      panelNorthImg.add(lblImg1);
      panelNorthImg.add(lblImg2);
      panelNorthImg.add(lblImg3);
      panelNorthImg.add(lblImg4);
      panelSouthImg.add(lblImg5);
      panelSouthImg.add(lblImg6);
      panelSouthImg.add(lblImg7);
      panelSouthImg.add(lblImg8);
      panelNorthBtn.add(btnget1);
      panelNorthBtn.add(btnget2);
      panelNorthBtn.add(btnget3);
      panelNorthBtn.add(btnget4);
      panelSouthBtn.add(btnget5);
      panelSouthBtn.add(btnget6);
      panelSouthBtn.add(btnget7);
      panelSouthBtn.add(btnget8);
      
      panelNorthBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 220, 10)); // 버튼 레이아웃, 판넬에 넣어야함.
      panelSouthBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 220, 10));
      
      btnget1.addActionListener(this);
      btnget2.addActionListener(this);
      btnget3.addActionListener(this);
      btnget4.addActionListener(this);
      btnget5.addActionListener(this);
      btnget6.addActionListener(this);
      btnget7.addActionListener(this);
      btnget8.addActionListener(this);
      // 조합!
      this.add(panelNorthImg);
      this.add(panelNorthBtn);
      this.add(panelSouthImg);
      this.add(panelSouthBtn);
      StdDimention.setPosition(this,1200,600);
   }


   @Override
   public void actionPerformed(ActionEvent e) {
      int price = 0;
      String menuId = "";
      JButton temp = (JButton) e.getSource();
      if (temp.equals(btnget1)) {
    	 OrderVO.MENU_ID = menus[0].getMenuId();
         this.dispose();
         this.repaint();
         OrderUI ui = new OrderUI();
      } else if (temp.equals(btnget2)) {
    	 OrderVO.MENU_ID = menus[1].getMenuId();
         this.dispose();
         this.repaint();
         OrderUI ui = new OrderUI();
      } else if (temp.equals(btnget3)) {
    	 OrderVO.MENU_ID = menus[2].getMenuId();
         this.dispose();
         this.repaint();
         OrderUI ui = new OrderUI();
      }else if (temp.equals(btnget4)) {
         OrderVO.MENU_ID = menus[3].getMenuId();
         this.dispose();
         this.repaint();
         OrderUI ui = new OrderUI();
      }else if (temp.equals(btnget5)) {
         OrderVO.MENU_ID = menus[4].getMenuId();
         this.dispose();
         this.repaint();
         OrderUI ui = new OrderUI();
      }else if (temp.equals(btnget6)) {
         OrderVO.MENU_ID = menus[5].getMenuId();
         this.dispose();
         this.repaint();
         OrderUI ui = new OrderUI();
      }else if (temp.equals(btnget7)) {
    	  OrderVO.MENU_ID = menus[6].getMenuId();
          this.dispose();
          this.repaint();
          OrderUI ui = new OrderUI();
      }else if (temp.equals(btnget8)) {
    	  OrderVO.MENU_ID = menus[7].getMenuId();
          this.dispose();
          this.repaint();
          OrderUI ui = new OrderUI();
      }
   } 
}