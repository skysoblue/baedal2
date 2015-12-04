package store;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import global.StdDimention;
import menu.MenuUI;
import order.OrderVO;

public class StoreUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	protected JButton b1, b2, b3, b4, b5, b6, b7, b8;
	protected JPanel jpSouth, jpNorth, jpTop;
	ImageIcon top1ButtonIcon, top2ButtonIcon, top3ButtonIcon, top4ButtonIcon, top5ButtonIcon, top6ButtonIcon,
			top7ButtonIcon, top8ButtonIcon;
	JButton jb;
	private String id;
	StoreVO vo = new StoreVO();
	OrderVO order = new OrderVO();
	List<StoreVO> list = new ArrayList<StoreVO>();
	StoreService storeService = StoreServiceImpl.getInstance();
	StoreVO[] stores = new StoreVO[8];
	
	public StoreUI() {
		init();
	}

	public void actionPerformed(ActionEvent e) {
		JButton temp = (JButton) e.getSource();
		if (temp.equals(b1)) {
			this.dispose();
			this.repaint();
			OrderVO.STORE_ID = stores[0].getStoreId();
			MenuUI ui = new MenuUI();
		} else if (temp.equals(b2)) {
			this.dispose();
			this.repaint();
			OrderVO.STORE_ID = stores[1].getStoreId();
			MenuUI ui = new MenuUI();
		} else if (temp.equals(b3)) {
			this.dispose();
			this.repaint();
			OrderVO.STORE_ID = stores[2].getStoreId();
			MenuUI ui = new MenuUI();
		} else if (temp.equals(b4)) {
			this.dispose();
			this.repaint();
			OrderVO.STORE_ID = stores[3].getStoreId();
			MenuUI ui = new MenuUI();
		} else if (temp.equals(b5)) {
			this.dispose();
			this.repaint();
			OrderVO.STORE_ID = stores[4].getStoreId();
			MenuUI ui = new MenuUI();
		} else if (temp.equals(b6)) {
			this.dispose();
			this.repaint();
			OrderVO.STORE_ID = stores[5].getStoreId();
			MenuUI ui = new MenuUI();
		} else if (temp.equals(b7)) {
			this.dispose();
			this.repaint();
			OrderVO.STORE_ID = stores[6].getStoreId();
			MenuUI ui = new MenuUI();
		} else if (temp.equals(b8)) {
			this.dispose();
			this.repaint();
			OrderVO.STORE_ID = stores[7].getStoreId();
			MenuUI ui = new MenuUI();
		}
	}

	private void init() {
		list = storeService.getStores(OrderVO.CAT_ID);
		stores = list.toArray(new StoreVO[list.size()]);
		this.setTitle("배달의 기수");
		jpNorth = new JPanel();
		URL imageHan1 = getClass().getClassLoader().getResource("images/"+stores[0].getStoreId()+".png");
		top1ButtonIcon = new ImageIcon(imageHan1);
		b1 = new JButton(top1ButtonIcon);
		b1.setPreferredSize(new Dimension(300, 212));

		URL imageHan2 = getClass().getClassLoader().getResource("images/"+stores[1].getStoreId()+".png");
		top2ButtonIcon = new ImageIcon(imageHan2);
		b2 = new JButton(top2ButtonIcon);
		b2.setPreferredSize(new Dimension(300, 212));

		URL imageHan3 = getClass().getClassLoader().getResource("images/"+stores[2].getStoreId()+".png");
		top3ButtonIcon = new ImageIcon(imageHan3);
		b3 = new JButton(top3ButtonIcon);
		b3.setPreferredSize(new Dimension(300, 212));

		URL imageHan4 = getClass().getClassLoader().getResource("images/"+stores[3].getStoreId()+".png");
		top4ButtonIcon = new ImageIcon(imageHan4);
		b4 = new JButton(top4ButtonIcon);
		b4.setPreferredSize(new Dimension(300, 212));

		jpSouth = new JPanel();
		URL imageHan5 = getClass().getClassLoader().getResource("images/"+stores[4].getStoreId()+".png");
		top5ButtonIcon = new ImageIcon(imageHan5);
		b5 = new JButton(top5ButtonIcon);
		b5.setPreferredSize(new Dimension(300, 212));

		URL imageHan6 = getClass().getClassLoader().getResource("images/"+stores[5].getStoreId()+".png");
		top6ButtonIcon = new ImageIcon(imageHan6);
		b6 = new JButton(top6ButtonIcon);
		b6.setPreferredSize(new Dimension(300, 212));

		URL imageHan7 = getClass().getClassLoader().getResource("images/"+stores[6].getStoreId()+".png");
		top7ButtonIcon = new ImageIcon(imageHan7);
		b7 = new JButton(top7ButtonIcon);
		b7.setPreferredSize(new Dimension(300, 212));

		URL imageHan8 = getClass().getClassLoader().getResource("images/"+stores[7].getStoreId()+".png");
		top8ButtonIcon = new ImageIcon(imageHan8);
		b8 = new JButton(top8ButtonIcon);
		b8.setPreferredSize(new Dimension(300, 212));

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);

		jpNorth.add(b1);
		jpNorth.add(b2);
		jpNorth.add(b3);
		jpNorth.add(b4);
		jpSouth.add(b5);
		jpSouth.add(b6);
		jpSouth.add(b7);
		jpSouth.add(b8);

		this.add(jpNorth, BorderLayout.NORTH);
		this.add(jpSouth, BorderLayout.SOUTH);

		StdDimention.setPosition(this,1200,600);

	}
}

